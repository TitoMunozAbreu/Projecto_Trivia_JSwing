package com.mvc.modelo;

public class Jugador {
    private int id_jugador;
    private String nombre;
    private String email;
    private String contraseña;
    private int puntos;

    static int num = 1;

    public Jugador(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.puntos = 0;
        setId();
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId() {
        this.id_jugador = Jugador.num++;
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
    public String toString() {
        return      id_jugador
                + nombre
                + puntos;
    }
}
