
package com.mycompany.dobles;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-29
 */
public class Dobles {

    NodoDoble inicio; 
    
    Dobles(){
        inicio=null; 
    }
    
    public void insertarInicio(String dato){
        
        NodoDoble nuevo = new NodoDoble(); 
        nuevo.setAnterior(nuevo);
        nuevo.setSiguiente(nuevo);
        nuevo.setDato(dato); //el dato se asigna al nodo 
        
        if (inicio == null){
            inicio=nuevo; 
        }else {
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
            
        }
    }
    
    public void imprimir(){
        NodoDoble temporal = inicio; 
        
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "No hay nadie en la lista");
        }else{
            while(temporal.getSiguiente() != null){
                JOptionPane.showMessageDialog(null, "Datos : " + temporal.getDato());
                temporal=temporal.getSiguiente(); 
            }
        }
    }
    
    public void insertarFinal(String dato){
        
        NodoDoble nuevo = new NodoDoble(); 
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDato(dato); //el dato se asigna al nodo 
        
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
