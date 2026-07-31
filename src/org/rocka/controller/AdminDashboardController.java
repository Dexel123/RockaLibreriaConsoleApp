package org.rocka.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.rocka.model.Usuario;
import org.rocka.system.Main;
import org.rocka.util.SesionContext;

public class AdminDashboardController implements Initializable {

    @FXML 
    private Label lblBienvenida;
    
    @FXML
    private Button btnSalir; 
    
    private Usuario usuarioActual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obtenemos el usuario actual del contexto de sesión
        usuarioActual = SesionContext.getInstancia().getUsuarioActual();
        
        if (usuarioActual != null && lblBienvenida != null) {
            lblBienvenida.setText("Bienvenido administrador " + usuarioActual.getUsername());
        }
    } 

    @FXML
    public void eventoSalir(ActionEvent evento) {
        try {
            Main.cambiarEscena("/org/rocka/view/InicioSesionView.fxml");
        } catch (IOException e) {
            System.err.println("Error al cargar la escena: " + e.getMessage());
        }
    }
    
        @FXML
    public void eventoCliente(ActionEvent evento) {
        try {
            Main.cambiarEscena("/org/rocka/view/InicioSesionView.fxml");
        } catch (IOException e) {
            System.err.println("Error al cargar la escena: " + e.getMessage());
        }
    }
    
} 