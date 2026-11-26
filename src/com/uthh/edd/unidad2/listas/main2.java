package com.uthh.edd.unidad2.listas;

public class Main2 {

    public static void main(String[] args) {

        Listadoble lista = new Listadoble();

        System.out.println(" PRUEBA 1: insertarEnPosicion");
        System.out.println("Insertar 10 en pos 1 (lista vacia): " + lista.insertarEnPosicion(1, 10));
        System.out.println("Insertar 30 en pos 2 (al final): " + lista.insertarEnPosicion(2, 30));
        System.out.println("Insertar 5 en pos 1 (al inicio): " + lista.insertarEnPosicion(1, 5));
        System.out.println("Insertar 20 en pos 3 (en medio): " + lista.insertarEnPosicion(3, 20));
        System.out.println("Adelante: " + lista);
        System.out.println("Al reves: " + lista.mostrarReversa());
        System.out.println("Tamanio: " + lista.getTamanio());
        System.out.println("Insertar en pos 9 (invalida): " + lista.insertarEnPosicion(9, 99));
        System.out.println("Insertar en pos 0 (invalida): " + lista.insertarEnPosicion(0, 99));

        System.out.println();
        System.out.println(" PRUEBA 2: eliminarPorValor");
        System.out.println("Eliminar 20 (medio): " + lista.eliminarPorValor(20));
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar 5 (inicio): " + lista.eliminarPorValor(5));
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar 30 (final): " + lista.eliminarPorValor(30));
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar 99 (no existe): " + lista.eliminarPorValor(99));
        System.out.println("Tamanio: " + lista.getTamanio());

        System.out.println();
        System.out.println("PRUEBA 3: eliminarEnPosicion");
        lista.insertarEnPosicion(2, 20);
        lista.insertarEnPosicion(3, 30);
        lista.insertarEnPosicion(4, 40);
        lista.insertarEnPosicion(5, 50);
        System.out.println("Lista inicial: " + lista);
        System.out.println("Eliminar pos 3 (medio): " + lista.eliminarEnPosicion(3));
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar pos 1 (inicio): " + lista.eliminarEnPosicion(1));
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar pos 3 (final): " + lista.eliminarEnPosicion(3));
        System.out.println("Adelante: " + lista);
        System.out.println("Al reves: " + lista.mostrarReversa());
        try {
            lista.eliminarEnPosicion(10);
        } catch (IllegalStateException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        System.out.println();
        System.out.println(" PRUEBA 4: eliminarUltimo ");
        System.out.println("Lista actual: " + lista);
        System.out.println("Eliminar ultimo: " + lista.eliminarUltimo());
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar ultimo (un solo elemento): " + lista.eliminarUltimo());
        System.out.println("Adelante: " + lista);
        System.out.println("Eliminar ultimo (lista vacia): " + lista.eliminarUltimo());
        System.out.println("Esta vacia: " + lista.estaVacia());

        System.out.println();
        System.out.println(" PRUEBA 5: insertarOrdenado ");
        lista.insertarOrdenado(30);
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(50);
        lista.insertarOrdenado(20);
        lista.insertarOrdenado(40);
        lista.insertarOrdenado(5);
        lista.insertarOrdenado(60);
        System.out.println("Adelante: " + lista);
        System.out.println("Al reves: " + lista.mostrarReversa());
        System.out.println("Tamanio: " + lista.getTamanio());

        System.out.println();
        System.out.println("PRUEBA 6");
        System.out.println("Buscar 30: " + lista.Buscar(30));
        System.out.println("Buscar 99: " + lista.Buscar(99));
        lista.actualizar(99, 2);
        System.out.println("Actualizar pos 2 con 99: " + lista);
        try {
            lista.actualizar(1, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
        lista.insertarAlInicio(1);
        System.out.println("Insertar 1 al inicio: " + lista);
        System.out.println("Eliminar al inicio: " + lista.eliminarAlInicio());
        System.out.println("Adelante: " + lista);
        System.out.println("Al reves: " + lista.mostrarReversa());
        System.out.println("Tamanio final: " + lista.getTamanio());
    }
}