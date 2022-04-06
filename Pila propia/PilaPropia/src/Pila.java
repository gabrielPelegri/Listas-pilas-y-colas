public class Pila<E> { //los objetos se añaden al principio de la lista (1,2,3) los objetos más antiguos están en las últimas posiciones
    Lista<E> lista;

    public Pila() {
        lista = new Lista<>();
    }

    public void apilar(E e) {
        lista.insertarPrimero(e);
    }

    // elimina el último elemento insertado (más reciente)
    public void desapilar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento");
        } else {
            lista.Eliminar(Cima());
        }
    }

    public boolean esVacia() {
        return lista.estaVacia();
    }

    public void vaciar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Vacía");
        } else {
            lista.Vaciar();

        }

    }

    public E Cima() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento");
        } else {
            return lista.cabecera.siguiente.dato;
        }
    }

}