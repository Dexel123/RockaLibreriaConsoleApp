package org.rocka.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.rocka.dao.CategoriaDAO;
import org.rocka.dao.impl.CategoriaDAOImpl;
import org.rocka.model.Categoria;
import org.rocka.system.Main;

public class CategoriaFXController implements Initializable {

    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private Label lblMensaje;
    

    private TableView<Categoria> tablaCategoria;//Tabla de entidad: Categoria

    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategoria = FXCollections.observableArrayList();//Entidad:Categoria

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaCategoria.setAll(categoriaDAO.listarTodos());
        tablaCategoria.setItems(listaCategoria);
    }

    private void seleccionarFila() {
        tablaCategoria.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtID.setText(String.valueOf(newSelection.getID()));
                        txtNombre.setText(newSelection.getNombre());
                        
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Categoria categoria = new Categoria();
            categoria.setID(Long.parseLong(txtID.getText().trim()));
            categoria.setNombre(txtNombre.getText().trim());

            if (categoriaDAO.crear(categoria)) {
                lblMensaje.setText("Categoria registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar la categoria.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarFormulario();
        lblMensaje.setText("");
    }

    @FXML
    private void handleActualizar() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }

    @FXML
    private void handleVolver() {
        try {
            Main.cambiarVista("/org/rocka/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtID.clear();
        txtNombre.clear();

    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}