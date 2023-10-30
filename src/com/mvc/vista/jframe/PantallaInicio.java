package com.mvc.vista.jframe;

import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.swing.*;

public class PantallaInicio extends JFrame{
    private JPanel contentPane;
    private JPanel imagePane;
    private JPanel homePane;
    private JPanel titlePane;
    private JPanel inicioPane;
    private JTextField email;
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
    private JPanel validationPane;
    private JPanel usuarioPane;
    private JPanel btnPane;
    private ValidationPanel validacionPanel;
    private JLabel lblRecuperar;


    public PantallaInicio(){
        setContentPane(contentPane);
        setTitle("Sevilla Trivia");
        ImageIcon imageIcon = new ImageIcon("src/com/recursos/images/azulejos.png");
        setIconImage(imageIcon.getImage());
        setSize(570,610);
        setLocationRelativeTo(null);
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getContraseña() {
        return contraseña;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnAdmin() {
        return btnAdmin;
    }

    public ValidationPanel getValidacionPanel() {
        return validacionPanel;
    }

    public JLabel getLblRecuperar() {
        return lblRecuperar;
    }
}
