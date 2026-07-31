package org.rocka.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.rocka.model.Usuario;
import org.rocka.util.SesionContext;

public class AdminDashboradController implements Initializable {

    @FXML 
    private Label lblBienvenida;
    
    private Usuario usuarioActual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obtenemos el usuario actual del contexto de sesión
        usuarioActual = SesionContext.getInstancia().getUsuarioActual();
        
        // Verificamos que el usuario exista y que la etiqueta esté inicializada
        if (usuarioActual != null && lblBienvenida != null) {
            lblBienvenida.setText("Bienvenido administrador " + usuarioActual.getUsername());
        }
    }
}