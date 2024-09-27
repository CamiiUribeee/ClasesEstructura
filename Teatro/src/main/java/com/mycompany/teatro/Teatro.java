
package com.mycompany.teatro;

import javax.swing.JOptionPane;


public class Teatro {
    
    Nodoscirculares inicio;
    
    
    Teatro(){
    inicio=null;    
    }

   
    
    public void solicitarTurno( String nombre, String documento, String genero ){
        
        Nodoscirculares nuevo= new Nodoscirculares();
        nuevo.setDocumento(documento);
        nuevo.setNombre(nombre);
        nuevo.setGenero(genero);
        nuevo.setSiguiente(nuevo);
        Nodoscirculares temporal = inicio; 
        
        if(inicio==null){
            JOptionPane.showMessageDialog(null, "Bienvenido, eres el primero en llegar");   
            inicio=nuevo;
        }else{
            while(temporal.getSiguiente()!=inicio){
                temporal=temporal.getSiguiente();
            }
            nuevo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);    
        }
 
    
    }
    
    public void imprimir(){        
        Nodoscirculares temporal=inicio;
        
        if(inicio==null){    
            
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            
        } else{
        
            do{       
                JOptionPane.showMessageDialog(null, "Documento "+ temporal.getDocumento()+" Nombre " + temporal.getNombre() +" Genero "+ temporal.getGenero());
                temporal=temporal.getSiguiente();  
            }while(temporal!=inicio);
            
        }   
    }   
    
    
    public void atender(int nboletas){
        
         
        
        
        
     
    
    
    }
    
    
        
    
    
    
}
