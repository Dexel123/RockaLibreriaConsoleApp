package org.rocka.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage escenarioPrincipal;

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        // Asignación directa a la variable estática de la clase
        Main.escenarioPrincipal = escenarioPrincipal;
        
        // Carga de la vista inicial desde el paquete org.rocka
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/rocka/view/MenuPrincipal.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        escenarioPrincipal.setTitle("Rocka Librería - Categorías");
        escenarioPrincipal.setScene(scene);
        escenarioPrincipal.show();
    }

    public static void cambiarVista(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
        Parent root = loader.load();
        escenarioPrincipal.setScene(new Scene(root));
    }

    public static void main(String[] args) {
        launch(args);
    }
}