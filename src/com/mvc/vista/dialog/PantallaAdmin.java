package com.mvc.vista.dialog;

import javax.swing.*;

public class PantallaAdmin extends JDialog {
    private JPanel contentPane;
    private JButton btnEliminar;
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
    private JPanel btnPane;
    private JPanel tablaPane;
    private JPanel modificarPane;
    private JPanel tituloPane;
    private JPanel datosPane;
    private JPanel camposPane;
    private JPanel GuardarPane;

    public PantallaAdmin() {
        setContentPane(contentPane);
        setModal(true);
        setSize(500,450);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnSalir);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }



}
