package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.servicio.JugadorServicio;
import com.mvc.vista.dialog.PantallaAdmin;
import com.mvc.vista.jframe.PantallaInicio;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class AdminControlador extends Component implements ActionListener, WindowListener {
    private PantallaAdmin pantallaAdmin;
    private JugadorServicio jugadorServicio;
    private List<Jugador> jugadores;

    public AdminControlador(){
        //instanciar variables
        this.jugadorServicio = new JugadorServicio();
        pantallaAdmin = new PantallaAdmin();
        this.jugadores =  jugadorServicio.mostrarJugadores();
        //mostrar jugadores en la tabla
        cargarDatosTabla();
        pantallaAdmin.setVisible(true);
    }

    private void cargarDatosTabla() {
        JugadorTableModel jugadorTableModel = new JugadorTableModel();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //almacenar boton seleccionado
        String command = e.getActionCommand();

        switch (command){
            case "salir":
                onClose();
                break;
        }
    }

    public void onClose(){
        this.pantallaAdmin.dispose();
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

    /**
     * Clase ClienteTableModel para definir los
     * datos de la tabla
     */
    private static class JugadorTableModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Nombre","Email","puntos"};

        private JugadorServicio jugadorServicio;
        private List<Jugador> jugadores;

        private JugadorTableModel(){
            this.jugadorServicio = new JugadorServicio();
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
    }
}
