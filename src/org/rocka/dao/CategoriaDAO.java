package org.rocka.dao;

import java.util.List;
import org.rocka.model.Categoria;

public interface CategoriaDAO {

    List<Categoria> listarTodos();

    boolean crear(Categoria categoria);

    Categoria buscarPorId(int idCategoria);

    boolean actualizar(Categoria categoria);

    boolean eliminar(int idCategoria);
}