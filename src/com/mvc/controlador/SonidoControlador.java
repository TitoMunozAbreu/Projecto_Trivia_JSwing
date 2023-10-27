package com.mvc.controlador;

import com.mvc.controlador.sonidos.SonidoJuego;
import com.mvc.controlador.sonidos.SonidoRC;
import com.mvc.controlador.sonidos.SonidoRM;
import com.mvc.controlador.sonidos.SonidoRR;

public class SonidoControlador {
    private SonidoJuego sonidoJuego;
    private SonidoRC sonidoRC;
    private SonidoRM sonidoRM;
    private SonidoRR sonidoRR;

    public SonidoControlador() {
        this.sonidoJuego = new SonidoJuego();
        this.sonidoRC = new SonidoRC();
        this.sonidoRM = new SonidoRM();
        this.sonidoRR = new SonidoRR();
    }


    public void runMusicJuego(){
        Thread thread = new Thread(this.sonidoJuego);
        thread.start();

    }

    public void stopMusicJuego(){
        this.sonidoJuego.stopMusic();
    }


    public void runMusicRC(){
        Thread thread = new Thread(this.sonidoRC);
        thread.start();

    }

    public void stopMusicRC(){
        this.sonidoRC.stopMusic();
    }


    public void runMusicRR(){
        Thread thread = new Thread(this.sonidoRR);
        thread.start();

    }

    public void stopMusicRR(){
        this.sonidoRR.stopMusic();
    }


    public void runMusicRM(){
        Thread thread = new Thread(this.sonidoRM);
        thread.start();

    }

    public void stopMusicRM(){
        this.sonidoRM.stopMusic();
    }
}
