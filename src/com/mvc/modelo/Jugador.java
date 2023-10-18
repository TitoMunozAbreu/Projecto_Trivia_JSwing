package com.mvc.modelo;

import java.util.Objects;

public class Jugador implements Comparable<Jugador> {
    private int id_jugador;
    private String nombre;
    private String email;
    private String contraseña;
    private int puntos;

    public Jugador(){}

    public Jugador(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.puntos = 0;
    }

    public Jugador(int id_jugador,String nombre, String email, String contraseña, int puntos) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.puntos = puntos;
        this.id_jugador = id_jugador;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador jugador)) return false;
        return getId_jugador() == jugador.getId_jugador() && Objects.equals(getEmail(), jugador.getEmail());
    }


    @Override
    public String toString() {
        return      id_jugador
                + nombre
                + puntos;
    }

    @Override
    public int compareTo(Jugador o) {
        return Integer.compare(o.getPuntos(),this.getPuntos());
    }
}
