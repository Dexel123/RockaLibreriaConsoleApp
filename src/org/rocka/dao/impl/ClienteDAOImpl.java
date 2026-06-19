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
    public List<Clientes> listar() {
        return null;
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
