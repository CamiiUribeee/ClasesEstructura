
package com.mycompany.tallerclase;

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
    
    
}
