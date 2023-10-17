package com.mvc.servicio;

import com.mvc.modelo.Jugador;
import com.mvc.repositorio.JugadorRepositorio;

import java.util.List;

/**
 * CLASE JUGADOR SERVICIO
 */
public class JugadorServicio {
    private JugadorRepositorio jugadorRepositorio;

    public JugadorServicio(){
        this.jugadorRepositorio = new JugadorRepositorio();
    }

    /**
     * Metodo para autenticar jugador
     * @param email
     * @param contraseña
     * @return
     */
    public boolean autenticarJugador(String email, String contraseña) {
        return this.jugadorRepositorio.estaRegistradoJugador(email, contraseña);
    }

    /**
     * Metodo para mostrar
     * @param email
     * @return
     */
    public Jugador mostrarJugadorPorEmail(String email) {
        return  this.jugadorRepositorio.mostrarJugadorPorEmail(email);
    }

    public boolean crearJugador(Jugador nuevoJugador) {
        return this.jugadorRepositorio.crearJugador(nuevoJugador);
    }

    public void sumarPuntosPorRespuestaRapida(Jugador jugador) {
        this.jugadorRepositorio.sumarPuntosPorRespuestaRapida(jugador);
    }

    public void sumarPuntosPorRespuestaCorrecta(Jugador jugador) {
        this.jugadorRepositorio.sumarPuntosPorRespuestaCorrecta(jugador);

    }

    public List<Jugador> mostrarJugadores() {
        return this.jugadorRepositorio.mostrarJugadores();
    }

    public boolean eliminarJugador(Jugador jugadorSeleccionado) {
        return this.jugadorRepositorio.eliminarJugador(jugadorSeleccionado);
    }

    public boolean actualizarJugador(Jugador nuevoJugador, String emailJugadorSeleccionado) {
        return this.jugadorRepositorio.actualizarJugador(nuevoJugador, emailJugadorSeleccionado);
    }
}
