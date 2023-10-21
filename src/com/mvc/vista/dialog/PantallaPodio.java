package com.mvc.vista.dialog;

import javax.swing.*;

public class PantallaPodio extends JDialog {
    private JPanel contentPane;
    private JButton btnSalir;
    private JButton btnVolverJugar;
    private JPanel rPane;
    private JTable podioTable;
    private JPanel resultadoPane;
    private JPanel tituloPane;
    private JLabel lblTitulo;
    private JPanel datosPane;
    private JLabel resultado;
    private JPanel headerPane;
    private JLabel lblPodio;
    private JPanel tablePane;
    private JPanel btnPane;
    private JPanel bPane;

    public PantallaPodio() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnSalir);
        setSize(450,350);
        ImageIcon imageIcon = new ImageIcon("src/com/recursos/images/azulejos.png");
        setIconImage(imageIcon.getImage());
        setTitle("Resultados del juego");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnVolverJugar() {
        return btnVolverJugar;
    }

    public JTable getPodioTable() {
        return podioTable;
    }

    public JLabel getResultado() {
        return resultado;
    }
}
