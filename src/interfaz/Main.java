/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import interfaz.paneles.Menu;
import interfaz.paneles.PanelPrincipal;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import javax.swing.UnsupportedLookAndFeelException;
import listener.Listener;

/**
 *
 * @author Adrián
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame f = new JFrame(//"Hola chabo"
                "Compilador de Objective-C");
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            System.out.println("Bale berga la bida, chabo");
        }
        PanelPrincipal panel = new PanelPrincipal();
        Menu menu = new Menu();
        Listener listener = new Listener(panel);
        menu.addEventos(listener);
        panel.addEventos(listener);
        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
//        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.toFront();
        f.setResizable(false);
        f.setDefaultCloseOperation(3);
        f.setJMenuBar(menu);
        f.setContentPane(panel);
        f.setVisible(true);

    }

}
