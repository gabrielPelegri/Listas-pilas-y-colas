public class Nodo<E> {
    Nodo<E> siguiente;
    E dato;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;

    }
}