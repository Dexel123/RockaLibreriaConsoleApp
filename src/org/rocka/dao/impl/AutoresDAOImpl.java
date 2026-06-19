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
    public List<Autores> listar() {     
        return null;
    }

    @Override
    public Autores buscar(int id_autores) {
           return null;
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
