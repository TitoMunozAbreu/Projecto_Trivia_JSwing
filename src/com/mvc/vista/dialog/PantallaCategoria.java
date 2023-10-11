package com.mvc.vista.dialog;

import javax.swing.*;
import java.awt.event.*;

public class PantallaCategoria extends JDialog {
    private JPanel contentPane;
    private JButton btnCultura;
    private JButton btnMonumentos;
    private JButton btnHistoria;
    private JLabel lblTitulo;
    private JLabel lblTitulo2;
    private JPanel tituloPane;
    private JPanel btnsPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public PantallaCategoria() {
        setContentPane(contentPane);
        setModal(true);
        setSize(400,300);
        //getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
