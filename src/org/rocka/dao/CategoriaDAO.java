package org.rocka.dao;
 
import java.util.List;
import org.rocka.model.Categoria;
 
public interface CategoriaDAO {

    boolean insertar(Categoria categoria);
    
    List<Categoria> listarTodos();
    Categoria buscar(int id_categoria); 
    boolean actualizar(Categoria categoria); 
    boolean eliminar(int id_categoria); 
}