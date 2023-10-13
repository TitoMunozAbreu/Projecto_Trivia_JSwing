package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.modelo.Pregunta;
import com.mvc.servicio.PreguntaServicio;
import com.mvc.vista.dialog.PantallaPregunta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * CLASE PREGUNTA CONTROLADOR
 * Gestiona la capa de los componentes de la pantalla pregunta
 */
public class PreguntaControlador implements ActionListener, WindowListener {
    private PantallaPregunta pantallaPregunta;
    private PreguntaServicio preguntaServicio;
    private String categoria;
    private Jugador jugador;

    public PreguntaControlador(String categoria, Jugador jugador) {
        //Instanciar variables
        this.preguntaServicio = new PreguntaServicio();
        this.categoria = categoria.toLowerCase();
        this.jugador = jugador;
        System.out.println(categoria);
        System.out.println(jugador.getNombre());

        //inicializar la pantalla pregunta
        this.pantallaPregunta = new PantallaPregunta();
        System.out.println("pantalla pregunta");
        //activar los listeners
        addListenesPantallaPregunta();
        //mostrar preguntas y opciones de respuesta
        addPreguntasYRespuestas();
        //inciar temporizador
        setTemporizador();
        //validar respuesta
        this.pantallaPregunta.setVisible(true);
    }

    private void setTemporizador() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            int contador = 2000;
            @Override
            public void run() {
                do{
                    addPreguntasYRespuestas();
                }while(contador > 0);

            }
        };

    }

    private void addPreguntasYRespuestas() {
        System.out.println("metodos añadir preguntas");
        //almacenar las preguntas segun categoria
        List<Pregunta> preguntas = this.preguntaServicio.listarPreguntasSegunCategoria(this.categoria);

        //iterar sobre la lista de preguntas
        for (Pregunta pregunta: preguntas){
            System.out.println("iterar sobre pregunta" + pregunta.getPregunta());
            //establecer pregunta en pantalla
            this.pantallaPregunta.getLabelPegunta().setText(pregunta.getPregunta());
            //establecer posibles respuestas
            this.pantallaPregunta.getOpcion1().setText(pregunta.getOpciones1());
            this.pantallaPregunta.getOpcion2().setText(pregunta.getOpciones2());
            this.pantallaPregunta.getOpcion3().setText(pregunta.getOpciones3());
            this.pantallaPregunta.getOpcion4().setText(pregunta.getOpciones4());

        }

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
