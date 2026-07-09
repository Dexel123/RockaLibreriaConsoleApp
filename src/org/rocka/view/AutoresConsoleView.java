package org.rocka.view;

import java.util.Scanner;
import java.util.List;
import org.rocka.model.Autores;

public class AutoresConsoleView {
    private final Scanner leer = new Scanner(System.in);
    
    //metodo para mostrar las opciones del menu
    public int mostararMenu(){
        int opcion = 0;
        //todo el menu
        
        System.out.println("---DESTIOON DE AUTORES---");
        System.out.println("-1. crear nuevo autor");
        System.out.println("-2. listar todos los autores ");
        System.out.println("-3. buscar autor por id");
        System.out.println("-4.modificar autor");
        System.out.println("-5. eliminar nuevo autor");
        System.out.println("-6.REGREAR AL MENU PRINCIPAL");
        System.out.println("SELECCIONE UNA OPCION ->");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
        
    }
    
public int solicitarID() {
System.out.println("Ingrese el id del autor");
return Integer.parseInt(leer.nextLine());

}



public String solicitarNombreAutor() {
String nombre_autor;
System.out.println("Ingrese el nombre del autor");
nombre_autor = leer.nextLine();

return leer.nextLine();

}

public String solicitarNacionalidad() {
String nacionalidad;
System.out.println("Ingrese la nacionalidad del autor");
nacionalidad = leer.nextLine();

return leer.nextLine();
}


public String solicitarApellidoAutor() {
String apellido_autor;
System.out.println("Ingrese el apellido del autor");
apellido_autor = leer.nextLine();

return leer.nextLine();

}

public String solicitarBiografia() {
String biografia;
System.out.println("Ingrese la biografia del autor");
biografia = leer.nextLine();
return leer.nextLine();

}

public void mostrarAutores(Autores Autor){
        System.out.println("=====Datos Editoriales=====");
        System.out.println("ID" + Autor.getId());
        System.out.println("Nombre" + Autor.getNombre_autor());
        System.out.println("Nacionalidad" + Autor.getNacionalidad());
        System.out.println("Apellido" + Autor.getApellido());
    }
    public void mostrarListaEditorial(List<Autores> Autor){
        System.out.println("=====Lista Editoriales=====");
        System.out.printf("%-10s %-10s %-10s %-10s", "NIT", "Nombre", "Telefono", "Direccion");
        for (Autores editoriales : Autor) {
            System.out.printf("%-10s %-10s %-10s %-10s",
                editoriales.getId(), editoriales.getNombre_editorial(), editoriales.getTelefono_editorial(), editoriales.getDireccion_editoria());
        }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    }

