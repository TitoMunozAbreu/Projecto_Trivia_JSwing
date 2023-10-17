package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.modelo.Pregunta;
import com.mvc.servicio.JugadorServicio;
import com.mvc.servicio.PreguntaServicio;
import com.mvc.vista.dialog.PantallaPregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import java.util.List;

/**
 * CLASE PREGUNTA CONTROLADOR
 * Gestiona la capa de los componentes de la pantalla pregunta
 */
public class PreguntaControlador extends Component implements ActionListener, WindowListener {
    private PantallaPregunta pantallaPregunta;
    private PreguntaServicio preguntaServicio;
    private JugadorServicio jugadorServicio;
    private String categoria;
    private Jugador jugador;
    private List<Pregunta> preguntas;
    private int tiempoRestante;
    private int preguntaActualIndex;
    private Pregunta pregunta;
    private Timer timer;

    /**
     * CONSTRUCTOR
     * @param categoria
     * @param jugador
     */
    public PreguntaControlador(JugadorServicio jugadorServicio, String categoria, Jugador jugador) {
        //Instanciar variables
        this.preguntaServicio = new PreguntaServicio();
        this.jugadorServicio = jugadorServicio;
        this.categoria = categoria.toLowerCase();
        this.jugador = jugador;
        this.preguntas = this.preguntaServicio.listarPreguntasSegunCategoria(this.categoria);
        this.preguntaActualIndex = 0;

        //inicializar la pantalla pregunta
        this.pantallaPregunta = new PantallaPregunta();
        this.pantallaPregunta.setTitle("Preguntas de categoria: " + categoria);
        //activar los listeners
        addListenesPantallaPregunta();
        //cargar preguntas
        cargarPregunta();
        //configuracion del temporizador
        configurarTemporizador();
        //configurar puntuacion segun jugador
        this.pantallaPregunta.getMoneda().setText(String.valueOf(jugador.getPuntos()));
        this.pantallaPregunta.setVisible(true);

    }

    /**
     * Metodo para establecer un temporizador
     * de cuenta regresiva para responder la pregunta
     */
    private void configurarTemporizador() {
        //establecer tiempo para responder 15sg
        this.tiempoRestante = 15;
        //mostrar el tiempo en la pantallaPregunta
        this.pantallaPregunta.getReloj().setText("" + this.tiempoRestante);

        //conteo de cada segundo
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante--;
                if(tiempoRestante >= 0){
                    pantallaPregunta.getReloj().setText(" " + tiempoRestante);

                }else {
                    timer.stop();
                    //TODO implementar clase sonido, de fallar pregunta
                    JOptionPane.showMessageDialog(
                            PreguntaControlador.this,
                            "¡Vamos explorador! debes responder mas rapido",
                            "Tiempo para responder ha terminado",
                            JOptionPane.ERROR_MESSAGE);
                    cargarSiguientePregunta();
                }
            }
        });
        this.timer.start();
    }

    /**
     * Metodo para cargar la siguiente pregunta
     */
    private void cargarSiguientePregunta() {
        int puntosJugador = this.jugadorServicio.mostrarJugadorPorEmail(this.jugador.getEmail()).getPuntos();
        this.pantallaPregunta.getMoneda().setText(String.valueOf(puntosJugador));
        this.preguntaActualIndex++;
        cargarPregunta();
        configurarTemporizador();

    }

    /**
     * Metodo para cargar la pregunta
     */
    private void cargarPregunta() {
        //desabilitar boton validar
        this.pantallaPregunta.getBtnValidar().setEnabled(false);
        //comprobar si actual indice a superado el tamaño de la lista
        if(preguntaActualIndex < preguntas.size()){
            //obtener el objeto pregunta
            this.pregunta = preguntas.get(preguntaActualIndex);
            //establecer pregunta en pantalla
            pantallaPregunta.getLabelPegunta().setText(pregunta.getPregunta());
            //establecer opciones de respuestas
            pantallaPregunta.getOpcion1().setText(pregunta.getOpciones1());
            pantallaPregunta.getOpcion2().setText(pregunta.getOpciones2());
            pantallaPregunta.getOpcion3().setText(pregunta.getOpciones3());
            pantallaPregunta.getOpcion4().setText(pregunta.getOpciones4());
        }else {
            //TODO implementar clase sonido, de completada la ronda de preguntas
            //detener temporizador
            this.timer.stop();
            //mostrar mensaje por pantalla
            JOptionPane.showMessageDialog(
                    PreguntaControlador.this,
                    "¡Explorador! has finalizo las preguntas de la categoria: " + this.categoria,
                    "Preguntas finalizada",
                    JOptionPane.INFORMATION_MESSAGE);
            //cerrar pantalla pregunta
            this.pantallaPregunta.dispose();
            //TODO, mostrar pantalla de podium

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
        this.pantallaPregunta.addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //alamacenar la opcion de respuesta seleccionada
        int opcionSeleccionada = opcionSeleccionada();
        //almacenar el boton seleccionado
        String command = e.getActionCommand();

        //comprobar boton selecionado
        switch (command){
            case "validar":
                validarRespuesta(opcionSeleccionada);
                break;
        }


    }

    /**
     * Meotod para validar la respuesta seleccionada
     * @param opcionSeleccionada
     */
    private void validarRespuesta(int opcionSeleccionada) {
        this.timer.stop();
        //comprobar respuesta correcta
        if(this.pregunta.getRespuestaCorrecta() == opcionSeleccionada){
            this.timer.stop();
            //sumar puntos
            int puntos = sumarPuntosPorTiempoRespuesta();
            //mostar mensaje al jugador
            JOptionPane.showMessageDialog(
                    PreguntaControlador.this,
                    "¡OLE! sigue así explorador has ganado: " + puntos + " monedas!",
                    "Respuesta Correcta",JOptionPane.INFORMATION_MESSAGE);
            cargarSiguientePregunta();
        }else {
            JOptionPane.showMessageDialog(
                    this,
                    "¡NO has acertado, animo explorador!",
                    "Respuesta Incorrecta",JOptionPane.ERROR_MESSAGE);
            cargarSiguientePregunta();
        }
    }

    private int sumarPuntosPorTiempoRespuesta() {
        int puntos = 0;
        //comprobar si tiempo de respuesta fue entre 0-5 seg
        if(this.tiempoRestante > 10){
            //sumar puntos por rapidez de respuesta al jugador
            this.jugadorServicio.sumarPuntosPorRespuestaRapida(this.jugador);
            puntos = 15;
        }else if(this.tiempoRestante > 1 || this.tiempoRestante < 11){
            this.jugadorServicio.sumarPuntosPorRespuestaCorrecta(this.jugador);
            puntos = 10;
        }
        return puntos;
    }

    public int opcionSeleccionada(){
        Enumeration<AbstractButton> buttonEnumeration = this.pantallaPregunta.getButtonGroup().getElements();
        int opcionSelececcionada = 0;

        while(buttonEnumeration.hasMoreElements()){
            JRadioButton opcionRespuesta = (JRadioButton) buttonEnumeration.nextElement();
            if(opcionRespuesta.isSelected()){
                opcionSelececcionada = Integer.parseInt(opcionRespuesta.getActionCommand());
                this.pantallaPregunta.getBtnValidar().setEnabled(true);
            }
        }
        return opcionSelececcionada;
    }

    public void onClose(){
        //cancelar temporizador
        //cerrar pantalla pregunta
        this.timer.stop();
        this.pantallaPregunta.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
            onClose();
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
