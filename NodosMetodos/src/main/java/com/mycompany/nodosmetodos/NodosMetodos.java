
package com.mycompany.nodosmetodos;

import javax.swing.JOptionPane;

public class NodosMetodos {

    Nodo inicio;
    int longitud=0; 
    
    NodosMetodos(){
        inicio=null; 
    }
    
    //PRIMER MÉTODO: INSERTAR UN NODO AL INICIO (LLEGA UN NODO Y SE POSICIONA DE PRIMERO):
    public void insertarNodoAlInicio(String nombre, int edad, float promedio) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        }
        else {
            nuevo.setEnlace(inicio); //Si la lista no está vacía, 
            inicio = nuevo;          //el nuevo nodo se enlaza al nodo que actualmente está de primero 
        }                            //y luego se actualiza el puntero inicio para que el nuevo nodo sea el primero de la lista
        longitud++;
    }
    
    
    //SEGUNDO MÉTODO: INSERTAR UN NODO AL FINAL DE LA LISTA 
    public void insertarNodoAlFinal(String nombre, int edad, float promedio) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        }
        else {
            
            Nodo temporal = inicio; //esta variable temporal va a apuntar al nodo inicio
            while(temporal.getEnlace()!=null) {  //mientras esa variable apunte a un nodo, o sea, mientras hayan nodos
                temporal = temporal.getEnlace(); //la variable temporal se actualiza a cada nodo siguiente 
            }
            temporal.setEnlace(nuevo); //le asigno el ultimo valor a esa variable temporal 
        }
        longitud++;
    }
    
    
    //TERCER MÉTODO: INSERTAR DESPUÉS DEL ÍNDICE 
    public void insertarEnIndice(String nombre, int edad, float promedio, int indice) {
        Nodo nuevo = new Nodo();
        
        nuevo.setName(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        boolean indiceEncontrado = false;
        int posicion = 1;        
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Cambia de posición iniciando en la 1
        if (indice <= 0) {
            JOptionPane.showMessageDialog(null, "El indice debe ser un número mayor a cero.");
        }
        else {
            while(anterior!=null) {
                if (posicion==indice) {
                    siguiente = anterior.getEnlace(); //se guarda el enlace del nodo actual en la variable siguiente
                    indiceEncontrado = true;
                    break;
                }
                anterior = anterior.getEnlace(); //si no se encuentra el índice avanza al siguiente nodo
                posicion++;
            }
            if (indiceEncontrado) {
                anterior.setEnlace(nuevo); //cuando hay un . significa que se enlaza, en este caso se enlaza el nodo anterior al nuevo
                nuevo.setEnlace(siguiente);
                longitud++;
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encontró el indice ingresado.");
            }
        }
                
        
    }
    
    
    //CUARTO MÉTODO: INSERTAR ANTES DEL ÍNDICE
    public void insertarAntesDeIndice(String nombre, int edad, float promedio, int indice) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        boolean indiceEncontrado = false;
        int posicion = 1;        
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Cambia de posición iniciando en la 1
        if (indice <= 0) {
            JOptionPane.showMessageDialog(null, "El indice debe ser un númeo mayor a cero.");
        }
        else if (indice == 1) {
            insertarNodoAlInicio(nombre, edad, promedio);
        }
        else {
            while(anterior!=null) {
                if (posicion+1==indice) {
                    siguiente = anterior.getEnlace();
                    indiceEncontrado = true;
                    break;
                }
                anterior = anterior.getEnlace();
                posicion++;
            }
            if (indiceEncontrado) {
                anterior.setEnlace(nuevo);
                nuevo.setEnlace(siguiente);
                longitud++;
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encontró el indice ingresado.");
            }
        }
    }
    
    
    //MÉTODO DE ORDENACIÓN QUICKSORT 
    public class QuickSort {
        public static void quickSort(int[] array, int low, int high) {  //mando al array, al valor bajo y al valor alto
            if (low < high) {  //low tiene que ser menor, porque si no lo fuera, significaría que ya no hay mas elementos altos después del pivote
                int pi = partition(array, low, high); //la función partition es la que me divide el arreglo en subarreglos 
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
        }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; //el pivote va a ser el ultimo numero del arreglo 
        int i = (low - 1); //el contador i me rastrea los elementos que van antes del pivote, o sea, los valores menores
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) { //si el numero actual es menor al pivote 
                i++;                 //se incrementa el contador i que es para los numeros menores al pivote
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;
        quickSort(array, 0, n - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
    



    
    
    
    
    
    
    
    
    
    //MÉTODO PARA VER CUANTAS ENTRADAS SE VAN INGRESANDO: 
    public int getLongitud() {
        return longitud;
    }
    
    
    
    //MÉTODO PARA CONSULTAR TODO LO SE INGRESE: 
    public void consultar() {
    
        // Ubicarme al nodo inicial para recorrer la lista
        Nodo temporal = inicio;
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
        }
        else {        
            do {
            JOptionPane.showMessageDialog(null, " Nombre: "+temporal.getName()+ " Edad: "+temporal.getEdad() + " Promedio: "+temporal.getPromedio());
            temporal = temporal.getEnlace();
            } while (temporal!=null);
        }
        
        JOptionPane.showMessageDialog(null, "Hay "+getLongitud()+" nodo(s) en la lista.");
    
    }
    
    
}
