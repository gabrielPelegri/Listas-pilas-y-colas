import javax.print.attribute.standard.Sides;

public class Lista<E> {
    Nodo<E> cabecera;

    public Lista() {
        cabecera = new Nodo(null);
    }

    public boolean estaVacia() {
        return cabecera.siguiente == null;
    }

    public void insertarPrimero(E n) {
        Nodo<E> aux = new Nodo(n);
        aux.siguiente = cabecera.siguiente;
        cabecera.siguiente = aux;
    }

    public void insertarPrimeroSinDuplicado(E n) {
        Nodo<E> aux = cabecera;
        Nodo<E> insertar = new Nodo<E>(n);
        while (aux != null && !aux.dato.equals(n)) {
            aux = aux.siguiente;
        }
        if (aux != null) {
            System.out.println("el valor ya se encuentra en la lista");
        } else {
            insertar.siguiente = cabecera.siguiente;
            cabecera.siguiente = insertar;
        }

    }

    public void insertarUltimoSinDuplicados(E e) {
        Nodo<E> aux = cabecera;
        Nodo<E> insertar = new Nodo<E>(e);
        while (aux != null && !aux.dato.equals(e)) {
            aux = aux.siguiente;
        }
        if (aux != null) {
            System.out.println("el valor ya se encuentra en la lista");
        } else {
            Nodo<E> ultimo = cabecera.siguiente;
            while (ultimo.siguiente != null) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = insertar;
        }

    }

    public void insertarUltimo(E e) {
        Nodo<E> ultimo = cabecera.siguiente;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }
        Nodo<E> aux = new Nodo<E>(e);
        ultimo.siguiente = aux;
    }

    public int buscar(E e) {
        Nodo<E> aux = cabecera.siguiente;
        int posicion = 0;
        while (aux != null) {
            if (aux.dato.equals(e)) {
                return posicion;
            } else {
                aux = aux.siguiente;
                posicion++;
            }

        }
        return -1;
    }

    public boolean Eliminar(E e) {
        Nodo<E> anterior = cabecera;
        while (anterior.siguiente != null && !anterior.siguiente.dato.equals(e)) {
            anterior = anterior.siguiente;
        }
        if (anterior.siguiente != null) {
            anterior.siguiente = anterior.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public void Vaciar() {
        cabecera.siguiente = null;
    }

    public void Imprimir() {
        Nodo<E> aux = cabecera.siguiente;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
