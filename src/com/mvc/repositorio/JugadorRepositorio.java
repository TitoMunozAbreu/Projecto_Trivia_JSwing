package com.mvc.repositorio;

import com.mvc.modelo.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepositorio {
    private String url = "jdbc:mysql://localhost/trivia_sevilla";
    private String user = "papaya";
    private String password = "Mango_con.Sa1";

    //sentencias SQL
    private final String CREAR = "INSERT INTO JUGADOR (`nombre`,`email`,`contraseña`, `puntos`) VALUES (?, ?, ?, ?)";
    private final String MOSTRAR_JUGADORES = "SELECT * FROM JUGADOR";
    private final String MOSTRAR_JUGADOR_POR_EMAIL = "SELECT * FROM JUGADOR WHERE email = ?";
    private final String ACTUALIZAR = "UPDATE JUGADOR j SET j.nombre = ?, j.email = ?, j.contraseña = ? WHERE j.email = ?";
    private final String RESPUESTA_CORRECTA = "UPDATE JUGADOR j SET j.puntos = puntos + 10 WHERE j.email = ?";
    private final String RESPUESTA_RAPIDA = "UPDATE JUGADOR j SET j.puntos = puntos + 15 WHERE j.email = ?";
    private final String ELIMINAR = "DELETE FROM JUGADOR WHERE email = ?";


    static Connection connection = null;


    public JugadorRepositorio(){
        //establecer conexion a la BBDD
        openConexionBBDD();


    }

    /**
     * Abrir conexion en la BBDD
     */
    public void openConexionBBDD(){
        try{
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("conexion establecida a la BBDD");

        }catch (SQLTimeoutException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Cerrar conexion en la BBDD
     */
    public void closeConexionBBDD(){
        try{
            this.connection.close();
            System.out.println("conexion cerrada exitosamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    //listar jugadores
    public List<Jugador> mostrarJugadores(){
        List<Jugador> jugadores = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(MOSTRAR_JUGADORES);

            while (resultSet.next()){
                int id=  resultSet.getInt("id_jugador");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String contraseña = resultSet.getString("contraseña");
                int puntos = resultSet.getInt("puntos");
                jugadores.add(new Jugador(id,nombre,email,contraseña,puntos));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  jugadores;
    }

    //mostrar jugador
    public Jugador mostrarJugadorPorEmail(String buscarEmail){
        Jugador jugadorEncontrado = new Jugador();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(MOSTRAR_JUGADOR_POR_EMAIL);
            preparedStatement.setString(1,buscarEmail);
            ResultSet  resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=  resultSet.getInt("id_jugador");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String contraseña = resultSet.getString("contraseña");
                int puntos = resultSet.getInt("puntos");
                jugadorEncontrado = new Jugador(id, nombre, email, contraseña,puntos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  jugadorEncontrado;
    }

    //crear jugador
    public boolean crearJugador(Jugador nuevoJugador){
        boolean estaCreado = mostrarJugadores()
                .stream()
                .filter(jugador -> jugador.getEmail().equals(nuevoJugador.getEmail()))
                .findFirst()
                .isPresent();

        if(!estaCreado){
            try{
                PreparedStatement preparedStatement = this.connection.prepareStatement(CREAR);
                preparedStatement.setString(1, nuevoJugador.getNombre());
                preparedStatement.setString(2, nuevoJugador.getEmail());
                preparedStatement.setString(3, nuevoJugador.getContraseña());
                preparedStatement.setInt(4, nuevoJugador.getPuntos());

                int resultado = preparedStatement.executeUpdate();

                if(resultado > 0 ){
                    estaCreado = true;
                }

            }catch (SQLException e){

            }
        }

        return estaCreado;
    }

    public boolean estaRegistradoJugador(String email, String contraseña) {
        return  this.mostrarJugadores()
                .stream()
                .filter(jugador ->
                        jugador.getEmail().equals(email) && jugador.getContraseña().equals(contraseña))
                .findFirst().isPresent();
    }

    public void sumarPuntosPorRespuestaRapida(Jugador jugador) {
        //sumar puntos al jugador
        try {
            //instanciamos el ps para la actualzacion parametrizada
            PreparedStatement preparedStatement = connection.prepareStatement(RESPUESTA_RAPIDA);
            //asignamos los valores en la edad, nombreAlumno
            preparedStatement.setString(1, jugador.getEmail());
            //ejecutar actualizacion de la tabla
            int resultSet = preparedStatement.executeUpdate();
            //comprobar si la actualizacion ha sido realizada

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sumarPuntosPorRespuestaCorrecta(Jugador jugador) {
        //sumar puntos al jugador
        try {
            //instanciamos el ps para la actualzacion parametrizada
            PreparedStatement preparedStatement = connection.prepareStatement(RESPUESTA_CORRECTA);
            //asignamos los valores en la edad, nombreAlumno
            preparedStatement.setString(1, jugador.getEmail());
            //ejecutar actualizacion de la tabla
            int resultSet = preparedStatement.executeUpdate();
            //comprobar si la actualizacion ha sido realizada

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean eliminarJugador(Jugador jugadorSeleccionado) {
        boolean esEliminado = false;
        String email = jugadorSeleccionado.getEmail();
        try {
            //instanciamos el ps para la actualizacion parametrizada
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR);
            //asignar el valor de la escuela
            preparedStatement.setString(1,email);
            //ejecutar actulizacion de la tabla
            int resultSet = preparedStatement.executeUpdate();
            //comprobar si se ha eliminado
            if(resultSet > 0){
                esEliminado = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return esEliminado;
    }

    public boolean actualizarJugador(Jugador jugadorActualizado, String emailJugadorSeleccionado){
        boolean estaActualizado = false;
        try{

            PreparedStatement ps = this.connection.prepareStatement(ACTUALIZAR);
            ps.setString(1, jugadorActualizado.getNombre());
            ps.setString(2, jugadorActualizado.getEmail());
            ps.setString(3, jugadorActualizado.getContraseña());
            ps.setString(4, emailJugadorSeleccionado);


            int resultado = ps.executeUpdate();
            if(resultado > 0 ){
                estaActualizado = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  estaActualizado;
    }


}
