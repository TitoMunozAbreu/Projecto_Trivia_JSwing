package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaAdmin extends JDialog {
    private JPanel contentPane;
    private JButton btnEliminar;
    private JButton buttonCancel;
    private JButton btnEditar;
    private JTextField nombre;
    private JTextField email;
    private JTextField contraseña;
    private JTable table1;
    private JButton btnGuardar;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblEmail;
    private JLabel lblContraseña;
    private JButton btnSalir;

    public PantallaAdmin() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnEliminar);

        btnEliminar.addActionListener(new ActionListener() {
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
        PantallaAdmin dialog = new PantallaAdmin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
