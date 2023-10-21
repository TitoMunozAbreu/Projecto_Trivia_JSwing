package com.mvc.vista.dialog;

import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.swing.*;

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
    private JButton btnCrear;
    private JLabel lbltitulo;
    private JLabel lblTitulo2;
    private JLabel image;
    private ValidationPanel validacionPanel;
    private JButton btnHome;

    public PantallaRegistro() {
        //definir las especificaciones de la pantalla
        setContentPane(contentPane);
        setModal(true);
        ImageIcon imageIcon = new ImageIcon("src/com/recursos/images/azulejos.png");
        setIconImage(imageIcon.getImage());
        setTitle("Registrar | nuevo explorador");
        setSize(480,510);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnCrear);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getContraseña() {
        return contraseña;
    }

    public JTextField getEmail() {
        return email;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public ValidationPanel getValidacionPanel() {
        return validacionPanel;
    }
}
