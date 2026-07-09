
package org.rocka.dao;

import java.util.List;
import org.rocka.model.Clientes;


public interface ClienteDAO {
    //firmas de metodos
    //CRUD
    boolean insertar(Clientes cliente);
    List<Clientes> listarTodos();
    Clientes buscar(long cui);
    boolean actualizar(Clientes cliente);
    boolean eliminar(long cui);
   
}
