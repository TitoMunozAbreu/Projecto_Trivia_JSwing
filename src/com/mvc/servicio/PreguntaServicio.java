package com.mvc.servicio;

import com.mvc.modelo.Pregunta;
import com.mvc.repositorio.PreguntaRepositorio;

public class PreguntaServicio {
    private PreguntaRepositorio pr;

    public PreguntaServicio(){
        this.pr = new PreguntaRepositorio();
    }

    //validar preguntar devuelve boolean
    public void esCorrecta(Pregunta pregunta, String respuesta){
        //TODO comprobar si la respuesta de la pregunta realizada es correta
    }

    //
}
