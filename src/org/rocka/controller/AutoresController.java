package org.rocka.controller;
 
import org.rocka.dao.AutoresDAO;
import org.rocka.dao.impl.AutoresDAOImpl;
import org.rocka.view.AutoresConsoleView;
import org.rocka.model.Autores;
 

public class AutoresController {
    
    private final AutoresDAO dao; 
    private final AutoresConsoleView vista; 
    
    public AutoresController(AutoresConsoleView vista) { 
        this.dao = new AutoresDAOImpl(); 
        this.vista = vista; 
    }
    
    public void iniciar() {
        int opcion; 
        do {
             opcion = vista.mostrarMenu();
                switch (opcion) {
                    case 1:
                        break;
                        
                    case 2:
                        listar();
                        break;
                        
                    case 3:
                        buscar();
                        break;
                        
                    case 4:
                        
                        break;
                        
             }
         }while (opcion != 4); 
        
        
    }
    
    
    private void listar() {
        vista.mostrarListaAutores(dao.listarTodos()); 
    }
    
    
     private void buscar() {
        int id_autor = vista.solicitarID(); 
        Autores autor = dao.buscarPorId(id_autor);
        if(autor != null){
            vista.mostrarAutores(autor);
        }
    }
}