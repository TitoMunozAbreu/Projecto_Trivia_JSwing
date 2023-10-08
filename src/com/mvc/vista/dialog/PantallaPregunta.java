package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaPregunta extends JDialog {
    private JPanel contentPane;
    private JPanel puntosRelojPane;
    private JLabel labelPegunta;
    private JPanel preguntaPane;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JButton btnValidar;
    private JLabel iconMoneda;
    private JLabel moneda;
    private JLabel iconReloj;
    private JLabel reloj;
    private JButton buttonOK;
    private JButton buttonCancel;

    public PantallaPregunta() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

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
        PantallaPregunta dialog = new PantallaPregunta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
