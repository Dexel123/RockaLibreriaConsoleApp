
package org.rocka.dao;

import java.util.List;
import org.rocka.model.Editorial;


public interface EditorialDAO {
    //firmas de metodos
    //CRUD
    boolean insertar(Editorial cliente);
    List<Editorial> listarTodos();
    Editorial buscarPorId(String nit);
    boolean actualizar(Editorial cliente);
    boolean eliminar(String nit);
   
}
