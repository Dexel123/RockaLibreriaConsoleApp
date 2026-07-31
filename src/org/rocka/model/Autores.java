package org.rocka.model; 
public class Autores {
   
    /*
    create table autores(
	idAutor int primary key auto_increment,
    nombreAutor varchar(100) not null,
    apellidoAutor varchar(100) not null,
    nacionalidad varchar(100),
    biografia text

    */
    
    //atributos de clase
    int idAutor;
    String nombreAutor;
    String nacionalidad;
    String apellidoAutor;
    String biografia;
    
    
   
    public Autores() {
    }
   
    // lleno con parametros
    public Autores(int idAutor, String nombreAutor, String nacionalidad, String apellidoAutor, String biografia) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
        this.apellidoAutor = apellidoAutor;
        this.biografia = biografia;
    }
    //personalizados
    
    
     //getter and setters

    public int getId_autor() {
        return idAutor;
    }

    public void setId_autor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
   
        return nombreAutor;
    }

    public void setNombre_autor(String nombreAutor) {
            
            String nombreMayuscualas = nombreAutor.toUpperCase();
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellido_autor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
}
