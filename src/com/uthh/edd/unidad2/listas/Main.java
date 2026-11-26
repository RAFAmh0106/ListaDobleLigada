package com.uthh.edd.unidad2.listas;

import java.util.Scanner;

/**
 * Programa principal con un menú para probar la lista enlazada.
 * La opción 7 prueba insertarOrdenado con valores que escribe el usuario.
 * La opción 8 lo prueba con valores fijos (incluye duplicado, menor y mayor).
 */
public class Main {

    /**
     * Imprime el menú de opciones.
     * Precondición: ninguna.
     * Complejidad: O(1).
     */
    private static void mostrarMenu() {
        // Presenta las operaciones disponibles y solicita una opción.
        System.out.println("\n===== MENÚ LISTA LIGADA =====");
        System.out.println("1. Insertar al inicio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Buscar un valor");
        System.out.println("4. Eliminar un valor");
        System.out.println("5. Mostrar la lista");
        System.out.println("6. Ver tamaño");
        System.out.println("7. Insertar ordenado (valores del usuario)");
        System.out.println("8. Prueba automática de insertarOrdenado");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    /**
     * Pide valores al usuario y los inserta con insertarOrdenado en una
     * lista nueva, mostrando la lista después de cada inserción.
     * Precondición: la lista nueva empieza vacía, por lo tanto está ordenada.
     * Complejidad: O(n^2) en el peor caso (n inserciones de O(n) cada una).
     */
    private static void insertarOrdenadoManual(Scanner teclado) {
        // Lee la cantidad y los valores, insertándolos en una lista ordenada nueva.
        System.out.println("\n===== INSERTAR ORDENADO =====");

        System.out.print("¿Cuántos valores deseas insertar? ");
        int cantidad = teclado.nextInt();

        // Lista nueva para hacer la prueba ordenada
        ListaEnlazada listaOrdenada = new ListaEnlazada();

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingresa el valor " + i + ": ");
            int valor = teclado.nextInt();

            listaOrdenada.insertarOrdenado(valor);

            System.out.println("Lista: " + listaOrdenada);
        }

        System.out.println("Tamaño final: " + listaOrdenada.getTamanio());
    }

    /**
     * Prueba insertarOrdenado con 8 valores fijos y desordenados.
     * Incluye un duplicado (30), un valor menor que todos (10)
     * y un valor mayor que todos (90) para ver los casos borde.
     * Precondición: ninguna (usa una lista nueva).
     * Complejidad: O(n^2) en el peor caso.
     */
    private static void pruebaAutomatica() {
        // Inserta una secuencia fija para comprobar casos comunes y duplicados.
        System.out.println("\n===== PRUEBA AUTOMÁTICA =====");

        ListaEnlazada lista = new ListaEnlazada();
        int[] valores = {50, 30, 70, 30, 10, 90, 60, 40};

        for (int valor : valores) {
            lista.insertarOrdenado(valor);
            System.out.println("Insertar " + valor + " -> " + lista);
        }

        System.out.println("Tamaño final: " + lista.getTamanio());
    }

    /**
     * Ciclo principal del menú.
     * Precondición: el usuario escribe números enteros.
     * Complejidad: depende de la opción elegida.
     */
    public static void main(String[] args) {

        // Mantiene el menú activo hasta que se elija la opción de salida.
        Scanner teclado = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {

                // Inserta un valor al inicio de la lista
                case 1:
                    System.out.print("Valor: ");
                    lista.insertarAlInicio(teclado.nextInt());
                    break;

                // Inserta un valor al final de la lista
                case 2:
                    System.out.print("Valor: ");
                    lista.insertarFinal(teclado.nextInt());
                    break;

                // Busca un valor y dice si está o no
                case 3:
                    System.out.print("Valor a buscar: ");
                    int buscado = teclado.nextInt();

                    System.out.println(
                            lista.buscar(buscado)
                                    ? "Sí está en la lista"
                                    : "No está en la lista"
                    );
                    break;

                // Elimina la primera aparición de un valor
                case 4:
                    System.out.print("Valor a eliminar: ");
                    int eliminado = teclado.nextInt();

                    System.out.println(
                            lista.eliminar(eliminado)
                                    ? "Eliminado"
                                    : "No encontrado"
                    );
                    break;

                // Muestra la lista completa
                case 5:
                    System.out.println(lista);
                    break;

                // Muestra cuántos nodos tiene la lista
                case 6:
                    System.out.println("Tamaño: " + lista.getTamanio());
                    break;

                // Prueba insertarOrdenado con valores del usuario
                case 7:
                    insertarOrdenadoManual(teclado);
                    break;

                // Prueba insertarOrdenado con valores fijos
                case 8:
                    pruebaAutomatica();
                    break;

                // Termina el programa
                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        teclado.close();
    }
}