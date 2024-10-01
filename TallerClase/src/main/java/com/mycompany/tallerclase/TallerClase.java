
package com.mycompany.tallerclase;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-29
 */
public class TallerClase {

    //crear un boton que cree la lista donde el que llegue quede de ultimo, nombre y edad. 
    
    NodoDoble inicio; 
    
    TallerClase(){
        inicio=null; 
    }
    
    public void insertarAlFinal(String nombre, int edad){
        NodoDoble nuevo = new NodoDoble(); 
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(nombre); //el nombre se asigna al nodo 
        nuevo.setEdad(edad); //la edad se asigna al nodo 
        
        if (inicio != null){
          
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
        }else{
            NodoDoble temporal = inicio; 
            while(temporal.getSiguiente()!=null){
                temporal = temporal.getSiguiente();
             
            }
            temporal.setSiguiente(nuevo);
            nuevo.setAnterior(temporal);
            nuevo.setSiguiente(null);
        }
        
    }
    
    public void consultar (){   
        NodoDoble temporal = inicio; 
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }else {
            do{
               JOptionPane.showMessageDialog(null, " Nombre: " + temporal.getNombre() + " La edad es: " + temporal.getEdad());
               temporal = temporal.getEnlace();
            }while (temporal != null); 
        }
    }
    
    
}
