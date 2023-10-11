package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.vista.dialog.PantallaPregunta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * CLASE PREGUNTA CONTROLADOR
 * Gestiona la capa de los componentes de la pantalla pregunta
 */
public class PreguntaControlador implements ActionListener, WindowListener {
    private PantallaPregunta pantallaPregunta;

    public PreguntaControlador(String categoria, Jugador jugador) {
        this.pantallaPregunta = new PantallaPregunta();
        //activar los listeners
        addListenesPantallaPregunta();
        this.pantallaPregunta.setVisible(true);
    }

    private void addListenesPantallaPregunta() {
        this.pantallaPregunta.getBtnValidar().addActionListener(this);
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
