package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaRespuesta extends JDialog {
    private JPanel contentPane;
    private JButton btnFinalizar;
    private JButton btnContinuar;
    private JPanel btnPane;
    private JPanel headerPane;
    private JPanel respuestaPane;
    private JLabel lblRespuesta;
    private JLabel lblTitulo;
    private JPanel tituloPane;

    public PantallaRespuesta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnFinalizar);

        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PantallaRespuesta dialog = new PantallaRespuesta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
