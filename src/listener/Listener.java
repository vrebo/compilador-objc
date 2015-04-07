/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import compilador.AnalizadorSemantico;
import compilador.Compilador;
import compilador.ParseException;
import interfaz.paneles.PanelPrincipal;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.CodigoFuente;

/**
 *
 * @author Adrián
 */
public class Listener extends KeyAdapter implements ActionListener {

    private final PanelPrincipal panel;
    private CodigoFuente codigoFuente;

    public Listener(PanelPrincipal panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Abrir":
                abrir();
                 {
                    try {
                        llenarLineas();
                        verifica();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                break;
            case "Guardar":
                guardar();
                break;
            case "Compilar":
                if (codigoFuente == null) {
                    guardar();
                } else {
                    if (codigoFuente.isModificado()) {
                        salvar();
                    }
                }
                compilar();
                break;
            case "Limpiar Area":
                limpiar();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (codigoFuente != null) {
            codigoFuente.setModificado(true);
        }
        try {
            llenarLineas();
            verifica();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void llenarLineas() throws Exception {
        int cantidadLineas = panel.getJtAreaCodigo().getLineCount();
        String lineas = "";
        for (int i = 0; i < cantidadLineas; i++) {
            lineas += (i + 1) + "\n";
        }
        panel.getJtAreaLineas().setText(lineas);
    }

    private void verifica() throws Exception {
        if (!isEmpty()) {
            panel.activarBoton(true);
        } else {
            panel.activarBoton(false);
        }
    }

    private boolean isEmpty() {
        return panel.getJtAreaCodigo().getText().length() == 0;
    }

    private void limpiar() {
        panel.getJtAreaCodigo().setText("");
        panel.getJtAreaLineas().setText("");
        panel.getPanelError().getJtArea().setText("");
        panel.getPanelLexico().getJtArea().setText("");
        panel.getPanelSintactico().getJtArea().setText("");
        try {
            llenarLineas();
            verifica();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void guardar() throws HeadlessException {
        try {
            JFileChooser chooser = new JFileChooser();
            String texto = panel.getJtAreaCodigo().getText();
//            String[] lineas = texto.split("[\n]+");
            int n = chooser.showSaveDialog(null);
            if (n == JFileChooser.APPROVE_OPTION) {
                codigoFuente = new CodigoFuente(chooser.getSelectedFile());
                PrintWriter pw = new PrintWriter(codigoFuente.getArchivo());
//                for (String linea : lineas) {
//                    pw.println(linea);
//                    pw.flush();
//                }
                pw.write(texto);
                pw.flush();
                JOptionPane.showMessageDialog(null,
                        "Archivo guardado exitosamente");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex + "\n" + ex.getMessage());
        }
    }

    private void salvar() {
        try (PrintWriter pw = new PrintWriter(codigoFuente.getArchivo())) {
            String texto = panel.getJtAreaCodigo().getText();
            pw.write(texto);
            pw.flush();
        } catch (FileNotFoundException ex) {
            System.err.println("Problema al guardar el código fuente.");
        }
    }

    private void abrir() throws HeadlessException {
        try {
            JFileChooser chooser = new JFileChooser();
            StringBuilder sb = new StringBuilder();
            int n = chooser.showOpenDialog(null);
            if (n == JFileChooser.APPROVE_OPTION) {
                codigoFuente = new CodigoFuente(chooser.getSelectedFile());
                BufferedReader br = new BufferedReader(new FileReader(codigoFuente.getArchivo()));
                do {
                    sb.append(br.readLine()).append("\n");
                } while (br.ready());
                panel.getJtAreaCodigo().setText(sb.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex + "\n" + ex.getMessage());
        }
    }

    private void compilar() {
        try {
            Compilador compilador = new Compilador(codigoFuente.getArchivo());
            compilador.unidadCompilacion();
            String analisisLexico = Compilador.getLogAnalisisLexico().toString();
            panel.getPanelLexico().getJtArea().setText(analisisLexico);
            String analisisSintactico = Compilador.getLogAnalisisSintactico().toString();
            panel.getPanelSintactico().getJtArea().setText(analisisSintactico);
            
            //CAMBIAR EL NOMBRE EL PANEL
            String errores = Compilador.getLogAnalisisSemantico().toString();
            panel.getPanelError().getJtArea().setText(errores);
            AnalizadorSemantico analizadorSemantico = new AnalizadorSemantico(panel.getJtAreaCodigo().getText());
            analizadorSemantico.ejecutarAnalisisSemantico(panel);
        } catch (FileNotFoundException ex) {
            System.err.println(
                    "Problema al acceder al archivo de código fuente.\n " + ex);
        } catch (ParseException ex) {
            System.err.println("Tu código produce excepciones de parseo");
        }
    }

}
