
package com.mycompany.ejercicio01nov;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-29
 */
public class Arbol {
    
    Nodo inicial;

 
    public Arbol() {
        this.inicial = null;
    }
    
   
    
    //Metodo para insertar el arbol
    public void insertar() {
        String valor = JOptionPane.showInputDialog(null, "Ingrese su edad: ");
        try {
            int numero = Integer.parseInt(valor);
            if (this.inicial == null) {
                this.inicial = new Nodo(numero);
            } else {
                this.inicial.insertar(numero);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El dato que ingreso no es valido, por favor solamente ingrese numeros enteros");
        }
    }
    
   
    public String dispararPreorden() {
        return preorden(this.inicial); 
    }

    public String preorden(Nodo nodo) {
        if (nodo == null) {
            return "";
        } else {
            String resultado = nodo.getEdad() + ", ";
            resultado += preorden(nodo.getNodoIzq());
            resultado += preorden(nodo.getNodoDerecho());
            return resultado;
        }
    }
    
}
