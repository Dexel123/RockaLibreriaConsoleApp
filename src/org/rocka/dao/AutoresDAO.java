package org.rocka.dao;

import java.util.List;
import org.rocka.model.Autores;
public interface AutoresDAO {
   //FIRMAS DE METODOS
    //CRUD
   
  
    boolean insertar(Autores autores);
    List<Autores> listar();
    Autores buscar(int id_autores);
    boolean actualizar(Autores autores);
    boolean eliminar(int id_autores);
    
    
    
    
    
}
