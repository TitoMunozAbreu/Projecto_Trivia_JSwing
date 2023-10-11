package com.mvc.controlador;

import com.mvc.vista.dialog.PantallaAdmin;
import com.mvc.vista.jframe.PantallaInicio;

public class AdminControlador {
    private PantallaAdmin pantallaAdmin;

    public AdminControlador(){
        pantallaAdmin = new PantallaAdmin();
        pantallaAdmin.setVisible(true);
    }
}
