package pilas;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se guarda en la lista
 */
public class ListaSimple<E> {
    NodoSimple<E> cabecera;

    public ListaSimple() {
        // la cabecera es un nodo que no se utiliza
        cabecera = new NodoSimple(null);
    }

    public boolean estaVacia() {
        return cabecera.siguiente == null;
    }

    public void insertarPrimero(E n) {
        // Creo e inicializo un nuevo nodo
        NodoSimple<E> aux = new NodoSimple(n);
        // Añado al principio
        aux.siguiente = cabecera.siguiente;
        cabecera.siguiente = aux;
    }

    public void insertarUltimo(E n) {
        // Creo e inicializo un nuevo nodo
        NodoSimple<E> aux = new NodoSimple(n);

        // Busco el último
        NodoSimple<E> ultimo = cabecera;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }

        // Lo enlazo
        ultimo.siguiente = aux;
    }

    public void insertarOrdenado(E n) {
        // Creo e inicializo un nuevo nodo
        NodoSimple<E> aux = new NodoSimple(n);

        // Busco el Anterior a donde debe ir insertado
        NodoSimple<E> anterior = cabecera;
        while (anterior.siguiente != null &&
                ((Comparable) anterior.siguiente.dato).compareTo(aux.dato) < 0) {
            anterior = anterior.siguiente;
        }

        // Lo enlazo
        aux.siguiente = anterior.siguiente;
        anterior.siguiente = aux;
    }

    public int buscar(E n) {
        // Referencia para localizar el nodo buscado.
        NodoSimple<E> aux = cabecera.siguiente;

        int pos = 0;
        while (aux != null) {
            if (aux.dato.equals(n))
                return pos;
            else {
                aux = aux.siguiente;
                pos++;
            }
        }
        return -1;
    }

    public boolean eliminar(E n) {
        // Referencia para buscar el nodo. Empiezo por la cabecera.
        NodoSimple<E> anterior = cabecera;

        // Localizo el nodo anterior al que se quiere eliminar
        while (anterior.siguiente != null &&
                !anterior.siguiente.dato.equals(n)) {
            anterior = anterior.siguiente;
        }

        // Le quito el enlace para que "salte" el que se elimina
        if (anterior.siguiente != null) {
            anterior.siguiente = anterior.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public void vaciar() {
        cabecera.siguiente = null;
    }

    public void imprimir() {
        NodoSimple<E> aux;
        aux = cabecera.siguiente;

        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public static void main(String[] args) {

        // ListaSimple<Integer> miLista = new ListaSimple();
        // int[] numeros = new int[]{3,4,1,7,2};

        ListaSimple<String> miLista = new ListaSimple();
        String[] numeros = { "uno", "dos", "tres", "cuatro", "otro" };

        for (int i = 0; i < 5; i++) {
            miLista.insertarOrdenado(numeros[i]);
        }
        miLista.imprimir();
        System.out.println("hecho");

        // miLista.eliminar(3);
        // miLista.eliminar(1);
        // miLista.eliminar(2);
        // miLista.imprimir();
        // System.out.println(miLista.buscar(7));
    }

}
