/*
 EJERCICIO3Codifique un programa que solicite un valor enteroXmayor o igual a 3 y 
menor o igual a 10. Cree un arreglo de tamaño[X,X]de tipo int. Posteriormente solicitelos 
valores  necesarios  para  cargar  cada  una  de  las  celdas  de  la  matriz. 
Muestre  por pantalla la matriz resultante. Al finalizar la cargasume cada una de las columnas del 
array y asigne los resultados en una nueva matriz de una dimensión,finalmente sume los valores de 
estaúltima matriz y muestre el resultadoporpantalla.
 */
package com.mycompany.tp_arreglos_multidimensionales;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class ej_3 {
    public static void main(String[] args) {
        int X = 0;
        int matriz[][], resultado[];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un entero mayor o igual a 3 y menor o igual a 10: ");
        while(X < 3 || X > 10){
            X = sc.nextInt();
            if(X < 3 || X > 10){
                System.out.println("Intente de nuevo...");
            }
        }
        
        matriz = new int[X][X];
        resultado = new int[X];
        
        cargarMatriz(matriz);
        imprimirMatriz_2dim(matriz);
        
        sumarColumnas(matriz, resultado);
        imprimirMatriz_1dim(resultado);
        System.out.println("\nLa suma de los elementos de la matriz resultado es: " + sumatoriaTotalMatriz_1dim(resultado));
    }
    
    public static void cargarMatriz(int matriz[][]){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i< matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                System.out.println("Ingrese un entero para la fila " + i + " coluna " + j + " de la matriz: ");
                matriz[i][j] = sc.nextInt();
            }
            
        }
    }
    
    public static void imprimirMatriz_2dim(int matriz[][]) {
        System.out.println("\nMatriz ingresada: \n");
        
        for (int[] fila : matriz) {
            System.out.print("| ");
            for (int dato : fila) {
                System.out.print(dato + " ");
            }
            System.out.println("|");
        }
    }
    
    public static void imprimirMatriz_1dim(int matriz[]) {
        System.out.println("\nMatriz resultado: \n");
            
        System.out.print("| ");
        for (int dato : matriz) {
            System.out.print(dato + " ");
        }
        System.out.println("|");
        
    }
    
    public static void sumarColumnas(int matriz[][] , int resultado[]){
        int suma = 0;
        for (int i=0 ; i<matriz[0].length ; i++){
            for (int fila [] : matriz) {
                suma += fila[i];
            }
            resultado[i] = suma;
            suma = 0;
        }
    }
    
    public static int sumatoriaTotalMatriz_1dim(int matriz[]) {
        int sumatoria = 0;
        for (int dato : matriz){
            sumatoria += dato;
        }
        return sumatoria;
    }
}
