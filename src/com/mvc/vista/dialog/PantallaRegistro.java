package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaRegistro extends JDialog {
    private JPanel contentPane;
    private JPanel registroPane;
    private JPanel imagePane;
    private JPanel tituloPane;
    private JPanel FormPane;
    private JTextField nombre;
    private JTextField contraseña;
    private JTextField email;
    private JLabel lblNombre;
    private JLabel lblContraseña;
    private JLabel lblEmail;
    private JButton crearButton;
    private JLabel lbltitulo;
    private JLabel lblTitulo2;
    private JLabel image;
    private JButton buttonOK;
    private JButton buttonCancel;

    public PantallaRegistro() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
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
        PantallaRegistro dialog = new PantallaRegistro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
