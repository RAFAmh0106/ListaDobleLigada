package com.uthh.edd.unidad2.listas;

public class Nodo {
    private int dato;   //valor almacenado en el nodo
    private Nodo siguiente;
    private Nodo anterior;

    // Crea un nodo con el valor indicado.
    public Nodo(int dato){
        // Un nodo nuevo empieza sin enlaces.
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Devuelve el valor del nodo.
    public int getDato(){
        // Entrega el dato almacenado.
        return dato;
    }

    // Cambia el valor del nodo.
    public void setDato(int dato){
        // Reemplaza el dato actual.
        this.dato = dato;
    }

    // Devuelve el siguiente nodo.
    public Nodo getSiguiente(){
        // Entrega el enlace al nodo siguiente.
        return siguiente;
    }

    // Establece el siguiente nodo.
    public void setSiguiente(Nodo siguiente){
        // Actualiza el enlace hacia adelante.
        this.siguiente = siguiente;
    }

    // Devuelve el nodo anterior.
    public Nodo getAnterior(){
        // Entrega el enlace al nodo anterior.
        return anterior;
    }

    // Establece el nodo anterior.
    public void setAnterior(Nodo anterior){
        // Actualiza el enlace hacia atrás.
        this.anterior = anterior;
    }
}
