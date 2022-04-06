package pilas;

/**
 *
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se usan en la Pila.
 */
class Pila<E> {

    private ListaSimple<E> lista;

    public Pila() {
        lista = new ListaSimple();
    }

    // Inserta un elemento en la pila
    public void apilar(E e) throws DesbordamientoSuperior {
        lista.insertarPrimero(e);
    }

    // Elimina el último elemento insertado
    public void desapilar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        lista.eliminar(cima());
    }

    //Devuelve el último elemento insertado
    public E cima() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        return lista.cabecera.siguiente.dato;
    }

    //Devuelve y elimina el  último elemento insertado
    public E cimaYDesapilar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }
        E aux = cima();
        lista.eliminar(cima());
        return aux;
    }

    //Devuelve true si vacía, sino false
    public boolean esVacia() {
        return lista.estaVacia();
    }

    //Elimna todos los elementos
    public void vaciar() {
        lista.vaciar();
    }

}
