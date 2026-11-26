package com.uthh.edd.unidad2.listas;

public class Listadoble {

    private int tamanio;
    private Nodo cabeza;
    private Nodo cola;

    // Crea una lista doble vacía.
    public Listadoble(){
        // La cabeza, la cola y el tamaño representan una lista sin nodos.
        tamanio=0;
        cabeza=null;
        cola=null;

    }
    // Indica si la lista está vacía.
    public boolean estaVacia(){
        // Si no existe cabeza, no hay elementos enlazados.
        return cabeza == null;
    }

    // Devuelve la cantidad de elementos.
    public int getTamanio() {
        // Retorna el contador de nodos.
        return tamanio;
    }

    // Busca un valor en la lista.
    public boolean Buscar(int x){
        // Avanza desde la cabeza y compara cada nodo con el valor buscado.
        if(estaVacia())
            return false;
        Nodo aux=cabeza;
        while (aux!=null){
            if(aux.getDato()==x){
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;

    }

    // Cambia el valor almacenado en una posición.
    public void actualizar(int dato, int pos){
        // Obtiene el nodo validando la posición y modifica su dato.
        Nodo aux = obtenerNodo(pos);
        aux.setDato(dato);
    }

    // Inserta un elemento al inicio.
    public void insertarAlInicio(int dato){
        // Enlaza el nuevo nodo antes de la cabeza y actualiza ambos extremos.
        Nodo nuevo= new Nodo(dato);
        if (estaVacia()){
            cabeza=nuevo;
            cola=nuevo;
            tamanio++;
        }
        else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza=nuevo;
            tamanio++;
        }
    }

    // Devuelve el nodo de una posición, empezando en 1.
    public Nodo obtenerNodo(int pos){
        // Valida el rango y avanza desde la cabeza hasta la posición solicitada.
        if(pos<=0 || pos>tamanio){
            throw new IllegalArgumentException(
                    "Posicion invalida: " + pos + ". El rango valido es de 1 a " + tamanio
            );
        }
        Nodo aux=cabeza;
        for (int i=1; i<pos; i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }

    @Override
    // Devuelve la lista en formato de texto.
    public String toString(){
        // Recorre los enlaces siguientes y representa cada nodo entre flechas.
        String res="null <-";
        Nodo aux=cabeza;
        while(aux !=null){
            res=res+"<-["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res=res+"null";
        return res;
    }

    // Elimina y devuelve el primer elemento.
    public int eliminarAlInicio(){
        // Guarda el dato, mueve la cabeza y corrige enlaces o limpia ambos extremos.
        if (estaVacia()){
            throw  new IllegalStateException("la lsita esta vacia");
        }
        int dato= cabeza.getDato();
        if (cabeza==cola){
            cabeza=null;
            cola= null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    // Inserta un valor en una posición, empezando en 1.
    public boolean insertarEnPosicion(int pos, int dato) {
        // Valida el rango y conecta el nuevo nodo con sus vecinos.
        if (pos < 1 || pos > tamanio + 1) {
            System.out.println("Posicion fuera de rango.");
            return false;
        }

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        }
        else if (pos == 1) {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        // 4. Insertar al final
        else if (pos == tamanio + 1) {
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        else {
            Nodo actual = cabeza;
            for (int i = 1; i < pos; i++) {
                actual = actual.getSiguiente();
            }
            Nodo previo = actual.getAnterior();

            nuevo.setAnterior(previo);
            nuevo.setSiguiente(actual);
            previo.setSiguiente(nuevo);
            actual.setAnterior(nuevo);
        }

        tamanio++;
        return true;
    }

    // Elimina la primera aparición de un valor.
    public boolean eliminarPorValor(int dato){
        // Busca el nodo y conecta entre sí sus vecinos antes de reducir el tamaño.
        if(estaVacia())
            return false;
        Nodo aux=cabeza;
        while (aux!=null){  // mientras no sea diferente de nulo va a seguir
            if(aux.getDato()==dato){  // en el avance se busca el dato y si es igual lo elimina
                if (aux== cabeza && aux == cola) {
                    cabeza = null;
                    cola = null;
                }
                else if(aux==cabeza){
                    cabeza = aux.getSiguiente();
                    cabeza.setAnterior(null);
                }
                else if(aux == cola){
                    cola= aux.getAnterior();
                    cola.setSiguiente(null);

                }
                else {//para saltar el dato
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());

                }

                tamanio--;
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;

    }

    // Elimina y devuelve el valor de una posición, empezando en 1.
    public int eliminarEnPosicion(int pos){
        // Localiza el nodo y ajusta enlaces de acuerdo con su ubicación.
        if (pos < 1 || pos > tamanio){
            throw new IllegalStateException("posicion invalida " + pos);
        }

        //recorrer y llegar al nodo a eliminar
        Nodo aux=cabeza;
        for (int i=1; i<pos; i++){
            aux=aux.getSiguiente();
        }
        int dato = aux.getDato();
        if (aux == cabeza && aux == cola) {
            cabeza = null;
            cola = null;
        }
        else if (aux == cabeza) {
            cabeza = aux.getSiguiente();
            cabeza.setAnterior(null);
        }
        else if (aux == cola) {
            cola = aux.getAnterior();
            cola.setSiguiente(null);
        }
        else {
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }
        tamanio--;
        return dato;
    }

    // Elimina el último elemento.
    public boolean eliminarUltimo() {
        // Retrocede la cola y actualiza el final de la lista.
        if (estaVacia()) {
            return  false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.getSiguiente().setAnterior(null);
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }

    // Inserta un valor manteniendo el orden ascendente.
    public boolean insertarOrdenado(int dato){
        // Compara con los extremos y, si hace falta, busca el lugar entre nodos.
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()){
            cabeza= nuevo;
            cola= nuevo;
        }
        else if (dato <= cabeza.getDato()){
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza=nuevo;
        } else if (dato >=cola.getDato()) {
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);
            cola=nuevo;
        }
        else {
            Nodo actual = cabeza;
            while (actual.getDato() < dato){
                actual= actual.getSiguiente();
            }
            Nodo previo = actual.getAnterior();

            nuevo.setAnterior(previo);
            nuevo.setSiguiente(actual);
            previo.setSiguiente(nuevo);
            actual.setAnterior(nuevo);
        }
        tamanio++;
        return true;
    }

    // Imprime la lista desde la cola hasta la cabeza
    public String mostrarReversa() {
        String res = "null <- ";
        Nodo aux = cola;
        while (aux != null) {
            res = res + "[" + aux.getDato() + "] ";
            aux = aux.getAnterior();
        }
        return res + "-> null";
    }
}