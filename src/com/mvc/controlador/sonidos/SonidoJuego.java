package com.mvc.controlador.sonidos;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SonidoJuego implements Runnable{
    private Player player;
    private Clip clip;
    private String SONIDO_PATH = "src/com/recursos/sonidos/juego.mp3";

    //bandera para controlar la reproduccion del sonido
    private boolean isPlaying;

    /**
     * Metodo para reproducir la musica
     * @param path
     */
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

    /**
     * Metodo que detiene la reproducción de la musica
     */
    public void stopMusic(){
        this.isPlaying = false;
        this.player.close();
    }

    /**
     * Metodo que sobre escribre la clase Thread
     * para la creacion de un hilo
     */
    @Override
    public void run() {
        runMusic(SONIDO_PATH);
        while (isPlaying){

        }
    }
}
