package com.mvc.vista.dialog;

import javax.swing.*;

public class PantallaCategoria extends JDialog {
    private JPanel contentPane;
    private JButton btnJugar;
    private JLabel lblTitulo;
    private JPanel tituloPane;
    private JPanel btnsPane;
    private JButton btnHome;
    private JComboBox comboBox;
    private JLabel lblTitulo2;
    private JPanel RegresarPane;
    private JPanel todoPane;


    public PantallaCategoria() {
        setContentPane(contentPane);
        setModal(true);
        setSize(350,350);
        setLocationRelativeTo(null);
        //getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public JButton getBtnJugar() {
        return btnJugar;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
