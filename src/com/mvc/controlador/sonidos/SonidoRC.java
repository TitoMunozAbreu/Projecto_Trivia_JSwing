package com.mvc.controlador.sonidos;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.Clip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SonidoRC implements Runnable{
    private Player player;
    private Clip clip;
    //bandera para controlar la reproduccion del sonido
    private boolean isPlaying;
    private String sonidoPath = "src/com/recursos/sonidos/respuestaCorrecta.mp3";
    public void runMusic(String path){
        try {
            FileInputStream audioSource = new FileInputStream(path);
            this.player = new Player(audioSource);
            this.player.play();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }

    public void stopMusic(){
        this.isPlaying = false;
        this.player.close();
    }

    @Override
    public void run() {
        runMusic(sonidoPath);
        while (isPlaying){

        }
    }
}
