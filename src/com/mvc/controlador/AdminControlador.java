package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.servicio.JugadorServicio;
import com.mvc.vista.dialog.PantallaAdmin;
import org.netbeans.validation.api.builtin.stringvalidation.NombreValidacion;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Locale;

public class AdminControlador extends Component implements ActionListener, WindowListener, ListSelectionListener, ChangeListener{
    private PantallaAdmin pantallaAdmin;
    private JugadorServicio jugadorServicio;
    private JugadorTableModel jugadorTableModel;
    private Jugador jugadorSeleccionado;

    public AdminControlador(JugadorServicio jugadorServicio){
        //instanciar variables
        this.jugadorServicio = jugadorServicio;
        pantallaAdmin = new PantallaAdmin();
        //mostrar jugadores en la tabla
        cargarDatosTabla();
        //activar los listeners
        addListenersPantallaAdmin();
        //desabilitar botones
        desabilitarBotones();
        //activar validacion de datos
        addValidation();
        pantallaAdmin.setVisible(true);
    }

    private void addValidation() {
        //establecer el pais - idioma
        Locale.setDefault(new Locale("es","ES"));
        //instanciar el validationGroup
        ValidationGroup vg = this.pantallaAdmin.getValidacionPanel().getValidationGroup();
        //agregar los campos a validar
        vg.add(this.pantallaAdmin.getNombre(), StringValidators.REQUIRE_NON_EMPTY_STRING, new NombreValidacion());
        vg.add(this.pantallaAdmin.getEmail(), StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.EMAIL_ADDRESS);
        vg.add(this.pantallaAdmin.getContraseña(), StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

    }

    private void desabilitarBotones() {
        //desabilitar botones
        this.pantallaAdmin.getBtnActualizar().setEnabled(false);
        this.pantallaAdmin.getBtnEditar().setEnabled(false);
        this.pantallaAdmin.getBtnEliminar().setEnabled(false);
        //desabilitar campos
        this.pantallaAdmin.getNombre().setEnabled(false);
        this.pantallaAdmin.getEmail().setEnabled(false);
        this.pantallaAdmin.getContraseña().setEnabled(false);
    }


    private void cargarDatosTabla() {
        //instanciar la clase que extiende de table model
        this.jugadorTableModel = new JugadorTableModel(this.jugadorServicio);
        //establecer modelo a la tabla jugadores
        this.pantallaAdmin.getTablaJugadores().setModel(jugadorTableModel);
        this.pantallaAdmin.getTablaJugadores().setAutoCreateRowSorter(true);
    }

    private void addListenersPantallaAdmin() {
        this.pantallaAdmin.getBtnActualizar().addActionListener(this);
        this.pantallaAdmin.getBtnEliminar().addActionListener(this);
        this.pantallaAdmin.getBtnEditar().addActionListener(this);
        this.pantallaAdmin.getBtnSalir().addActionListener(this);
        this.pantallaAdmin.addWindowListener(this);
        this.pantallaAdmin.getTablaJugadores().getSelectionModel().addListSelectionListener(this);
        this.pantallaAdmin.getValidacionPanel().addChangeListener(this);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //almacenar boton seleccionado
        String command = e.getActionCommand();

        switch (command){
            case "salir":
                onClose();
                break;
            case "editar":
                mostrarJugadorSeleccionado();
                break;
            case "eliminar":
                eliminarJugadorSeleccionado();
                break;
            case "actualizar":
            actualizarUsuario();
            break;
        }
    }

    private void actualizarUsuario() {
        //almacenar los datos del jugador a actualizar
        String nombre = this.pantallaAdmin.getNombre().getText();
        String contraseña = this.pantallaAdmin.getContraseña().getText();
        String email = this.pantallaAdmin.getEmail().getText();
        //instanciar nuevoJuegador
        Jugador nuevoJugador = new Jugador(nombre,email,contraseña);
        //alamcenar si el jugador esta creado
        boolean estaCreado = this.jugadorServicio.actualizarJugador(nuevoJugador, this.jugadorSeleccionado.getEmail());
        System.out.println(estaCreado);

        //comprobar que esta creado
        if(!estaCreado){
            JOptionPane.showMessageDialog(
                    this,
                    "Email ya existe, introduce otro",
                    "Verificar email",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(
                    this,
                    "Felicidades el jugador ha sido actualizado",
                    "¡Explorador actualiado!",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarDatosTabla();

        }
    }


    public void onClose(){
        this.pantallaAdmin.dispose();
    }


    /**
     * Metodo para comprobar si la fila de la tabla
     * ha sido seleccionada
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            //almcenar el indice de la fila seleccionada
            int indexFilaSeleccionada = this.pantallaAdmin.getTablaJugadores().getSelectedRow();
            //comprobar si se ha seleccionado una fila
            if(indexFilaSeleccionada != -1){
                //almacenar el jugador seleccionado
                this.jugadorSeleccionado = (Jugador) this.jugadorTableModel.getObjectAt(indexFilaSeleccionada);
                //habilitar botones de editar y eliminar
                this.pantallaAdmin.getBtnEditar().setEnabled(true);
                this.pantallaAdmin.getBtnEliminar().setEnabled(true);
            }

        }
    }

    private void mostrarJugadorSeleccionado() {
        //habilitar campos
        this.pantallaAdmin.getNombre().setEnabled(true);
        this.pantallaAdmin.getEmail().setEnabled(true);
        this.pantallaAdmin.getContraseña().setEnabled(true);
        //cargar datos del jugador seleccionado
        this.pantallaAdmin.getNombre().setText(this.jugadorSeleccionado.getNombre());
        this.pantallaAdmin.getEmail().setText(this.jugadorSeleccionado.getEmail());
        this.pantallaAdmin.getContraseña().setText(this.jugadorSeleccionado.getContraseña());
    }

    private void eliminarJugadorSeleccionado() {
        boolean esEliminado = this.jugadorServicio.eliminarJugador(this.jugadorSeleccionado);

        //comprobar si el jugador seleccionado ha sido eliminado
        if(esEliminado){
            //mostrar mensaje de eliminado
            JOptionPane.showMessageDialog(
                    AdminControlador.this,
                    "Explorador: " + this.jugadorSeleccionado.getNombre() + " ha sido eliminado",
                    "Jugador Eliminado",
                    JOptionPane.INFORMATION_MESSAGE
            );
            cargarDatosTabla();

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //comprobar que los campos estan validados para activar el btn de guar
        if(this.pantallaAdmin.getValidacionPanel().getProblem() == null){
            this.pantallaAdmin.getBtnActualizar().setEnabled(true);
        }else {
            this.pantallaAdmin.getBtnActualizar().setEnabled(false);
        }
    }


    /**
     * Clase ClienteTableModel para definir los
     * datos de la tabla
     */
    private static class JugadorTableModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Nombre","Email","Contraseña", "puntos"};

        private JugadorServicio jugadorServicio;
        private List<Jugador> jugadores;

        private JugadorTableModel(JugadorServicio jugadorServicio){
            this.jugadorServicio = jugadorServicio;
            jugadores = this.jugadorServicio.mostrarJugadores();

        }
        @Override
        public int getRowCount() {
            return jugadores.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> jugadores.get(rowIndex).getNombre();
                case 1 -> jugadores.get(rowIndex).getEmail();
                case 2 -> jugadores.get(rowIndex).getContraseña();
                case 3 -> jugadores.get(rowIndex).getPuntos();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0,columnIndex ) != null){
                return getValueAt(0,columnIndex).getClass();
            }else {
                return  Object.class;
            }
        }

        public Object getObjectAt(int rowIndex){
           return this.jugadores.get(rowIndex);
        }


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
