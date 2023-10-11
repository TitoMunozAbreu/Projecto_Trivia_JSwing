package com.mvc.repositorio;

import com.mvc.modelo.Jugador;

import java.util.List;

public class JugadorRepositorio {

    private List<Jugador> jugadores;

    public JugadorRepositorio(){
        jugadores = List.of(
                new Jugador("Papaya", "papaya@mail.com","1234")
        );
    }

    //listar jugadores
    public List<Jugador> mostrarJugadores(){
        return jugadores;
    }
    //mostrar jugador
    public Jugador mostrarJugadorPorEmail(String email){
        return mostrarJugadores().
                stream()
                .filter(j -> j.getEmail().equals(email))
                .findFirst().get();
    }
    //crear jugador
    public boolean crearJugador(Jugador nuevoJugador){
        boolean estaCreado = false;

        //comprobar si el jugador existe
        boolean existeJugador = mostrarJugadores()
                .stream()
                .filter(jugador -> jugador.getEmail().equals(nuevoJugador.getEmail()))
                .findFirst().isPresent();

        //crear jugador
        if(!existeJugador){
            jugadores.add(nuevoJugador);
            estaCreado = true;
        }

        return estaCreado;
    }

    /**
     * Metodo para comprobar que el jugador
     * @param email
     * @param contraseña
     * @return
     */
    public boolean estaRegistradoJugador(String email, String contraseña) {
        return  this.mostrarJugadores()
                .stream()
                .filter(jugador ->
                        jugador.getEmail().equals(email) && jugador.getContraseña().equals(contraseña))
                .findFirst().isPresent();
    }
    //actualizar jugador

    //eliminar jugador

}
