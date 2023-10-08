package com.mvc.vista.jframe;

import javax.swing.*;

public class PantallaInicio extends JFrame{
    private JPanel contentPane;
    private JPanel imagePane;
    private JPanel homePane;
    private JPanel titlePane;
    private JPanel btnsPane;
    private JTextField nombre;
    private JTextField contraseña;
    private JButton btnIniciar;
    private JButton btnRegistrar;
    private JLabel lblContraseña;
    private JLabel lblNombre;
    private JButton btnAdmin;
    private JLabel lblTitulo;
    private JLabel image;
    private JLabel lblTitulo2;
    private JLabel lblTitulo3;

    public PantallaInicio(){
        setContentPane(contentPane);
        setSize(550,500);
        setLocationRelativeTo(null);


    }

}
