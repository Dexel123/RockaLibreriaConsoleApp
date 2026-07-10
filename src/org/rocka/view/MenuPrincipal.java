package org.rocka.view;

import java.util.Scanner;
import org.rocka.controller.CategoriaController;

public class MenuPrincipal {
    Scanner leer = new Scanner(System.in);

    public void iniciar(){
        int opcion = 0;
        do {
            System.out.println("Bienvenido, seleccione una opcion!");
            System.out.println("1. Modulo Categorias");
            System.out.println("2. Salir");

            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {
                case 1:
                    CategoriaConsoleView vistaCat = new CategoriaConsoleView();
                    CategoriaController controlCat = new CategoriaController(vistaCat);
                    controlCat.iniciar();
                    break;
                case 2:
                    System.out.println("Adiós Vaquero!");
                    break;   
                default:
                    System.out.println("NO existe esta opción");
            }
        } while (opcion != 2);
    }
}
 