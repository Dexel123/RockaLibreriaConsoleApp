package org.rocka.model;

/**
 *
 * @author Jafeth Pérez
 */
public class Editorial {
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
    String nombreEditorial;
    String telefonoEditorial;
    String direccionEditorial;

    public Editorial(String nit, String nombreEditorial, String telefonoEditorial, String direccionEditorial) {
        this.nit = nit;
        this.nombreEditorial = nombreEditorial;
        this.telefonoEditorial = telefonoEditorial;
        this.direccionEditorial = direccionEditorial;
    }
    
    
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getTelefonoEditorial() {
        return telefonoEditorial;
    }

    public void setTelefonoEditorial(String telefonoEditorial) {
        this.telefonoEditorial = telefonoEditorial;
    }

    public String getDireccionEditorial() {
        return direccionEditorial;
    }

    public void setDireccionEditorial(String direccionEditorial) {
        this.direccionEditorial = direccionEditorial;
    }
    
    //constructores: asignacion de datos, instanciar e iniciar objetos
    // vacio
    public Editorial() {
    }}
