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
public class matriz {
    int orden;
    int matriz [][];

    public matriz(int orden) {
        this.orden = orden;
        this.matriz = new int[orden][orden];
        inicializarMatrizCero();
    }
    
    private void inicializarMatrizCero(){
        for(int i=0; i< matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matriz[i][j] = 0;
            }
        }
    }
    
    public void rellenarMatriz(){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i< this.matriz.length; i++){
            for(int j=0; j<this.matriz[0].length; j++){
                System.out.println("Ingrese un entero para la fila " + i + " coluna " + j + " de la matriz: ");
                this.matriz[i][j] = sc.nextInt();
            }
            
        }
    }
    
    public void imprimirMatriz() {
        System.out.println("\nMatriz ingresada: \n");
        
        for (int[] fila : this.matriz) {
            System.out.print("| ");
            for (int dato : fila) {
                System.out.print(dato + " ");
            }
            System.out.println("|");
        }
    }
    
    public int sumarElementosFila (int num_fila){
        int suma = 0;
        
        while (num_fila >= this.matriz.length || num_fila < 0){
            System.out.println("La fila ingresada excede los limites del arreglo, ingrese nuevamente la fila...");
            Scanner sc = new Scanner(System.in);
            num_fila = sc.nextInt();
            }
        
        for(int dato : this.matriz[num_fila]){
            suma += dato;
        }
        return suma;
    }
    
    public int sumarElementosColumna (int num_columna){
        int suma = 0;
        
        while (num_columna >= this.matriz[0].length || num_columna < 0){
            System.out.println("La columna ingresada excede los limites del arreglo, ingrese nuevamente la fila...");
            Scanner sc = new Scanner(System.in);
            num_columna = sc.nextInt();
            }
        
        for(int fila[] : this.matriz){
            suma += fila[num_columna];
        }
        return suma;
    }
    
    public int sumarElementosDiagonalPrincipal(){
        int cont = 0;
        int suma = 0;
        
        for (int fila[] : this.matriz){
            suma += fila[cont];
            cont++;
        }
        return suma;
    }
    
    public int sumarElementosDiagonalInversa(){
        int cont = this.orden - 1;
        int suma = 0;
        
        for (int fila[] : this.matriz){
            suma += fila[cont];
            cont--;
        }
        return suma;
    }
    
    public int sumarTodosLosElementos(){
        int suma = 0;
        
        for (int fila[] : this.matriz){
            for (int dato : fila){
                suma += dato;
            }
        }
        return suma;
    }
}
