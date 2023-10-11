package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.vista.dialog.PantallaCategoria;
import com.mvc.vista.jframe.PantallaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CategoriaControlador implements ActionListener, WindowListener {
    private PantallaCategoria pantallaCategoria;
    private Jugador jugador;


    public CategoriaControlador(Jugador jugador){
        this.jugador = jugador;
        this.pantallaCategoria = new PantallaCategoria();
        this.pantallaCategoria.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
