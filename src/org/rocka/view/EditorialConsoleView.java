/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocka.view;


/**
 *
 * @author informatica
 */
import org.rocka.model.Editorial;
import java.util.Scanner;
import java.util.List;
public class EditorialConsoleView {
    private final Scanner leer = new Scanner(System.in);
    
    public int mostrarMenu(){
    int opcion = 0;
    //Todo el menu 
        System.out.println("=======Gestion Editoriales=======");
        System.out.println("1. Crear nueva editorial.");
        System.out.println("2. Listar todas las editoriales");
        System.out.println("3. Buscar editoriales por nit");
        System.out.println("4. Modificar editoriales");
        System.out.println("5. Eliminar nueva editorial");
        System.out.println("6. Regresar al menu principal");
        System.out.println("======SELECCIONE UNA OPCION======");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }
    
    public String solicitarNit() {
        System.out.println("Ingrese el NIT de la editorial.");
    return leer.nextLine();
    }
    
    public String solicitarNombreEditorial(){
        System.out.println("Ingrese el nombre de la editorial.");
        return leer.nextLine();
    }
    
    public String solicitarTelefonoEditorial(){
        System.out.println("Ingrese el numero de telefono de la editorial.");
    return leer.nextLine();
    }
    
    public String solicitarDireccionEditorial(){
        System.out.println("Ingrese la direccion de la editorial.");
        return leer.nextLine();
    }
    
    public void mostrarEditorial(Editorial editorial){
        System.out.println("=====Datos Editoriales=====");
        System.out.println("NIT: " + editorial.getNit());
        System.out.println("Nombre: " + editorial.getNombre_editorial());
        System.out.println("Telefono: " + editorial.getTelefono_editorial());
        System.out.println("Direccion: " + editorial.getDireccion_editoria());
    
    }
    
    public void mostrarListaEditorial(List<Editorial> editoriales){
        System.out.println("=====Lista Editoriales=====");
        System.out.printf("%-10s %-10s %-10s %-10s\n55", "NIT", "Nombre", "Telefono", "Direccion");
        for (Editorial editorial : editoriales) {
            System.out.printf("%-10s %-10s %-10s %-10s\n",
                editorial.getNit(), editorial.getNombre_editorial(), editorial.getTelefono_editorial(), editorial.getDireccion_editoria());
        }
        
    }
    public void mostrarMensaje(String mensaje){
    
        System.out.println(mensaje);
    
    }
}
    
    
    
    




