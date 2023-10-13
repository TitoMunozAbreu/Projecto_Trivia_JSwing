package com.mvc.servicio;

import com.mvc.modelo.Pregunta;
import com.mvc.repositorio.PreguntaRepositorio;

import java.util.List;

public class PreguntaServicio {
    private PreguntaRepositorio pr;

    public PreguntaServicio(){
        this.pr = new PreguntaRepositorio();
    }

    //validar preguntar devuelve boolean
    public void esCorrecta(Pregunta pregunta, String respuesta){
        //TODO comprobar si la respuesta de la pregunta realizada es correta
    }

    /**
     * Metodo que devuelve el listado de preguntas
     * segun la categoria
     * @return
     */
    public List<Pregunta> listarPreguntasSegunCategoria(String categoria) {
        return this.pr.listarPreguntasSegunCategoria(categoria);
    }

    //
}
