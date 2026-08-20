package org.rocka.model;
 
public class Categoria {
    private int id_categoria;
    private String nombre_categoria;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria; 
        this.nombre_categoria = nombre_categoria;
    }


    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }


    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public void setID(long parseLong) {
        this.id_categoria = (int) parseLong;
    }

    public void setNombre(String trim) {
        this.nombre_categoria = trim;
    }

    public String getNombre() {
        return nombre_categoria;
    }

    public Object getID() {
        return id_categoria;
    }
}

