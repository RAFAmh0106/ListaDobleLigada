package com.uthh.edd.unidad2.listas;

public class Nodo2 {
    private int dato;
    private Nodo2 siguiente;
    private Nodo2 anterior;

    // Crea un nodo doble con el valor indicado.
    public Nodo2(int dato){
        // Inicializa el dato y deja ambos enlaces vacíos.
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }

    // Devuelve el valor almacenado.
    public int getDato(){
        // Entrega el dato del nodo.
        return dato;
    }

    // Devuelve el siguiente nodo.
    public Nodo2 getSiguiente(){
        // Entrega el enlace al nodo siguiente.
        return siguiente;
    }

    // Devuelve el nodo anterior.
    public Nodo2 getAnterior(){
        // Entrega el enlace al nodo anterior.
        return anterior;
    }

    // Cambia el valor almacenado.
    public void setDato(int dato){
        // Reemplaza el dato actual.
        this.dato=dato;
    }

    // Establece el siguiente nodo.
    public void setSiguiente(Nodo2 siguiente){
        // Actualiza el enlace hacia adelante.
        this.siguiente=siguiente;
    }

    // Establece el nodo anterior.
    public void setAnterior(Nodo2 anterior){
        // Actualiza el enlace hacia atrás.
        this.anterior=anterior;
    }
}
