package com.mvc.controlador;

import com.mvc.modelo.Jugador;
import com.mvc.servicio.JugadorServicio;
import com.mvc.vista.dialog.PantallaPodio;

import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collections;
import java.util.List;

/**
 * CLASE PODIO CONTROLADOR, contiene la logica
 * de los componentes
 */
public class PodioControlador implements ActionListener, WindowListener {
    private PantallaPodio pantallaPodio;
    private CategoriaControlador categoriaControlador;
    private JugadorServicio jugadorServicio;
    private Jugador jugador;
    private PodioTableModel podioTableModel;

    /**
     * CONSTRUCTOR
     * @param jugadorServicio
     */
    public PodioControlador(JugadorServicio jugadorServicio, Jugador jugador){
        //instanciar variables
        this.jugadorServicio = jugadorServicio;
        this.jugador = this.jugadorServicio.mostrarJugadorPorEmail(jugador.getEmail());

        this.pantallaPodio = new PantallaPodio();
        //mostrar resultado del jugador
        this.pantallaPodio.getResultado().setText("Explorador: " + this.jugador.getNombre() + " | " + "puntos: " + this.jugador.getPuntos());
        //cargar datos del podio
        cargarDatosTablaPodio();
        //activar listeners
        addListenersPantallaPodio();
        this.pantallaPodio.setVisible(true);
    }

    /**
     * Metodo para activar los listeners de botones
     */
    private void addListenersPantallaPodio() {
        //activar listeners de botones y window
        this.pantallaPodio.getBtnVolverJugar().addActionListener(this);
        this.pantallaPodio.getBtnSalir().addActionListener(this);
        this.pantallaPodio.addWindowListener(this);
    }

    private void cargarDatosTablaPodio() {
        //instanciar la clase que extiende de table model
        this.podioTableModel = new PodioTableModel(this.jugadorServicio);
        //establecer modelo a la tabla jugadores
        this.pantallaPodio.getPodioTable().setModel(this.podioTableModel);
        this.pantallaPodio.getPodioTable().setAutoCreateRowSorter(true);
    }

    /**
     * Metodo para cerrar la pantalla
     */
    public void onClose(){
        //cerrar la pantalla podio
        this.pantallaPodio.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //almacenar la boton seleccionado
        String command = e.getActionCommand();

        switch (command){
            case "volverJugar":
                volverPantallaPregunta();
            case "salir":
                onClose();
        }
    }

    private void volverPantallaPregunta() {
        //cerrar pantalla podio
        onClose();
        //mostrar pantalla categoria
        this.categoriaControlador = new CategoriaControlador(this.jugadorServicio, this.jugador);
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
     * Clase JugadorTableModel para definir los
     * datos de la tabla
     */
    private static class PodioTableModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Nombre", "puntos"};

        private JugadorServicio jugadorServicio;
        private List<Jugador> jugadores;

        private PodioTableModel(JugadorServicio jugadorServicio){
            this.jugadorServicio = jugadorServicio;
            jugadores = this.jugadorServicio.mostrarJugadores();
            Collections.sort(jugadores);

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
                case 1 -> jugadores.get(rowIndex).getPuntos();
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
}
