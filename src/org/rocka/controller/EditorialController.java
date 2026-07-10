/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocka.controller;

import org.rocka.view.EditorialConsoleView;
import org.rocka.dao.impl.EditorialDAOImpl;
import org.rocka.dao.EditorialDAO;
import org.rocka.model.Editorial;
/**
 *
 * @author Herberth Esteban Cuyuch Arevalo Carnet: 2026046
 */
public class EditorialController {
    
    private final EditorialDAO dao;
    private final EditorialConsoleView vista;
    
    public EditorialController(EditorialConsoleView vista){
    this.dao = new EditorialDAOImpl();
    this.vista = vista;
    }
    
    public void iniciar(){
    int opcion; 
    
    do {
        opcion = vista.mostrarMenu();
        
        switch ( opcion){
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
    }while(opcion != 4);
    
    
    
    
    }
    
    private void listar() {
        vista.mostrarListaEditorial(dao.listarTodos());
    
    }

    private void buscar() {
       String nit = vista.solicitarNit();
       Editorial editorial = dao.buscarPorId(nit);
       if(editorial != null){
           vista.mostrarEditorial(editorial);
           
           
       }else {  
           vista.mostrarMensaje("Editorial no encontrada con el nit" + nit);

    }
}}
