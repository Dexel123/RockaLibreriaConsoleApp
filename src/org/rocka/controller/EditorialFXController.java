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
import org.rocka.dao.EditorialDAO;
import org.rocka.dao.impl.EditorialDAOImpl;
import org.rocka.model.Editorial;
import org.rocka.system.Main;

public class EditorialFXController implements Initializable {

    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Editorial> tablaClientes;//Tabla de entidad: cliente

    private final EditorialDAO editorialDAO = new EditorialDAOImpl();
    private final ObservableList<Editorial> listaClientes = FXCollections.observableArrayList();//Entidad:Cliente

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaClientes.setAll(editorialDAO.listarTodos());
        tablaClientes.setItems(listaClientes);
    }

    private void seleccionarFila() {
        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtNit.setText(String.valueOf(newSelection.getNit()));
                        txtNombre.setText(newSelection.getNombre_editorial());
                        txtTelefono.setText(newSelection.getTelefono_editorial());
                        txtDireccion.setText(newSelection.getDireccion_editoria());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtNit.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Editorial editorial = new Editorial();
            editorial.setNit(txtNit.getText().trim());
            editorial.setNombre_editorial(txtNombre.getText().trim());
            editorial.setTelefono_editorial(txtTelefono.getText().trim());
            editorial.setDireccion_editoria(txtDireccion.getText().trim());

            if (editorialDAO.insertar(editorial)) {
                lblMensaje.setText("Cliente registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el cliente.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El CUI debe ser un número válido.");
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
            Main.cambiarVista("/org/key/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtNit.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtDireccion.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}