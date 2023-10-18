package com.mvc.controlador;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SonidoControlador implements Runnable{
    private Player player;
    private Clip clip;
    private String introPath = "src/com/recursos/sonidos/Intro.mp3";
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
        this.player.close();
    }

    @Override
    public void run() {
        runMusic(introPath);
    }
}
