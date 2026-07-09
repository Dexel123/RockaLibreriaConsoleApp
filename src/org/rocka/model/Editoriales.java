package org.rocka.model;

/**
 *
 * @author Jafeth Pérez
 */
public class Editoriales {
    /*
    create table clientes(
	cui bigint primary key,
    nombre_cliente varchar(100),
    apellido_cliente varchar(100),
    correo_electronico varchar(100)
);
    */
    // atributos de clase
    String nit;
    String nombre_editorial;
    String telefono_editorial;
    String direccion_editoria;

    public Editoriales(String nit, String nombre_editorial, String telefono_editorial, String direccion_editoria) {
        this.nit = nit;
        this.nombre_editorial = nombre_editorial;
        this.telefono_editorial = telefono_editorial;
        this.direccion_editoria = direccion_editoria;
    }
    
    
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getTelefono_editorial() {
        return telefono_editorial;
    }

    public void setTelefono_editorial(String telefono_editorial) {
        this.telefono_editorial = telefono_editorial;
    }

    public String getDireccion_editoria() {
        return direccion_editoria;
    }

    public void setDireccion_editoria(String direccion_editoria) {
        this.direccion_editoria = direccion_editoria;
    }
    
    //constructores: asignacion de datos, instanciar e iniciar objetos
    // vacio
    public Editoriales() {
    }}
