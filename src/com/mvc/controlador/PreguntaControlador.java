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
        //mostrar preguntas y opciones de respuesta
        addPreguntasYRespuestas();
        //inciar temporizador
        //validar respuesta
        this.pantallaPregunta.setVisible(true);
    }

    private void addPreguntasYRespuestas() {
    }

    /**
     * Metodo para activar los listeners
     * de los botones en pantalla
     */
    private void addListenesPantallaPregunta() {
        this.pantallaPregunta.getBtnValidar().addActionListener(this);
        this.pantallaPregunta.getOpcion1().addActionListener(this);
        this.pantallaPregunta.getOpcion2().addActionListener(this);
        this.pantallaPregunta.getOpcion3().addActionListener(this);
        this.pantallaPregunta.getOpcion4().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public void onClose(){
        //cancelar temporizador
        //cerrar pantalla pregunta
        this.pantallaPregunta.dispose();
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
