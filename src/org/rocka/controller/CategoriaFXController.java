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
    private TextField txtIdCategoria;
    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Categoria> tablaCategorias;

    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategorias = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        // Se llama al método usando la instancia del DAO
        listaCategorias.setAll(categoriaDAO.listarTodos());
        tablaCategorias.setItems(listaCategorias);
    }

    private void seleccionarFila() {
        tablaCategorias.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        // Coincide con los getters exactos de tu Categoria.java
                        if (txtIdCategoria != null) {
                            txtIdCategoria.setText(String.valueOf(newSelection.getId_categoria()));
                        }
                        txtNombreCategoria.setText(newSelection.getNombre_categoria());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtNombreCategoria.getText().trim().isEmpty()) {
                mostrarError("El nombre de la categoría es obligatorio.");
                return;
            }

            Categoria categoria = new Categoria();
            // Coincide con el setter de tu Categoria.java
            categoria.setNombre_categoria(txtNombreCategoria.getText().trim());

            if (categoriaDAO.insertar(categoria)) {
                lblMensaje.setText("Categoría registrada exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar la categoría.");
            }
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
        if (txtIdCategoria != null) {
            txtIdCategoria.clear();
        }
        txtNombreCategoria.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}