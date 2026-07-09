package org.rocka.dao.impl;

import org.rocka.util.Conexion;
import org.rocka.model.Editoriales;
import java.util.List;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import org.rocka.dao.EditorialesDAO;
import java.sql.SQLException;

public class EditorialesDAOImpl implements EditorialesDAO{
    
    @Override
    public boolean insertar(Editoriales cliente) {
        return false;
    }

        @Override
    public List<Editoriales> listarTodos() {

        // crear lista
        List<Editoriales> editorial = new ArrayList<>();

        //CREAR NUESTRA CONSULTA
        String consulta = "{call sp_listareditoriales()}";

        //mapear el resultado de la consulta a objetos y lo agregamos a la lista
        //try with resource/  intentar con recursos-> cierra el recurso al completar el intento
        // recurso: Conexion al final se cierra
        try (
              Connection conexion =  Conexion.getInstancia().conectar();
              CallableStatement consultaCalll = conexion.prepareCall(consulta);
               ResultSet tablaResultado = consultaCalll.executeQuery();){ 
               while (tablaResultado.next()) {
                   editorial.add(new Editoriales(                   
                    tablaResultado.getString("nit"),
                    tablaResultado.getString("nombre_editorial"),
                    tablaResultado.getString("telefono_editorial"),
                    tablaResultado.getString("direccion_editorial")
                    ));
               }
        }catch (SQLException e){
               System.err.println("Eror al listar Clientes" + e.getMessage());
        }        

        //retornamos una lista
        return null;
    }
    @Override
    public boolean actualizar(Editoriales cliente) {
        return false;
    }
    @Override
    public Editoriales buscarPorId(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
