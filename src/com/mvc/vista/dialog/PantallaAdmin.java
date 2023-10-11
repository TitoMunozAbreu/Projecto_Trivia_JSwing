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
        setSize(500,450);
        setLocationRelativeTo(null);
        //getRootPane().setDefaultButton(btnEliminar);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

}
