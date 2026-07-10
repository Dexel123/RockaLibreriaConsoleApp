package org.rocka.dao.impl;

import org.rocka.util.Conexion;
import org.rocka.model.Autores;
import org.rocka.dao.AutoresDAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

        
public class AutoresDAOImpl implements AutoresDAO{

    @Override
    public boolean insertar(Autores autores) {
        return false;
    }

    @Override
    public List<Autores> listarTodos() {
        
        
        // crear lista
        List<Autores> Autor = new ArrayList<>();
        
        
        //CREAR NUESTRA CONSULTA
        String consulta = "{call sp_listarautores()}";
        
        
        //mapear el resultado de la consulta a objetos y lo agregamos a la lista
        //try with resource/  intentar con recursos-> cierra el recurso al completar el intento
        // recurso: Conexion al final se cierra
        try (
                
              Connection conexion =  Conexion.getInstancia().conectar();
              CallableStatement consultaCalll = conexion.prepareCall(consulta);
                ResultSet tablaResultado = consultaCalll.executeQuery();             
              
                ){
              //ciclo para rellenar mi lista
              //verificar cada fila del result set
              //va a agurdar cada celda dentro de cada atributo de mi objeto
              while(tablaResultado.next()){
                  Autor.add(new Autores(
                          tablaResultado.getInt("id_autor"),
                          tablaResultado.getString("nombre_autor"),
                          tablaResultado.getString("nacionalidad"),
                          tablaResultado.getString("apellido_autor"),
                          tablaResultado.getString("biografia")
                  ));
              }
        }catch (SQLException e){
            System.err.println("ERROR al listar Autores:" + e.getMessage());
            
        }        
        
        
        //retornamos una lista
        return Autor;
    }

    @Override
    public Autores buscarPorId(int id_autor) {
        
        //objeto
        Autores autor = new Autores();

        //consulta
        String consultaSQL = "{call sp_buscarautor(?)}";
        //mapeamos el ResultSet al Objeto(Cliente) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setInt(1, id_autor);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                autor.setId_autor(tablaResultado.getInt("id_autor"));
                autor.setNombre_autor(tablaResultado.getString("nombre_autor"));
                autor.setApellido_autor(tablaResultado.getString("apellido_autor"));
                autor.setNacionalidad(tablaResultado.getString("nacionalidad"));
                autor.setBiografia(tablaResultado.getString("biografia"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Autor: " + e.getMessage());
        }
        //retornamos el objeto
        return autor;
    }

        
    @Override
    public boolean actualizar(Autores autores) {
        return false;
    }

    @Override
    public boolean eliminar(int id_autores) {
        return false;
    }
}
