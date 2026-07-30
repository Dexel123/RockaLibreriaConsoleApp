package org.rocka.dao.impl;

import java.util.ArrayList;
import org.rocka.model.Editorial;
import org.rocka.dao.EditorialDAO;

import org.rocka.util.Conexion;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditorialDAOImpl implements EditorialDAO {

    @Override
    public List<Editorial> listarTodos() {
        //crear lista
        List<Editorial> editoriales = new ArrayList<>();//null
        //crear nustras consulta
        String consulta = "{call sp_listarclientes()}";
        //maperar el resultado de la consulta a objeto y lo agregamos a la lista
        //try with resources / intentar con recursos --> cierra el recurso al completar el intento
        //recurso: Conexion, al final se cierra
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery();) {
            //ciclo para rellenar mi lista
            //verificar cada filta del result set
            //va a guarda cada celda dentro de cada atributo de mi objeto
            while (tablaResultado.next()) {
                editoriales.add(new Editorial(
                        tablaResultado.getString("nit"),
                        tablaResultado.getString("nombre_editorial"),
                        tablaResultado.getString("telefono_editorial"),
                        tablaResultado.getString("direccion_editoria")
                ));
            }
        } catch (SQLException e) {
            System.err.print("Error al listar Clientes: " + e.getMessage());
        }

        //retornamos un alista
        return editoriales;
    }

    @Override
    public boolean insertar(Editorial editorial) {
        String consulta = "{call sp_insertarcliente(?, ?, ?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {
            consultaCall.setString(1, editorial.getNit());
            consultaCall.setString(2, editorial.getNombre_editorial());
            consultaCall.setString(3, editorial.getTelefono_editorial());
            consultaCall.setString(4, editorial.getDireccion_editoria());
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.print("Error al crear Cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Editorial buscarPorId(String nit) {
        //objeto
        Editorial cliente = new Editorial();

        //consulta
        String consultaSQL = "{call sp_buscarcliente(?)}";
        //mapeamos el ResultSet al Objeto(Cliente) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setString(1, nit);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                cliente.setNit(tablaResultado.getString("nit"));
                cliente.setNombre_editorial(tablaResultado.getString("nombre_editorial"));
                cliente.setTelefono_editorial(tablaResultado.getString("telefono_editorial"));
                cliente.setDireccion_editoria(tablaResultado.getString("direccion_editorial"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Cliente: " + e.getMessage());
        }
        //retornamos el objeto
        return cliente;
    }

    @Override
    public boolean actualizar(Editorial editorial) {
        return false;
    }

    @Override
    public boolean eliminar(String nit) {
        return false;
    }

    

}