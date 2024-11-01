
package com.mycompany.ejercicio01nov;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-29
 */
public class Nodo {
    
    int edad;
    String sexo; 
    String nombre; 
    int valor; 
    Nodo nodoIzq;
    Nodo nodoDerecho;

    public Nodo(int edad) {
        this.edad = edad;
        this.sexo = "";  
        this.nombre = ""; 
        this.valor = 0;   
        this.nodoIzq = null; 
        this.nodoDerecho = null; 
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public Nodo getNodoIzq() {
        return nodoIzq;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void insertar(int valor) {
        
        if (valor == this.edad) {
            JOptionPane.showMessageDialog(null, "Ese número ya está en el árbol");
            return;
        }

        if (valor < this.edad) { // Menor va a la derecha
            if (this.nodoDerecho == null) {
                this.nodoDerecho = new Nodo(valor);
            } else {
                this.nodoDerecho.insertar(valor);
            }
        } else { // Mayor o igual va a la izquierda
            if (this.nodoIzq == null) {
                this.nodoIzq = new Nodo(valor);
            } else {
                this.nodoIzq.insertar(valor);
            }
        }
    }
    
}   
















    

    
  

