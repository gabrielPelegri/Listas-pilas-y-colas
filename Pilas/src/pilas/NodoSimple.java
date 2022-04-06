package pilas;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de dato que guarda el Nodo
 */
public class NodoSimple<E>{
    public E dato;
    public NodoSimple<E> siguiente;

    public NodoSimple(E info){
        dato = info;
        siguiente = null;
    }
}
