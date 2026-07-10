package org.rocka.view;

import java.util.List;
import java.util.Scanner;
import org.rocka.model.Categoria; 

public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        int opcion = 0;
        System.out.println("----Gestion de Categorias-----");
        System.out.println("-1. LISTAR todas las Categorias");
        System.out.println("-2. BUSCAR Categoria por ID");
        System.out.println("-3. REGRESAR a menú principal");
        System.out.println("SELECCIONE UNA OPCIÓN: ");
        try {
            opcion = Integer.parseInt(leer.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida.");
        }
        return opcion;
    }

    public void mostrarListaCategorias(List<Categoria> lista) { 
        System.out.println("-- LISTA DE CATEGORIAS ---");
        System.out.printf("%-15s %-30s%n", "ID CATEGORIA", "NOMBRE CATEGORIA");
        System.out.println("----------------------------------------------");
        for (Categoria cat : lista) { 
            System.out.printf("%-15d %-30s%n", 
                cat.getId_categoria(), 
                cat.getNombre_categoria()
            );
        }
    }

    public int solicitarIdCategoria() {
        System.out.println("Ingrese el ID de la categoría a buscar:");
        try {
            return Integer.parseInt(leer.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido. Se usará 0 por defecto.");
            return 0;
        }
    }

    public void mostrarCategoria(Categoria cat) {
        System.out.println("-- DATOS DE LA CATEGORÍA --");
        System.out.println("ID:     " + cat.getId_categoria());
        System.out.println("NOMBRE: " + cat.getNombre_categoria());
    }
}