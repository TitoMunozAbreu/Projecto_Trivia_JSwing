package com.mvc.vista.dialog;

import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.swing.*;

public class PantallaAdmin extends JDialog {
    private JPanel contentPane;
    private JButton btnEliminar;
    private JButton btnEditar;
    private JTextField nombre;
    private JTextField email;
    private JTextField contraseña;
    private JTable tablaJugadores;
    private JButton btnActualizar;
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
    private ValidationPanel validacionPanel;

    public PantallaAdmin() {
        setContentPane(contentPane);
        setModal(true);
        setSize(500,450);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnSalir);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getContraseña() {
        return contraseña;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JTable getTablaJugadores() {
        return tablaJugadores;
    }

    public JPanel getTablaPane() {
        return tablaPane;
    }

    public ValidationPanel getValidacionPanel() {
        return validacionPanel;
    }
}
