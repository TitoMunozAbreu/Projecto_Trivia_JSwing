package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.vista.dialog.PantallaCategoria;
import com.mvc.vista.jframe.PantallaInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

/**
 * CLASE CATERGORIA CONTROLADOR
 *  * Gestiona la capa de los componentes de la pantalla categoria
 */
public class CategoriaControlador implements ActionListener, WindowListener {
    private PantallaCategoria pantallaCategoria;
    private PreguntaControlador PreguntaControlador;

    private Jugador jugador;
    private final String[] CATEGORIAS = {"Cultura", "Monumentos", "Historia"};

    /**
     * CONTRUCTOR
     * @param jugador
     */
    public CategoriaControlador(Jugador jugador){
        this.jugador = jugador;
        this.pantallaCategoria = new PantallaCategoria();
        this.pantallaCategoria.getLblTitulo().setText("¡Explorador " + jugador.getNombre() + "!");
        //activar los listeners
        addListenesPantallaCategoria();
        //incluir las opciones al comboBox
        this.pantallaCategoria.getComboBox().setModel(new DefaultComboBoxModel(Arrays.stream(CATEGORIAS).toArray()));
        this.pantallaCategoria.setVisible(true);

    }

    /**
     * Metodo para activar los listeners
     * de los botones en pantalla
     */
    private void addListenesPantallaCategoria() {
        this.pantallaCategoria.getBtnHome().addActionListener(this);
        this.pantallaCategoria.getBtnJugar().addActionListener(this);
    }

    /**
     * Metodo que registra las acciones
     * realizadas en la pantalla
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //almacenar el boton selecionado
        String command = e.getActionCommand();
        //comprobar btn seleccionado
        switch (command){
            case "home":
                onClose();
            case "jugar":
                //almacenar la categoria seleccionada
                String categoriaSeleccionada = (String) this.pantallaCategoria.getComboBox().getSelectedItem();
                onJugar(categoriaSeleccionada);
        }
    }

    /**
     * Metodo para comenzar el juego
     */
    private void onJugar(String categoriaSeleccionada) {
        onClose();
        //iniciar pantalla controlador
        this.PreguntaControlador = new PreguntaControlador(categoriaSeleccionada,
                                                            this.jugador);

    }

    /**
     * Metodo para cerrar la pantalla categoria
     */
    public void onClose(){
        this.pantallaCategoria.dispose();
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
