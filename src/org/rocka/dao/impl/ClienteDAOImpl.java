package org.rocka.dao.impl;

import org.rocka.util.Conexion;
import org.rocka.dao.ClienteDAO;
import org.rocka.model.Clientes;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
 
public class ClienteDAOImpl implements ClienteDAO{
 
    @Override
    public boolean insertar(Clientes cliente) {
        return false; 
    }
 
    @Override
    public List<Clientes> listarTodos() {
        //crear lista
        List<Clientes> clientes = new ArrayList<>(); 
        //crear nuestra consulta 
        String consulta = "{call sp_listarclientes()}"; 
        //mapear el resultado de la consulta a objeto y lo agregamos a lista 
        //try with resources  / intentar con recursos -> cierra el recurso al completar el intento 
         try  (Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta); 
                ResultSet tablaResultado = consultaCall.executeQuery(); ) {
             //ciclo para rellenar mi lista 
             //verificar cada fila del resultado set 
             //va a guardar cada celda dentro de cada atributo de mi objeto 
             while(tablaResultado.next()) {
                  clientes.add(new Clientes(
                                tablaResultado.getLong("cui"),
                                tablaResultado.getString("nombreCliente"),
                                tablaResultado.getString("apellidoCliente"),
                                tablaResultado.getString("correoElectronico")
                  )); 
                  }  
        }  catch (SQLException e ) {
              System.err.println("Error al listar Clientes: " + e.getMessage()); 
        }
        //retornamos una lista 
        return clientes; 
    }
 
    @Override
    public Clientes buscar(long cui) {
        return null; 
    }
 
    @Override
    public boolean actualizar(Clientes cliente) {
        return false; 
    }
 
    @Override
    public boolean eliminar(long cui) {
        return false; 
    }
}