
package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Menu {
    
    String platos[ ]; 
    int datos[ ][ ]; //matriz para los platos cada dia de la semana 
    String dias[ ] = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
    Platos arrayObjetos[]; //platos es igual a mi arrayOjetos 
    int ganancia; //Resta entre lo que me cuesta y el valor en el que lo vendo, tengo que generar la ganancia total
    
    
    
    public void crearMenu (int cantidad){
        
        arrayObjetos = new Platos[cantidad]; 
        Platos obj = new Platos(JOptionPane.showInputDialog("Diga el nombre del plato: ")); 
          
        
        // platos = new String [cantidad]; //lo quitamos porque pusimos el arrayObjetos 
       
        for (int i = 0; i < arrayObjetos.length; i++){
            arrayObjetos[i] = new Platos(JOptionPane.showInputDialog("Diga el nombre del plato: " +(i+1))); //ARREGLAR 
            arrayObjetos[i] = new Platos((JOptionPane.showInputDialog("Diga el precio del plato: ")));  //ARREGLAR 
            
            
            analizar(JOptionPane.showInputDialog("Ingrese el precio de venta del plato:")); 
            analizar(JOptionPane.showInputDialog("Ingrese el costo de producción del plato:"));
            
        }
    }
    
    public void consultarMenu(){
        //for (int i=0; i<platos.length; i++){
            //JOptionPane.showConfirmDialog(null, " Platos:" + platos[i]);
        //}
        
        for (int i = 0; i < arrayObjetos.length; i++){  //arreglar 
            JOptionPane.showConfirmDialog(null, " Platos: " + platos[i] ); 
        }
    }
    
    public void ingresarDatos(){
        datos = new int [6][platos.length]; // matriz platos por cada día de la semana  
        for (int f=0; f<6; f++){  //filas 
            for (int c=0; c<platos.length; c++){          //columna 
                datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ventas para el dia: " + dias[f] + " Platos: " + platos[c])); 
            }
        } 
    }
    
    public String analizarInfo(){
        //cuánto se vendió de determinado plato en la semana:
        StringBuilder total = new StringBuilder();  //builder para concatenar mucho mejor 
        
        String dias []= new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        
        //total general de todos los platos vendidos a la semana: 
        int totalGeneralPlatos = 0; 
        
        for (int c=0; c<platos.length; c++){
            int suma = 0; 
            //nuevas variables para reportar qué día se vende más de cierto plato: 
            int diaMaxVentas = -1; 
            int maxVentas = -1; 
            
            //nuevas variables para reportar qué dia se vende menos de cierto plato: 
            int minVentas = Integer.MAX_VALUE; //para valores máximos 
            int diaMinVentas = -1; 
            
            for (int f=0; f<6; f++){
                suma += datos [f][c];
                totalGeneralPlatos += datos [f][c]; 
                
                if (datos [f][c] > maxVentas){ //si la cantidad de un plato en específico es mayor a -1... 
                    maxVentas = datos [f][c]; //esta variable me va a buscar el valor más alto 
                    diaMaxVentas = f; 
                }
                
                if (datos [f][c] < minVentas){
                    minVentas = datos [f][c];
                    diaMinVentas = f;
                }
            }
            
            total.append("La cantidad total de ").append(platos[c]).append(" que fue vendida en la semana es de: ").append(suma).append("\n");
            
            if (diaMaxVentas != -1) {
                total.append("El día con más ventas para ").append(platos[c]).append(" fue ").append(dias[diaMaxVentas]).append(" con ").append(maxVentas).append(" ventas.\n");
           
            }
            
            if (diaMinVentas != -1) {
                total.append("El día con menos ventas para ").append(platos[c]).append(" fue ").append(dias[diaMinVentas]).append(" con ").append(minVentas).append(" ventas.\n");
           
            }
            
  
        }
        //es total.append porque total es la variable que almacena mi string 
        total.append("La cantidad total de platos vendidos a la semana es de: ").append(totalGeneralPlatos);
        
        
        
        
        return total.toString(); 
          
    }
    
    public void analizar (String showInputDialog){
        for (int f=0; f<6; f++){
            for (int c=0; c<arrayObjetos.length; c++){
               ganancia += datos[f][c]*platos[c].getGanancia(); //por que no sirve? 
            } 
        }
    }
    
    
    
    
    
}
