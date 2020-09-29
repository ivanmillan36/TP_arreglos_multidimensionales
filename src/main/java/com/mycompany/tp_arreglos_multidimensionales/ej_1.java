/*
EJERCICIO1Crea  un  programa  que  pida  por  pantalla  cuatro  países  y  a  continuación  tres ciudades   de   cada   uno   de   estos   países.
Los   nombres   de   ciudades   deben almacenarse  en  un  array  multidimensional  cuyo  primer  índice  sea  el
número asignado a cada país y el segundo índice el número asignado a cada ciudad.Es decir el array deberá tener un tamaño de
4x4Ejemplo de resultados que debe mostrar el programa:País: ArgentinaCiudades:Buenos Aires
CordobaLa PlataPaís: EspañaCiudades:MadridLugoSevillaPaís: FranciaCiudades:ParisNizaLyonPaís: ItaliaCiudades:RomaNapolesSicilia
 */
package com.mycompany.tp_arreglos_multidimensionales;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class ej_1 {
    public static void main(String[] args) {
        String matriz[][] = new String[4][4];
        
        rellenarMarizPaises(matriz);
        imprimirMatriz(matriz);
        
    }
    
    public static void rellenarMarizPaises(String matriz[][]){
        
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<matriz.length; i++){
            System.out.println("Ingrese un pais para la fila " + i + " de la matriz");
            matriz[i][0] = sc.nextLine();
        }
        
        for(int i=0; i<matriz.length; i++){
            for(int j=1; j<matriz[i].length; j++){
                System.out.println("Ingrese una ciudad para el pais " + matriz[i][0]);
                matriz[i][j] = sc.nextLine();
            }
        }
    }
    
    public static void imprimirMatriz(String matriz[][]) {
        
        for (String[] fila : matriz) {
            for (String dato : fila) {
                System.out.print(dato + " ");
            }
            System.out.println("");
        }
    }
    
}
