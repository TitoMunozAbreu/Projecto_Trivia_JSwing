package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.servicio.JugadorServicio;
import com.mvc.vista.dialog.PantallaRegistro;
import org.netbeans.validation.api.builtin.stringvalidation.NombreValidacion;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

/**
 * CLASE REGISTRO CONTROLADOR
 * Gestiona la capa de los componentes de la pantalla del registro
 */
public class RegistroControlador extends Component implements ActionListener, ChangeListener, WindowListener {
    private PantallaRegistro pantallaRegistro;
    private JugadorServicio jugadorServicio;
    private CategoriaControlador categoriaControlador;

    /**
     * CONTRUCTOR
     */
    public RegistroControlador(JugadorServicio jugadorServicio){
        //instanciar la capa de servicio de jugador
        this.jugadorServicio = jugadorServicio;
        //instanciar pantalla del Registro
        this.pantallaRegistro = new PantallaRegistro();
        //activar los listeners
        addListenersPantallaRegistro();
        //activar la validacion de dato
        addValidation();
        this.pantallaRegistro.setVisible(true);
    }

    /**
     * Metodo para csignar los campos a validar
     */
    private void addValidation() {
        //desabilitar boton de crear jugador
        this.pantallaRegistro.getBtnCrear().setEnabled(false);
        //establecer el pais - idioma
        Locale.setDefault(new Locale("es","ES"));
        //instanciar el validationGroup
        ValidationGroup vg = this.pantallaRegistro.getValidacionPanel().getValidationGroup();
        //agregar los campos a validar
        vg.add(this.pantallaRegistro.getNombre(),StringValidators.REQUIRE_NON_EMPTY_STRING, new NombreValidacion());
        vg.add(this.pantallaRegistro.getEmail(), StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.EMAIL_ADDRESS);
        vg.add(this.pantallaRegistro.getContraseña(), StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

    }

    /**
     * Metodo para activar los listener
     * de los botones en pantalla
     */
    private void addListenersPantallaRegistro() {
        this.pantallaRegistro.getBtnCrear().addActionListener(this);
        this.pantallaRegistro.getBtnHome().addActionListener(this);
        this.pantallaRegistro.addWindowListener(this);
        this.pantallaRegistro.getValidacionPanel().addChangeListener(e -> {stateChanged(e);});
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //comprobar que los campos estan validados para activar el btn de iniciar sesion
        if(this.pantallaRegistro.getValidacionPanel().getProblem() == null){
            this.pantallaRegistro.getBtnCrear().setEnabled(true);
        }else {
            this.pantallaRegistro.getBtnCrear().setEnabled(false);
        }
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
        //comprobar boton
        switch (command){
            case "registrar":
                registrarUsuario();
                break;
            case "home":
                onClose();
        }
    }

    public void registrarUsuario() {
        //almacenar los datos del nuevo jugador
        String nombre = this.pantallaRegistro.getNombre().getText();
        String contraseña = this.pantallaRegistro.getContraseña().getText();
        String email = this.pantallaRegistro.getEmail().getText();
        //instanciar nuevoJuegador
        Jugador nuevoJugador = new Jugador(nombre,email,contraseña);
        //alamcenar si el jugador esta creado
        boolean estaCreado = this.jugadorServicio.crearJugador(nuevoJugador);
        System.out.println(estaCreado);

        //comprobar que esta creado
        if(!estaCreado){
            JOptionPane.showMessageDialog(this,"Email ya existe, introduce otro","Verificar email",JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this,"¡" +nuevoJugador.getNombre() + " vamos a descubrir Sevilla!","¡Bienvenido explorador", JOptionPane.INFORMATION_MESSAGE);
            //iniciar la pantalla categoria
            categoriaControlador = new CategoriaControlador(this.jugadorServicio,nuevoJugador);
        }
    }

    /**
     * Metodo para cerra la pantalla registro
     */
    public void onClose(){
        this.pantallaRegistro.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        onClose();
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
