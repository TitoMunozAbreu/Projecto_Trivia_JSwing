package com.mvc.modelo;

import java.util.Collections;
import java.util.List;

public class Pregunta {
        private String pregunta;
        private List<String> opciones;
        private String categoria;
        private int respuestaCorrecta;

    public Pregunta(String pregunta, List<String> opciones, int respuestaCorrecta, String categoria) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.categoria = categoria;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }


}

