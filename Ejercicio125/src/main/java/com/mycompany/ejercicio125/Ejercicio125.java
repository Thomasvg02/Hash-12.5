/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio125;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author valen
 */
//Constructor dela tabla hash y el promedio
public class Ejercicio125 {

    int[] arreglo;
    int tamaño;
    float cantExploraciones = 0;
    float promedio = 0;

    public Ejercicio125(int tam) {
        tamaño = tam;
        arreglo = new int[tam];
        Arrays.fill(arreglo, -1);

    }

    //Tabla Hash
    public void funcionHash(int[] cadenaArreglo, int[] arreglo) {
        int i;
        float[] exploraciones = new float[cadenaArreglo.length];
        for (i = 0; i < cadenaArreglo.length; i++) {
            int elemento = cadenaArreglo[i];
            int indiceArreglo = elemento % (tamaño);
            //colisiones
            exploraciones[i] = 1;
            while (arreglo[indiceArreglo] != -1) {
                indiceArreglo++;
                exploraciones[i]++;
                indiceArreglo %= tamaño;
            }
            arreglo[indiceArreglo] = elemento;
        }
        //Metodo para calcular exploraciones
        for (i = 0; i < cadenaArreglo.length; i++) {
            cantExploraciones += exploraciones[i];
        }
        promedio = cantExploraciones / cadenaArreglo.length;
    }

    //Metodo para mostrar tabla
    public void mostrar() {
        int incremento = 0, i, j;
        for (i = 0; i < 1; i++) {
            incremento += (tamaño);
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println(" ");
            for (j = incremento - (tamaño); j < incremento; j++) {
                System.out.format("| %3s" + "", j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }

            System.out.println(" ");

            for (j = incremento - (tamaño); j < incremento; j++) {
                if (arreglo[j] == -1) {
                    System.out.print("|   ");
                } else {
                    System.out.print(String.format("| %3s" + " ", arreglo[j]));
                }
            }

            System.out.println("|");
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println(" ");

        }
        System.out.println("El numero medio de posiciones exploradas es de " + promedio +" posiciones por elemento EN PROMEDIO");
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Elija el factor de carga (desde 0,1 a 0,9)");
        double factordeCarga= scanner.nextDouble();
        double resultado= factordeCarga*1000.0;
        int cantidadElementos = (int)resultado; //Elemento a cambiar si quiero un distinto factor de carga (100 equivale a un factor de carga de 0.1)
        int elementos[] = new int[cantidadElementos];
        for (int i = 0; i < cantidadElementos; i++) {
            elementos[i] = (int) (Math.random() * 1000); //Se eligen valores randoms de 1000 enteros
        }
        Ejercicio125 hash = new Ejercicio125(1000); //Tamaño de la tabla
        hash.funcionHash(elementos, hash.arreglo);
        hash.mostrar();
    }
}
