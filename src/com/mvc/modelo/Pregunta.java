package com.mvc.modelo;

import java.util.Collections;
import java.util.List;

public class Pregunta {
        private String pregunta;

        private String opciones1;
        private String opciones2;
        private String opciones3;
        private String opciones4;
        private String categoria;
        private int respuestaCorrecta;


    public Pregunta(String pregunta, String opciones1, String opciones2, String opciones3, String opciones4, int respuestaCorrecta, String categoria) {
        this.pregunta = pregunta;
        this.opciones1 = opciones1;
        this.opciones2 = opciones2;
        this.opciones3 = opciones3;
        this.opciones4 = opciones4;
        this.categoria = categoria;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getOpciones1() {
        return opciones1;
    }

    public String getOpciones2() {
        return opciones2;
    }

    public String getOpciones3() {
        return opciones3;
    }

    public String getOpciones4() {
        return opciones4;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\n' +
                ", opciones1='" + opciones1 + '\n' +
                ", opciones2='" + opciones2 + '\n' +
                ", opciones3='" + opciones3 + '\n' +
                ", opciones4='" + opciones4 + '\n' +
                ", categoria='" + categoria + '\n' +
                ", respuestaCorrecta=" + respuestaCorrecta +
                '}' + "\n";
    }
}

