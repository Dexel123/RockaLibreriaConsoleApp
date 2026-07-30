package org.rocka.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rocka.dao.CategoriaDAO;
import org.rocka.model.Categoria;
import org.rocka.util.Conexion;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        String consulta = "{call sp_listarcategorias()}";

        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
             ResultSet tablaResultado = consultaCall.executeQuery()) {

            while (tablaResultado.next()) {
                categorias.add(new Categoria(
                        tablaResultado.getInt("id_categoria"),
                        tablaResultado.getString("nombre_categoria")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Categorías: " + e.getMessage());
        }

        return categorias;
    }

    @Override
    public boolean crear(Categoria categoria) {
        String consulta = "{call sp_insertarcategoria(?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            // Se usa el getter real de tu modelo: getNombre_categoria()
            consultaCall.setString(1, categoria.getNombre_categoria());

            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear Categoría: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Categoria buscarPorId(int idCategoria) {
        Categoria categoria = null;
        String consultaSQL = "{call sp_buscarcategoria(?)}";

        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consultaSQL)) {

            consultaCall.setInt(1, idCategoria);
            try (ResultSet tablaResultado = consultaCall.executeQuery()) {
                if (tablaResultado.next()) {
                    categoria = new Categoria();
                    // Se usan los setters reales de tu modelo
                    categoria.setId_categoria(tablaResultado.getInt("id_categoria"));
                    categoria.setNombre_categoria(tablaResultado.getString("nombre_categoria"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Categoría: " + e.getMessage());
        }

        return categoria;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        String consulta = "{call sp_actualizarcategoria(?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            // Se usan los getters reales de tu modelo
            consultaCall.setInt(1, categoria.getId_categoria());
            consultaCall.setString(2, categoria.getNombre_categoria());

            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar Categoría: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idCategoria) {
        String consulta = "{call sp_eliminarcategoria(?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            consultaCall.setInt(1, idCategoria);

            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar Categoría: " + e.getMessage());
            return false;
        }
    }
}