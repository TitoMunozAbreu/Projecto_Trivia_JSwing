package com.mvc.vista.dialog;

import javax.swing.*;

public class PantallaPregunta extends JDialog {
    private JPanel contentPane;
    private JPanel puntosRelojPane;
    private JLabel labelPegunta;
    private JPanel preguntaPane;
    private ButtonGroup buttonGroup;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private JRadioButton opcion4;
    private JButton btnValidar;
    private JLabel iconMoneda;
    private JLabel moneda;
    private JLabel iconReloj;
    private JLabel reloj;
    private JButton btnCategoria;

    public PantallaPregunta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnValidar);
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //inicializar buttonGroup
        this.buttonGroup = new ButtonGroup();
        //añadir button group
        this.buttonGroup.add(opcion1);
        this.buttonGroup.add(opcion2);
        this.buttonGroup.add(opcion3);
        this.buttonGroup.add(opcion4);



    }

    public JLabel getLabelPegunta() {
        return labelPegunta;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public JRadioButton getOpcion1() {
        return opcion1;
    }

    public JRadioButton getOpcion2() {
        return opcion2;
    }

    public JRadioButton getOpcion3() {
        return opcion3;
    }

    public JRadioButton getOpcion4() {
        return opcion4;
    }

    public JButton getBtnValidar() {
        return btnValidar;
    }

    public JLabel getMoneda() {
        return moneda;
    }

    public JLabel getReloj() {
        return reloj;
    }


}
