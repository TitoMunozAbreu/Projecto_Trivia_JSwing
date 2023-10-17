package com.mvc.repositorio;

import com.mvc.modelo.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class PreguntaRepositorio {
    private List<Pregunta> preguntas;

    /**
     * CONSTRUCTOR
     */
    public PreguntaRepositorio(){
        preguntas = new ArrayList<>();
                this.preguntas.add(new Pregunta(
                        "¿Qué famoso explorador partió desde Sevilla en su viaje alrededor del mundo en 1519?",
                        "Cristóbal Colón",
                        "Vasco da Gama",
                        "Fernando Magallanes",
                        "Hernán Cortés",
                        3,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Para qué se utilizaba originalmente la Giralda, una famosa torre en Sevilla?",
                        "Para observar estrellas",
                        "Para anunciar la hora",
                        "Para hacer señales de humo",
                        "Para almacenar alimentos",
                        2,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Cuál de estos ríos pertenece a la ciudad de Sevilla?",
                        "Río Amazonas",
                        "Río Nilo",
                        "Río Guadalquivir",
                        "Río Misisipi",
                        3,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Qué acontecimiento histórico ocurrió en 1992 en Sevilla?",
                        "Descubrimiento de Américan",
                        "Juegos Olímpicos",
                        "Exposición Universal",
                        "Revolución Industrial",
                        3,
                        "historia"
                ));
                this.preguntas.add(new Pregunta(
                        "¿Cuál fue la primera civilización que habitó la región donde hoy se encuentra Sevilla?",
                        "Tartesos",
                        "Árabes",
                        "Romanos",
                        "Vikingos",
                        1,
                        "historia"
                ));
        this.preguntas.add(new Pregunta(
                "¿Qué monumento de Sevilla tiene una torre que fue originalmente construida como minarete?",
                "La Giralda",
                "La Catedral de Sevilla",
                "El Alcázar",
                "Plaza de España",
                1,
                "monumentos"
        ));
        this.preguntas.add(new Pregunta(
                "¿Qué lugar es famoso por su arquitectura con azulejos y canales?",
                "La Giralda",
                "La Catedral de Sevilla",
                "El Alcázar",
                "Plaza de España",
                4,
                "monumentos"
        ));
        this.preguntas.add(new Pregunta(
                "¿Cuál es la plaza más grande de Sevilla?",
                "Plaza de América",
                "Plaza de España",
                "Plaza Nueva",
                "Plaza de San Francisco",
                2,
                "monumentos"
        ));
        this.preguntas.add(new Pregunta(
                "¿Cuál de estos monumentos es conocido por su estructura que imita a una gota de agua?",
                "La Giralda",
                "La Catedral de Sevilla",
                "El Alcázar",
                "Metropol Parasol",
                4,
                "monumentos"
        ));
        this.preguntas.add(new Pregunta(
                "¿Qué edificio es famoso por sus arcos y patios con azulejos coloridos?",
                "La Giralda",
                "La Catedral de Sevilla",
                "El Alcázar",
                "Plaza de España",
                3,
                "monumentos"
        ));
        this.preguntas.add(new Pregunta(
                "¿Qué gran celebración se lleva a cabo en Sevilla con desfiles y pasos religiosos?",
                "Carnaval de Cádiz",
                "Feria de Abril",
                "Semana Santa",
                "Día de los Muertos",
                3,
                "cultura"
        ));
        this.preguntas.add(new Pregunta(
                "¿Cómo se llama el traje tradicional que se usa en la Feria de Abril?",
                "Traje de Flamenca",
                "Traje de Cóctel",
                "Traje de Gala",
                "Traje de Baño",
                1,
                "cultura"
        ));
        this.preguntas.add(new Pregunta(
                "¿Qué celebración es conocida por tener personas vestidas con túnicas y capirotes de colores?",
                "Feria de Abril",
                "Semana Santa",
                "Carnaval de Cádiz",
                "Navidad",
                2,
                "cultura"
        ));
        this.preguntas.add(new Pregunta(
                "¿Cuál es la música tradicional y característica de la cultura andaluza?",
                "Sardana",
                "Flamenco",
                "Jota",
                "Cha-Cha-Cha",
                2,
                "cultura"
        ));
        this.preguntas.add(new Pregunta(
                "¿Qué actividad es muy popular durante la Feria de Abril?",
                "Bailar la macarena",
                "Bañarse en el rio",
                "Comer bueñuelo",
                "Montar en el Jaguar",
                3,
                "cultura"
        ));
        }
    //crear preguntas
    public void crearPregunta(){
        //TODO crear todas las instancias de preguntas.
    }

    /**
     * Metodo que devuelve el listado de preguntas
     * segun la categoria
     * @return
     */
    public List<Pregunta> listarPreguntasSegunCategoria(String categoria){
        return this.preguntas
                .stream()
                .filter(pregunta -> pregunta.getCategoria().equals(categoria))
                .toList();
    }

    //
}
