/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import listener.Listener;

/**
 *
 * @author Adrián
 */
public class PanelPrincipal extends JPanel {

    private JButton jbCompilar;
    private JButton jbLimpiarArea;
    private JTextArea jtAreaCodigo;
    private JTextArea jtAreaLineas;
    private final PanelGenerico panelLexico;
    private final PanelGenerico panelError;
    private final PanelGenerico panelSintactico;

    public PanelPrincipal() {
        panelLexico = new PanelGenerico("Resultado tokens");
        panelError = new PanelGenerico("Errores");
        panelSintactico = new PanelGenerico("Resultado Sintáctico");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(getBackground(), 5));
        initComponents();
    }

    public void addEventos(Listener l) {
        jbCompilar.addActionListener(l);
        jbLimpiarArea.addActionListener(l);
        jtAreaCodigo.addKeyListener(l);
    }

    private void initComponents() {
        //Iniciar botones
        jbCompilar = new JButton("Compilar");
        jbCompilar.setEnabled(false);
        jbLimpiarArea = new JButton("Limpiar Area");

        //Iniciar areas de texto principales
        jtAreaCodigo = new JTextArea(10, 40);
        jtAreaLineas = new JTextArea(10, 3);

        //Se crea el panel que contendrá las 2 areas en un solo panel
        JPanel centro = new JPanel(new BorderLayout(2, 0));
        centro.setBorder(BorderFactory.createLineBorder(getBackground(), 5));

        //Diversas ondas de las areas de texto
        Font fuente = new Font("Arial", Font.ITALIC, 15);
        getJtAreaCodigo().setFont(fuente);
        getJtAreaCodigo().setCaretColor(Color.GREEN);
        getJtAreaCodigo().setBackground(Color.BLACK);
        getJtAreaCodigo().setForeground(Color.GREEN);
        getJtAreaCodigo().setEditable(true);
        getJtAreaLineas().setFont(fuente);
        getJtAreaLineas().setCaretColor(Color.GREEN);
        getJtAreaLineas().setBackground(Color.BLACK);
        getJtAreaLineas().setForeground(Color.GREEN);
        getJtAreaLineas().setEditable(false);

        //Se agregan las areas
        centro.add(getJtAreaLineas(), BorderLayout.WEST);
        centro.add(getJtAreaCodigo(), BorderLayout.CENTER);

        //Panel para los botones del texto
        JPanel pS = new JPanel();
        pS.add(jbCompilar);
        pS.add(new JLabel(""));
        pS.add(jbLimpiarArea);

        //Panel que los une
        JScrollPane panelTexto = new JScrollPane(centro);
        panelTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Panel central
        JPanel panelCentro = new JPanel();
        JLabel label = new JLabel("Código");
        label.setFont(new Font("arial", Font.BOLD, 15));
        panelCentro.setLayout(new BorderLayout());
        panelCentro.add(label, BorderLayout.NORTH);
        panelCentro.add(panelTexto, BorderLayout.CENTER);
        panelCentro.add(pS, BorderLayout.SOUTH);

        //Resto de paneles
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBorder(BorderFactory.createLineBorder(getBackground(), 5));
        panelSur.add(getPanelError(), BorderLayout.EAST);
        panelSur.add(getPanelSintactico(), BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);
        add(getPanelLexico(), BorderLayout.EAST);
        add(panelSur, BorderLayout.SOUTH);
    }
    
    public void activarBoton(boolean estado) {
        jbCompilar.setEnabled(estado);
    }

    /**
     * @return the jtAreaCodigo
     */
    public JTextArea getJtAreaCodigo() {
        return jtAreaCodigo;
    }

    /**
     * @return the jtAreaLineas
     */
    public JTextArea getJtAreaLineas() {
        return jtAreaLineas;
    }

    /**
     * @return the panelLexico
     */
    public PanelGenerico getPanelLexico() {
        return panelLexico;
    }

    /**
     * @return the panelError
     */
    public PanelGenerico getPanelError() {
        return panelError;
    }

    /**
     * @return the panelSintactico
     */
    public PanelGenerico getPanelSintactico() {
        return panelSintactico;
    }

}
