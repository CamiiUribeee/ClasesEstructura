
package com.mycompany.listassimples;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Random;

public class ListasSimples {
    
    Nodo inicio; 
    
    ListasSimples(){
        inicio=null; 
    }

    public void insertarInicio(String nombre, int edad, float promedio){
        Nodo nuevo = new Nodo(); //construyo el nodo 
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            inicio=nuevo; 
        } else{
            nuevo.setEnlace(inicio);
            inicio=nuevo; 
        }
         
    }
    
    public void ordenarEnOrdenOptimizado() {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }
        
        Nodo actual = inicio;
        int cantidadNodos = getLongitud();
        
        // Creo el arreglo con los nombres para poder ordenarlos
        String[] arrayNombres = new String[cantidadNodos];
        int i = 0;
        while (actual != null) {
            arrayNombres[i++] = actual.getNombre();
            actual = actual.getEnlace();
        }

        // Ordeno con el .sort
        Arrays.sort(arrayNombres);

       
        inicio = null;
        for (String nombre : arrayNombres) {
            insertarFinal(nombre, 0, 0);  
        }

        JOptionPane.showMessageDialog(null, "Lista ordenada: " + Arrays.toString(arrayNombres));
    }
    
    //método que invoqué en el de arriba, ordenarEnorden
    public int getLongitud() {
        int longitud = 0;
        Nodo temporal = inicio;
        while (temporal != null) {
            longitud++;
            temporal = temporal.getEnlace();
        }
        return longitud;
    }
    
    
    public void insertarFinal(String nombre, int edad, float promedio){
        Nodo nuevo = new Nodo(); 
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            inicio=nuevo; 
        } else{
            Nodo temporal = inicio; 
            while (temporal.getEnlace() != null){
                temporal = temporal.getEnlace(); 
            }
            temporal.setEnlace(nuevo);
        }
        
        
    }
    
    public void consultar (){   
        Nodo temporal = inicio; 
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }else {
            do{
               JOptionPane.showMessageDialog(null, " Nombre: " + temporal.getNombre() + " La edad es: " + temporal.getEdad()+ " El promedio es: " + temporal.getPromedio());
               temporal = temporal.getEnlace();
            }while (temporal != null); 
        }
    }
    

    public void insertarPorPosicion(String nombre, int edad, float promedio, int posicion) {
        // Construyo el nuevo nodo 

        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);


        // Esto para que lo se ingrese sea correcto, o sea, el índice que ponga el usuario 
        if (posicion <= 0) {
            JOptionPane.showMessageDialog(null, "Error, la posición debe ser un número mayor a cero.");
            return; 

        }

        

        Nodo nodoActual = inicio;  
        Nodo nodoAnterior = null;  
        int posicionActual = 1;   

        
        while (nodoActual != null && posicionActual < posicion) {
            nodoAnterior = nodoActual;               // El nodo actual pasa a ser el anterior
            nodoActual = nodoActual.getEnlace();   
            posicionActual++;                      

        }
    }
  
    public void insertarEnNombre(String nombre, int edad, float promedio, String referencia) {
   
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);

        boolean nombreEncontrado = false; 
        Nodo nodoAnterior = inicio;   
        Nodo nodoSiguiente = null;   

    
        while (nodoAnterior != null) {
            if (nodoAnterior.getNombre().equals(referencia)) {
                nodoSiguiente = nodoAnterior.getEnlace(); 
                nombreEncontrado = true; 
                break; 
            }
            nodoAnterior = nodoAnterior.getEnlace(); 
        }

    
        if (nombreEncontrado) {
        
            nodoAnterior.setEnlace(nuevo);  
            nuevo.setEnlace(nodoSiguiente);  
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el nombre ingresado.");
        }
    }
    
    
    
    //OPTIMIZACIÓN 
    // Método para generar las 40 mil palabras aleatorias
    public String[] generarPalabrasAleatorias(int n) {
        String[] palabras = new String[n];
        Random random = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < n; i++) {
            StringBuilder palabra = new StringBuilder();
            int longitudPalabra = random.nextInt(3, 10);  // Palabras de entre 3 y 10 letras
            for (int j = 0; j < longitudPalabra; j++) {
                palabra.append(letras.charAt(random.nextInt(letras.length())));
            }
            palabras[i] = palabra.toString();
        }
        
        return palabras;
    }

    public void pruebaRendimiento() {
        String[] palabras = generarPalabrasAleatorias(40000);
        for (String palabra : palabras) {
            insertarFinal(palabra, 0, 0);  // Insertar en la lista
        }
        JOptionPane.showMessageDialog(null, "Se han insertado 40,000 nombres aleatorios");
    }

    
    

}

