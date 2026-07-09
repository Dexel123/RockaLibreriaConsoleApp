
package org.rocka.view;
import java.util.List;
import java.util.Scanner;
import org.rocka.model.Clientes;

public class ClienteConsoleView {
    private final Scanner leer new Scanner(System.in);
    
    public int mostrarMenu(){
        int opcion = 0;
        
        System.out.println("----Gestion de clientes-----");
        System.out.println("-1.CREAR nuevo cliente");
        System.out.println("-2.LISTAR todos los Clientes");
        System.out.println("-3.BUSCAR Cliente por ID ");
        System.out.println("-4.MODIFICAR Cliente");
        System.out.println("-5.ELIMINAR nuevo Cliente");
        System.out.println("-6.REGRESAR a menú principal");
        System.out.println("SELECCIONE UNA OPCIÓN  ");
        return opcion;
    }
    
    public long solicitarCui(){
        System.out.println("Ingrese el CUI del cliente");
        return Long.parseLong( leer.nextLine());
    }
    
    
    public String solicitarApellidoCliente(){
        System.out.println("Ingrese el APELLIDO del cliente");
        return leer.nextLine();
    }     
    
    public String solicitarCorreoElectronico(){
        System.out.println("Ingrese el CORREO del cliente");
        return leer.nextLine();
    }
    
    public void mostrarCliente(Clientes cliente){
        System.out.println("-- DATOS DEL CLIENTE --");
        System.out.println("CUI: " + cliente.getCui());
        System.out.println("NOMBRE: " + cliente.getNombre());
        System.out.println("APELLIDO: "+ cliente.getApellido());
        System.out.println("CORREO: " + cliente.getCorreoElectronico());
    }
   
    public void mostrarListaCliente(List<Clientes>clientes){
        System.out.println("-- LISTA DE CLIENTES---");
        System.out.printf("%-10s  %10s  %10s %10s", "CUI","NOMBRE", "APELLIDO", "CORREO");
        
        for (Clientes cliente : clientes)
    }
    
}
