/*
EJERCICIO2Crea un programa que pida por pantalla2 valores numéricos enteros X e Y. 
Cree un primer array de tamaño [X,Y] de tipo entero y almacene en cada posiciónun valor entero que  deberá  ser
ingresado  por  el  usuario.  A  continuación  cree  un  segundo array de tamaño [Y,X] y almacene en cada posición 
un valor entero que deberá ser ingresado por el usuario. Finalmente cree un tercer array de tamaño [X,Y] que seráel 
resultante de multiplicarcada una de lasposiciones de lasfilas del array uno por cada una de lasposiciones de lascolumnas 
del array 2.Muestre por pantalla cada uno de los arrayscon sus valores.
 */
package com.mycompany.tp_arreglos_multidimensionales;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class ej_2 {
    public static void main(String[] args) {
        int X,Y;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entero: ");
        X=sc.nextInt();
        System.out.println("Ingrese otro numero entero: ");
        Y=sc.nextInt();
        
        int matriz1[][] = new int[X][Y];
        int matriz2[][] = new int[Y][X];
        int matriz3[][] = new int[X][Y];
        
        cargarMatriz(matriz1);
        cargarMatriz(matriz2);
        
        calcularResultado(matriz1, matriz2, matriz3);
        imprimirMatriz(matriz3);
        
        
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
    
    public static void imprimirMatriz(int matriz[][]) {
        
        for (int[] fila : matriz) {
            for (int dato : fila) {
                System.out.print(dato + " ");
            }
            System.out.println("");
        }
    }
    
    public static void calcularResultado(int matriz1[][], int matriz2[][],int matriz3[][]){
        int cont_fila = 0;
        int cont_columna = 0;
        for (int fila[] : matriz1){
            for (int dato : fila){
                matriz3[cont_fila][cont_columna] = dato * matriz2[cont_columna][cont_fila];
                cont_columna++;
            }
            cont_columna = 0;
            cont_fila++;
        }
    }
}
