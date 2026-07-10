package org.rocka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rocka.util.Conexion; 
import org.rocka.dao.CategoriaDAO;
import org.rocka.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public boolean insertar(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre_categoria) VALUES (?)";
        try (Connection con = Conexion.getInstancia().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre_categoria());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id_categoria, nombre_categoria FROM categorias";
        try (Connection con = Conexion.getInstancia().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt("id_categoria"));
                cat.setNombre_categoria(rs.getString("nombre_categoria"));
                lista.add(cat);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Categoria buscar(int id_categoria) {
        Categoria categoria = null;
        String sql = "SELECT id_categoria, nombre_categoria FROM categorias WHERE id_categoria = ?";
        
        try (Connection con = Conexion.getInstancia().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id_categoria);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId_categoria(rs.getInt("id_categoria"));
                    categoria.setNombre_categoria(rs.getString("nombre_categoria"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la categoría: " + e.getMessage());
        }
        return categoria;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre_categoria = ? WHERE id_categoria = ?";
        try (Connection con = Conexion.getInstancia().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre_categoria());
            ps.setInt(2, categoria.getId_categoria());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id_categoria) {
        String sql = "DELETE FROM categorias WHERE id_categoria = ?";
        try (Connection con = Conexion.getInstancia().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_categoria);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}