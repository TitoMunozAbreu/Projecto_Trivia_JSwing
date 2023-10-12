package com.mvc.repositorio;

import com.mvc.modelo.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class PreguntaRepositorio {
    private List<Pregunta> preguntas;

    public PreguntaRepositorio(){
        preguntas = new ArrayList<>();
                this.preguntas.add(new Pregunta(
                        "¿Qué famoso explorador partió desde Sevilla en su viaje al Nuevo Mundo en 1492?",
                        List.of(
                                "Cristóbal Colón",
                                "Vasco da Gama",
                                "Fernando Magallanes",
                                "Hernán Cortés"
                        ),
                        0,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Para qué se utilizaba originalmente la Giralda, una famosa torre en Sevilla?",
                        List.of(
                                "Para observar estrellas",
                                "Para anunciar la hora",
                                "Para hacer señales de humo",
                                "Para almacenar alimentos"
                        ),
                        1,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿En cuál de estos ríos está situada la ciudad de Sevilla?",
                        List.of(
                                "Río Amazonas",
                                "Río Nilo",
                                "Río Guadalquivir",
                                "Río Misisipi"
                        ),
                        2,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Qué acontecimiento histórico ocurrió en 1992 en Sevilla?",
                        List.of(
                                "Descubrimiento de Américan",
                                "Juegos Olímpicos",
                                "Exposición Universal",
                                "Revolución Industrial"
                        ),
                        2,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Cuál fue la primera civilización que habitó la región donde hoy se encuentra Sevilla?",
                        List.of(
                                "Tartesos",
                                "Árabes",
                                "Romanos",
                                "Vikingos"
                        ),
                        0,
                        "historia"
                ));
    }
    //crear preguntas
    public void crearPregunta(){
        //TODO crear todas las instancias de preguntas.
    }

    //Lista de preguntas preguntas
    public void listarPreguntasSegunCategoria(String categoria){
        //TODO listado de preguntas,
    }

    //
}
