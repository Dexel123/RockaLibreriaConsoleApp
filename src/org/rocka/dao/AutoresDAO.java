package org.rocka.dao;

import java.util.List;
import org.rocka.model.Autores;
public interface AutoresDAO {
   //FIRMAS DE METODOS
    //CRUD
   
  
    boolean insertar(Autores autores);
    List<Autores> listarTodos();
    Autores buscarPorId(int idAutor);
    boolean actualizar(Autores autores);
    boolean eliminar(int idAutores);
    
    
    
    
    
}
