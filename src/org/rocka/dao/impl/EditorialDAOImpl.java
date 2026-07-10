package org.rocka.dao.impl;

import org.rocka.util.Conexion;
import org.rocka.model.Editorial;
import java.util.List;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.rocka.dao.EditorialDAO;

public class EditorialDAOImpl implements EditorialDAO{
    
    @Override
    public boolean insertar(Editorial cliente) {
        return false;
    }

        @Override
    public List<Editorial> listarTodos() {

        // crear lista
        List<Editorial> editoriales = new ArrayList<>();

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
                   editoriales.add(new Editorial(                   
                    tablaResultado.getString("nit"),
                    tablaResultado.getString("nombre_editorial"),
                    tablaResultado.getString("telefono_editorial"),
                    tablaResultado.getString("direccion_editoria")
                    ));
               }
        }catch (SQLException e){
               System.err.println("Eror al listar Clientes" + e.getMessage());
        }        

        //retornamos una lista
        return editoriales;
    }
    @Override
    public boolean actualizar(Editorial cliente) {
        return false;
    }
    @Override
    public Editorial buscarPorId(String nit) {
        
        //Objeto
        Editorial editorial = new Editorial();
        
        //Mapeamos el resultset al objeto(Editoriales) segun sus atributos y la fila devuelta
        String consultaSQL = "{call sp_buscareditorial(?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consultaSQL);){
            
                consultaCall.setString(1, nit);
                ResultSet tablaResultado = consultaCall.executeQuery();
                
                if (tablaResultado.next()){
                    editorial.setNit(tablaResultado.getString("nit"));
                    editorial.setNombre_editorial(tablaResultado.getString("nombre_editorial"));
                    editorial.setTelefono_editorial(tablaResultado.getString("telefono_editorial"));
                    editorial.setDireccion_editoria(tablaResultado.getString("direccion_editoria"));
                }else{
                    System.out.println("No existe el usuario");
                }
                
                
            
        } catch (SQLException e) {
            System.err.println("Error al buscar a la Editorial: " + e.getMessage());
        }

//retornamos el objeto
        
        return editorial;
        
    }

    @Override
    public boolean eliminar(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
