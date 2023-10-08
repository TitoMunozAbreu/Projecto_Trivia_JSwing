package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaPodio extends JDialog {
    private JPanel contentPane;
    private JButton btnSalir;
    private JButton btnVolverJugar;
    private JPanel rPane;
    private JTable rankingTable;
    private JPanel resultadoPane;
    private JPanel tituloPane;
    private JLabel lblTitulo;
    private JPanel datosPane;
    private JLabel resultado;
    private JPanel headerPane;
    private JLabel lblRanking;
    private JPanel tablePane;
    private JPanel btnPane;

    public PantallaPodio() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnSalir);

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnVolverJugar.addActionListener(new ActionListener() {
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
        PantallaPodio dialog = new PantallaPodio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
