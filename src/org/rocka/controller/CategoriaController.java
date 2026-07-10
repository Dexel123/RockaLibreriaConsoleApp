package org.rocka.controller;

import org.rocka.dao.CategoriaDAO;
import org.rocka.dao.impl.CategoriaDAOImpl;
import org.rocka.model.Categoria;
import org.rocka.view.CategoriaConsoleView;

public class CategoriaController {

    private final CategoriaDAO dao;
    private final CategoriaConsoleView vista;

    public CategoriaController(CategoriaConsoleView vista) {
        this.dao = new CategoriaDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 3);
    }

    private void listar() {
        vista.mostrarListaCategorias(dao.listarTodos());
    }

    private void buscar() {
        int id = vista.solicitarIdCategoria();
        Categoria categoria = dao.buscar(id);
        

        if (categoria != null) {
            vista.mostrarCategoria(categoria);
        } else {
            System.out.println("Categoría no encontrada con el ID: " + id);
        }
    }
}