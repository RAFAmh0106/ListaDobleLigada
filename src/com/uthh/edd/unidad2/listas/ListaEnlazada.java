package com.uthh.edd.unidad2.listas;

public class ListaEnlazada {
    private Nodo cabeza;
    private int tamanio;

    // Crea una lista vacía.
    public ListaEnlazada(){
        // Inicializa la cabeza y el tamaño sin elementos.
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Indica si la lista no contiene elementos.
    public boolean estaVacia(){
        // Una cabeza nula significa que no hay nodos.
        return cabeza== null;
    }

    // Devuelve la cantidad de elementos.
    public int getTamanio(){
        // Retorna el contador actualizado en las operaciones.
        return tamanio;
    }

    // Inserta un elemento al inicio.
    public void insertarAlInicio(int dato){
        // El nuevo nodo apunta a la cabeza actual y luego pasa a ser la cabeza.
        Nodo nuevo= new Nodo(dato);
        nuevo.setSiguiente(cabeza);
        cabeza=nuevo;
        tamanio++;
    }

    // Inserta un elemento al final.
    public void insertarFinal(int dato){
        // Si hay nodos, recorre la lista y enlaza el nuevo al último.
        if (estaVacia()){
            insertarAlInicio(dato);
            return;
        }
        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;

        //se avanza hasta el último nodo
        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
        tamanio++;
    }

    // Busca un valor en la lista.
    public boolean buscar(int dato){
        // Recorre los nodos hasta encontrar el dato o llegar al final.
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.getDato() == dato){
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Elimina la primera aparición del valor indicado.
    public boolean eliminar(int dato){
        // Reenlaza los nodos alrededor del valor encontrado.
        if (estaVacia()){
            return false;
        }

        //el valor esta en la cabeza, la cabeza pasa al siguiente nodo
        if (cabeza.getDato() == dato){
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        Nodo anterior = cabeza;
        Nodo actual = cabeza.getSiguiente();

        while (actual != null){
            if (actual.getDato() == dato){
                anterior.setSiguiente(actual.getSiguiente());
                tamanio--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Inserta un valor manteniendo el orden ascendente.
    public void insertarOrdenado(int dato){
        // Busca la posición donde el nuevo dato conserva el orden.
        // Caso a: se resuelve la inserción cuando la lista está vacía.
        if (estaVacia()){
            insertarAlInicio(dato);
            return;
        }

        // Caso b: se resuelve la inserción cuando el dato es menor o igual que la cabeza.
        if (dato<= cabeza.getDato()){
            insertarAlInicio(dato);
            return;
        }

        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;

        /*
         * Se recorre mirando el siguiente nodo de actual
         * y no actual, porque necesitamos detenernos en el
         * nodo anterior al lugar donde se insertará el nuevo nodo.
         */
        while (actual.getSiguiente() != null
                && actual.getSiguiente().getDato() < dato){
            actual = actual.getSiguiente();
        }

        // Caso c: se resuelve la inserción cuando el dato es mayor que todos y va al final.
        if (actual.getSiguiente()== null){
            actual.setSiguiente(nuevo);
        }

        // Caso d: se resuelve la inserción cuando el dato va en medio de dos nodos.
        else {
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
        tamanio++;
    }

    @Override
    // Devuelve los elementos como texto.
    public String toString(){
        // Recorre la lista y concatena los valores separados por flechas.
        if (estaVacia()){
            return "(Lista vacia)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Nodo actual = cabeza;
        while (actual != null){
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null){
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        sb.append(")");
        return sb.toString();
    }

    // Imprime la lista en pantalla.
    public void mostrar(){
        // Usa la representación generada por toString.
        System.out.println(this);
    }

    // Ejecuta una demostración de inserción ordenada.
    public static void main(String[] args){
        // Inserta varios valores y muestra cómo queda la lista en cada paso.
        ListaEnlazada lista = new ListaEnlazada();

        int[] datos = {50,30,70,20,40,60,80};
        for (int valor: datos){
            lista.insertarOrdenado(valor);
            System.out.println("Insertar" + valor + "-> " + lista);
        }
        System.out.println("Tamaño: " + lista.getTamanio());
    }
}
