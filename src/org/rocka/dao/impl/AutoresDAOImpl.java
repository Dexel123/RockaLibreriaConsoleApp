package org.rocka.dao.impl;
import org.rocka.util.Conexion;
import org.rocka.model.Autores;
import org.rocka.dao.AutoresDAO;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

        
public class AutoresDAOImpl implements AutoresDAO{
    @Override
    public boolean insertar(Autores autores) {
     String consulta = "{call sp_insertarautor(?, ?, ?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {          
            consultaCall.setString(1, autores.getNombreAutor());
            consultaCall.setString(2, autores.getApellidoAutor());
            consultaCall.setString(3, autores.getNacionalidad());
            consultaCall.setString(4, autores.getBiografia());
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.print("Error al crear Autor: " + e.getMessage());
            return false;
        }
    }
    @Override
public List<Autores> listarTodos() {      
    List<Autores> Autor = new ArrayList<>();
    String consulta = "{call sp_listarautores()}";              
    
    try (Connection conexion = Conexion.getInstancia().conectar(); 
         CallableStatement consultaCall = conexion.prepareCall(consulta); 
         ResultSet tablaResultado = consultaCall.executeQuery();) {
       
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
        e.printStackTrace();
    }        
    return Autor;
}

@Override
public Autores buscarPorId(int id_autor) {
    Autores autor = new Autores();
    String consultaSQL = "{call sp_buscarautor(?)}";
    try (Connection conexion = Conexion.getInstancia().conectar();
         CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
        consultaCall.setInt(1, id_autor);
        try (ResultSet tablaResultado = consultaCall.executeQuery()) {
            if (tablaResultado.next()) {
                autor.setIdAutor(tablaResultado.getInt("id_autor"));
                autor.setNombreAutor(tablaResultado.getString("nombre_autor"));
                autor.setApellidoAutor(tablaResultado.getString("apellido_autor"));
                autor.setNacionalidad(tablaResultado.getString("nacionalidad"));
                autor.setBiografia(tablaResultado.getString("biografia"));
            } else {
                return null;
            }
        }
    } catch (SQLException e) {
        System.err.print("Error al buscar Autor: " + e.getMessage());
        e.printStackTrace();
    }
    return autor;
}
        
    @Override
    public boolean actualizar(Autores autores) {
        return false;
    }
    @Override
    public boolean eliminar(int idAutores) {
        return false;
    }
}