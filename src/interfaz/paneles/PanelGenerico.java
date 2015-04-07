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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Adrián
 */
public class PanelGenerico extends JPanel {
    
    private JTextArea jtArea;
    private final String titulo;
//    private JButton jbGuardar;
    
    public PanelGenerico (String titulo) {
        this.titulo = titulo;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(getBackground(), 5));
        initComponents();
    }
    
    private void initComponents() {
        jtArea = new JTextArea(10, 35);
        JScrollPane panelCentro = new JScrollPane(getJtArea());
        panelCentro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelCentro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Font fuente = new Font("Arial", Font.ITALIC, 15);
        getJtArea().setFont(fuente);
        getJtArea().setCaretColor(Color.GREEN);
        getJtArea().setBackground(Color.BLACK);
        getJtArea().setForeground(Color.GREEN);
        getJtArea().setEditable(false);
//        jbGuardar = new JButton("Guardar");
//        JPanel panelSur = new JPanel();
//        panelSur.add(jbGuardar);
        JLabel label = new JLabel(titulo);
        label.setFont(new Font("arial", Font.BOLD, 15));
        add(label, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
//        add(panelSur, BorderLayout.SOUTH);
    }

    /**
     * @return the jtArea
     */
    public JTextArea getJtArea() {
        return jtArea;
    }
    
}
