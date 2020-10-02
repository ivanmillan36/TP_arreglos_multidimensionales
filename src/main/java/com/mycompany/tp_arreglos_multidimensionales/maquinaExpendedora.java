/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_arreglos_multidimensionales;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class maquinaExpendedora {

    String inventario[][] = 
        {{"KitKat", "32", "10"},
         {"Chicles", "2", "50"},
         {"Caramelos de Menta", "2", "50"},
         {"Huevo Kinder", "25", "10"},
         {"Chetoos", "30", "10"},
         {"Twix", "26", "10"},
         {"M&M'S", "35", "10"},
         {"Papas Lays", "40", "20"},
         {"Milkybar", "30", "10"},
         {"Alfajor Tofi", "20", "15"},
         {"Lata Coca", "50", "20"},
         {"Chitos", "45", "10"},
        };
    int ganancia = 0;
    String passwordAdmin = "AdminXYZ";
   
   public String pedirGolosina(){
        int numProducto = 0;
        String productoExtraido;
        Scanner sc = new Scanner(System.in);
        imprimirInventario();
        System.out.println("\nIntroduce el numero de la golosina que quieras: ");
        do{
            if(numProducto < 0 || numProducto >= this.inventario.length) System.out.println("Numero invalido, introduzca otro numero: ");
            numProducto = sc.nextInt();
            productoExtraido = extraerProducto(numProducto);
        }while(numProducto < 0 && numProducto > this.inventario.length);
        
        while(productoExtraido.compareTo("") == 0 || productoExtraido.compareTo("Sin Stock") == 0){
            System.out.println("Sin stock de: " + this.inventario[numProducto][0]);
            System.out.println("Solicite un producto diferente: ");
            numProducto = sc.nextInt();
            productoExtraido = extraerProducto(numProducto);
        }
        
        agregarGanancia(getPrecioProducto(numProducto));
        return productoExtraido;
    }
   
   public void imprimirInventario(){
       for(int i=0 ; i<this.inventario.length ; i++){
            System.out.println("Producto " + i + "\t" + this.inventario[i][0] + "\t\t\tprecio: " + this.inventario[i][1] + "$ \t// stock: " + this.inventario[i][2] + " unidades");
       }
   }
    
   private String extraerProducto(int numProduto){
       int stock = getStockProducto(numProduto);
       if (stock == 0){
           return "Sin Stock";
       }else{
           stock--;
           this.inventario[numProduto][2] = Integer.toString(stock);
       }
       return this.inventario[numProduto][0];
   }
   
   private int getStockProducto(int numProducto){
       if(numProducto < 0 || numProducto >= this.inventario.length){
           return -1;
       }else{
           return Integer.parseInt(this.inventario[numProducto][2]);
       }
   }
   
   private String getNombreProducto(int numProducto){
       if(numProducto < 0 || numProducto >= this.inventario.length){
           return "error";
       }else{
           return this.inventario[numProducto][0];
       }
   }
   
   private int getPrecioProducto(int numProducto){
       if(numProducto < 0 || numProducto >= this.inventario.length){
           return -1;
       }else{
           return Integer.parseInt(this.inventario[numProducto][1]);
       }
   }
   
   private void agregarGanancia(int ganancia){
       this.ganancia += ganancia;
   }
   
   public void agregarStock(){
       Scanner sc = new Scanner(System.in);
       int numProducto = 0;
       int stock = 0, stockAgregar = 0;
       System.out.println("Introduzca password de administrador: ");
       String pass = sc.nextLine();
       
       if(pass.compareTo(this.passwordAdmin) == 0){
            imprimirInventario();
            System.out.println("\nIntroduce el numero de la golosina que quieras: ");
            do{
                if(numProducto < 0 || numProducto >= this.inventario.length) System.out.println("Numero invalido, introduzca otro numero: ");
                    numProducto = sc.nextInt();
            }while(numProducto < 0 && numProducto >= this.inventario.length);
            
            do{
                System.out.println("Ingrese la cantidad que desea agregar de " + getNombreProducto(numProducto));
                stockAgregar = sc.nextInt();
                if(stockAgregar <= 0) System.out.println("Error, ingreso una cantidad negativa o cero...\n");
            }while(stockAgregar <= 0);
            
            stock = getStockProducto(numProducto);
            stock = stock + stockAgregar;
            this.inventario[numProducto][2] = Integer.toString(stock);
            
       }else{
           System.out.println("\n***Password incorrecta...\n");
       }
   }
   
   public int apagarMaquina(){
       return this.ganancia;
   }
   
}
