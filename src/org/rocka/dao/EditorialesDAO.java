
package org.rocka.dao;

import java.util.List;
import org.rocka.model.Editoriales;


public interface EditorialesDAO {
    //firmas de metodos
    //CRUD
    boolean insertar(Editoriales cliente);
    List<Editoriales> listarTodos();
    Editoriales buscarPorId(String nit);
    boolean actualizar(Editoriales cliente);
    boolean eliminar(String nit);
   
}
