package org.rocka.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.rocka.dao.EditorialDAO;
import org.rocka.dao.impl.EditorialDAOImpl;
import org.rocka.model.Editorial;
import org.rocka.system.Main;

public class EditorialFXController implements Initializable {


    private TableView<Editorial> tablaEditoriales;//Tabla de entidad: cliente
    
    @FXML private TableColumn <Editorial, String> colNit;
    @FXML private TableColumn <Editorial, String> colNombre;
    @FXML private TableColumn <Editorial, String> colTelefono;
    @FXML private TableColumn <Editorial, String> colDireccion;

    private final EditorialDAO editorialDAO = new EditorialDAOImpl();
    private final ObservableList<Editorial> listaEditoriales = FXCollections.observableArrayList();//Entidad:Editorial

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();
        cargarTabla();
        
    }
    
    @FXML
    private void configurarTabla(){        
        colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreEditorial"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefonoEditorial"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionEditorial"));
    }

    private void cargarTabla() {
        listaEditoriales.setAll(editorialDAO.listarTodos());
        tablaEditoriales.setItems(listaEditoriales);
    }
    
    @FXML
    private void handleVolver() {
        try {
            Main.cambiarVista("/org/rocka/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }
    
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}