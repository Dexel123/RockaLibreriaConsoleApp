package org.rocka.controller;

import java.io.IOException;
import org.rocka.dao.UsuarioDAO;
import org.rocka.util.SecurityUtil;
import org.rocka.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.rocka.system.Main;
import org.rocka.util.SesionContext;
import org.rocka.util.ValidacionException;

public class InicioSesionController implements Initializable {
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Label lblMensaje;
    
    private UsuarioDAO usuarioDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO = new UsuarioDAO();
        lblMensaje.setText("");
        btnIniciarSesion.setOnAction(this::eventoInicioSesion);
    }
    
    @FXML
    public void eventoInicioSesion(ActionEvent evento) {
        try {
            ValidacionException.validarNoVacio(txtUsuario.getText(), "usuario");
            ValidacionException.validarNoVacio(txtPassword.getText(), "contraseña");
            
            String usuario = txtUsuario.getText();
            String password = txtPassword.getText();
            String passwordHash = SecurityUtil.hashSHA256(password);
            Usuario usuarioIniciado = usuarioDAO.iniciarSesion(usuario, passwordHash);            
            
            if (usuarioIniciado != null) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Inicio correcto");
                abrirDashboard(usuarioIniciado);
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos");
            }
            
        } catch (ValidacionException e) {
            mostrarAlerta(Alert.AlertType.WARNING, e.getMessage());
            lblMensaje.setText(e.getMessage());
        }        
    }

    @FXML
    public void eventoRegistrarse(ActionEvent evento){
        try {
            Main.cambiarEscena("/org/rocka/view/RegistrarUsuarioView.fxml");
        } catch (IOException e) {
            System.err.println("Error al cargar registro: " + e.getMessage());
            lblMensaje.setText("Error interno");
        }
    }
    
    private void abrirDashboard(Usuario usuario) {
        SesionContext.getInstancia().setUsuarioActual(usuario);
        String rutaFXML = "";        
        
        if (usuario.getRol() != null) {
            switch (usuario.getRol().toLowerCase()) {
                case "admin":
                    rutaFXML = "/org/rocka/view/AdminDashboardView.fxml";
                    break;
                case "empleado":
                    rutaFXML = "/org/rocka/view/EmpleadoDashboradView.fxml";
                    break;
                default:
                    lblMensaje.setText("Rol de usuario desconocido");
                    return;
            }
        }
        
        try {
            Main.cambiarEscena("/org/rocka/view/AdminDashboardView.fxml");
        } catch (IOException e) {
            System.err.println("Error al cargar la vista:" + rutaFXML + " " + e.getMessage());
            lblMensaje.setText("Error interno");
        }
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.show();
    }
}