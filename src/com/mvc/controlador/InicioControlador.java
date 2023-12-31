package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.servicio.JugadorServicio;
import com.mvc.vista.jframe.PantallaInicio;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * CLASE INICIO CONTROLADOR
 * Gestiona la capa de los componentes de la pantalla inicio
 */
public class InicioControlador extends JFrame implements ActionListener, ChangeListener, MouseListener {
    private UIManager uiManager;
    private PantallaInicio pantallaInicio;
    private JugadorServicio jugadorServicio;
    private CategoriaControlador categoriaControlador;
    private RegistroControlador registroControlador;
    private AdminControlador adminControlador;


    /**
     * CONTRUCTOR
     */
    public InicioControlador(){
        //instanciar variables
        this.jugadorServicio = new JugadorServicio();
        //instanciar la pantalla de inicio
        this.pantallaInicio = new PantallaInicio();
        //activar validacion de datos
        addValidation();
        //activar los listeners
        addListenersPantallaIncio();
        //configurar colores de JOptionPane
        this.uiManager = new UIManager();
        UIManager.put("OptionPane.background",new Color(255,249,196));
        UIManager.put("Panel.background",new Color(255,249,196));
        UIManager.put("OptionPane.messageForeground",new Color(183,28,28));
        this.pantallaInicio.setVisible(true);
    }



    /**
     * Metodo para definir la validación
     */
    private void addValidation() {
        //desabilitar boton de inicio de sesion
        this.pantallaInicio.getBtnIniciar().setEnabled(false);
        //configurar idioma
        Locale.setDefault(new Locale("es","ES"));
        //metodo
        personalizarMensajeDeValidacion();
        //instanciar clase que valida los campos
        ValidationGroup vg = this.pantallaInicio.getValidacionPanel().getValidationGroup();
        //añadir los campos a validar
        vg.add(this.pantallaInicio.getEmail(), StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.EMAIL_ADDRESS);
        vg.add(this.pantallaInicio.getContraseña(), StringValidators.REQUIRE_NON_EMPTY_STRING,StringValidators.REQUIRE_VALID_INTEGER);
    }

    private void personalizarMensajeDeValidacion() {
        //definir la ruta y el msj
        String msgError = ResourceBundle.getBundle(
                "org/netbeans/validation/api/builtin/stringvalidation/Bundle_es",
                new Locale("es","ES")
                ).getString("MSG_MAY_NOT_BE_EMPTY");
        //configurar y personalizar el msj de error
        String formatoMsgError = MessageFormat.format(msgError,"email");
        String formatoMsgError2 = MessageFormat.format(msgError,"contraseña");

        //System.out.println(formatoMsgError);
    }

    /**
     * Metodo para activar los listeners
     * de los botones en pantalla
     */
    private void addListenersPantallaIncio() {
        this.pantallaInicio.getBtnIniciar().addActionListener(this);
        this.pantallaInicio.getBtnRegistrar().addActionListener(this);
        this.pantallaInicio.getBtnAdmin().addActionListener(this);
        this.pantallaInicio.getValidacionPanel().addChangeListener(this);
        this.pantallaInicio.getLblRecuperar().addMouseListener(this);
    }


    /**
     * Metodo que registra las acciones
     * realizadas en la pantalla
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //alamcenar el boton pulsado
        String command = e.getActionCommand();

        //comprobar boton seleccionado
        switch (command){
            case "iniciar":
                autenticarJugador();
                break;
            case "registrar":
                registroControlador = new RegistroControlador(this.jugadorServicio);
                break;
            case "admin":
                adminControlador = new AdminControlador(this.jugadorServicio);
                break;
        }

    }

    /**
     * Metodo para auntenticar el jugador
     */
    private void autenticarJugador() {
        //llamar a la capa de servicio para autenticacion
        boolean estaAutenticado = this.jugadorServicio.autenticarJugador(
                this.pantallaInicio.getEmail().getText(),
                this.pantallaInicio.getContraseña().getText());
        //mostrar mensaje
        if(estaAutenticado){
            Jugador jugador = this.jugadorServicio.mostrarJugadorPorEmail(this.pantallaInicio.getEmail().getText());
            //iniciar la pantalla categoria
            categoriaControlador = new CategoriaControlador(this.jugadorServicio, jugador);
        }else {
            JOptionPane.showMessageDialog(
                    this,
                    "El email/contraseña es inválido, si no posee cuenta haga click al botón registrar",
                    "Verificación de datos introducidos",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //comprobar que los campos estan validados para activar el btn de iniciar sesion
        if(this.pantallaInicio.getValidacionPanel().getProblem() == null){
            this.pantallaInicio.getBtnIniciar().setEnabled(true);
        }else {
            this.pantallaInicio.getBtnIniciar().setEnabled(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       //recuperar contraseña
        if(e.getClickCount() >= 1) {
            String contraseña = JOptionPane.showInputDialog(this, "¿Desea recuperar la contraseña? Ingresa un email", "Recuperar Contraseña", JOptionPane.QUESTION_MESSAGE);
            if(contraseña != null && contraseña.equals("")){
                JOptionPane.showMessageDialog(this,"Se ha enviado  a su correo las instrucciones para recuperar la contraseña", "Recuperar contraseña",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
