/*
UTN-FRMArreglos Multidimensionales.EJERCICIO5Codifiquela siguiente matriz de 2 dimensiones, que se corresponde a una máquinaexpendedora de 
golosinas donde la columna 1 es la golosina, la columna 2 el precio y la columna 3 la cantidad(stock)actual de golosinas
Tendremos un pequeño menú con las siguientes opciones:
a.Pedir  golosina:  pedirá  la  posición  de  la  golosina 
que  quiera.  Esta  máquina tiene  golosinas  en  cada  posición,  identificados  por  su  fila  y  columna,  que será  lo  que  introduzca 
el  usuario  al  pedir  una  golosina,  porejemplo  si  el usuario teclea 2significa que está pidiendo la golosinaque está en la fila 2. 
Al  seleccionar  una  golosina  debe disminuir  la  cantidad disponible  de  la golosina.En  caso  de  agotar  el  stock  de  la  golosina 
deberáinformar  de  la situaciónal cliente y solicitarle que seleccione otra golosina.

b.Mostrar  golosinas:  mostrara  todas  lasgolosinas con la  cantidadactual disponible.

c.Rellenar  golosinas:  esta  es  una  función  exclusiva  de  un  técnico  por  lo  quepara   su ejecuciónnos   
pedirá   una   contraseña,   si   el   usuario   escribe “AdminXYZ”nos autorizara ypedirá la posición de la golosina y la cantidada recargar.
La cantidad ingresada se sumara a la cantidad actual existente.

d.Apagar  maquina:  sale  del  programa,  antes  de  salir  mostrara  las  ventas
totales  durante  la  ejecución  del  programa.Es  decir  la  suma  de  todos  los preciosde las golosinas seleccionadasdesdeel inicio del programa.
 */
package com.mycompany.tp_arreglos_multidimensionales;
import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class ej_5 {
    public static void main(String[] args) {
        
        maquinaExpendedora miMaquina = new maquinaExpendedora();
        
        
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        while(opcion.compareTo("d") != 0){
            
            System.out.flush();
            imprimirMenu();
            System.out.println("\nIngrese la opcion a elegir: ");
            opcion = sc.nextLine();
            switch (opcion){
                case "a":
                    String producto = miMaquina.pedirGolosina();
                    System.out.println("Salio de la maquina: " + producto);
                    pausa();
                    break;
                case "b":
                    miMaquina.imprimirInventario();
                    pausa();
                    break;
                case "c":
                    miMaquina.agregarStock();
                    pausa();
                    break;             
                case "d":
                    System.out.println("Las ganancias suman un total de : " + Integer.toString(miMaquina.apagarMaquina()) + " $" );
                    pausa();
                    System.out.println("Maquina apagada.");
                    break; 
                default:
                    System.out.println("\nIngresaste una opcion no valida...");
                    pausa();
            }   
        }
        
    }
    
    public static void imprimirMenu(){
        System.out.println("a)Pedir golosina");
        System.out.println("b)Ver contenido maquina expendedora");
        System.out.println("c)Rellenar maquina expendedora");
        System.out.println("d)Apagar maquina");
    }
    
    public static void pausa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPresione cualquier tecla para continuar...");
        sc.nextLine();
    }
}
