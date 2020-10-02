/*
EJERCICIO4Codifique un programa que solicite un valor enteroXmayor o igual a 4y menor o igual  a 10. 
Cree  un  arreglo  de  tamaño[X,X]de  tipo int,  nos  piden  hacer  un  menú con estas opciones:

a)Rellenar TODA la matriz de números, debes pedírselo al usuario.
b)Suma de una fila que se pedirá al usuario (validarque elija una correcta)
c)Suma  de  una  columna  que  se  pedirá  al  usuario  (controlar  que  elija  una correcta)
d)Sumar la diagonal principal
e)Sumar la diagonal inversa 
f)La media de todoslos valores de la matriz

IMPORTANTE: hasta que no se haga la primera opcióna, 
el resto de opciones no se deberán  de  ejecutar,  simplemente  mostrar  un  mensaje que diga  que 
debes rellenar la matriz.Mostrar por pantalla el resultado de la ejecuciónde cada una de las opciones del menú
 */
package com.mycompany.tp_arreglos_multidimensionales;

import java.util.Scanner;


/**
 *
 * @author ivanmillan36
 */
public class ej_4 {
    public static void main(String[] args) {
        int X = 0;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un entero mayor o igual a 4 y menor o igual a 10 para declarar el orden de la matriz: ");
        while(X < 4 || X > 10){
            X = sc.nextInt();
            if(X < 4 || X > 10){
                System.out.println("Intente de nuevo...");
            }
        }
        
        matriz mi_matriz = new matriz(X);
        
        solicitarOpcion(mi_matriz);
        
    }
    
    public static void imprimirMenu(){
        System.out.println("a)Rellenar la matriz con números ingresados por el usuario");
        System.out.println("b)Sumar elementos de una determinada fila");
        System.out.println("c)Sumar elementos de una determinada columna");
        System.out.println("d)Sumar elementos de la diagonal principal");
        System.out.println("e)Sumar elementos de la diagonal inversa");
        System.out.println("f)Sumar todos los elementos de la matriz");
        System.out.println("g)Salir");
    }
    
    public static void solicitarOpcion(matriz mi_matriz) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        while(opcion.compareTo("g") != 0){
            
            System.out.flush();
            imprimirMenu();
            System.out.println("\nIngrese la opcion a elegir: ");
            opcion = sc.nextLine();
            switch (opcion){
                case "a":
                    mi_matriz.rellenarMatriz();
                    mi_matriz.imprimirMatriz();
                    pausa();
                    break;
                case "b":
                    System.out.println("\nIngrese numero de fila a sumar: ");
                    int numero_fila = sc.nextInt();
                    System.out.println("La suma de la fila " + numero_fila + " es: " + mi_matriz.sumarElementosFila(numero_fila));   
                    pausa();
                    break;
                case "c":
                    System.out.println("\nIngrese numero de columna a sumar: ");
                    int numero_columna = sc.nextInt();
                    System.out.println("La suma de la columna " + numero_columna + " es: " + mi_matriz.sumarElementosColumna(numero_columna));   
                    pausa();
                    break;
                case "d":
                    System.out.println("La suma de la diagonal principal es " + mi_matriz.sumarElementosDiagonalPrincipal());   
                    pausa();
                    break;
                case "e":
                    System.out.println("La suma de la diagonal inversa es " + mi_matriz.sumarElementosDiagonalInversa());   
                    pausa();
                    break;
                case "f":
                    System.out.println("La suma de toda la matriz es " + mi_matriz.sumarTodosLosElementos());   
                    pausa();
                    break;
                default:
                    System.out.println("fin");         
            }   
        }
    }
    
    public static void pausa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPresione cualquier tecla para continuar...");
        sc.nextLine();
    }
}
