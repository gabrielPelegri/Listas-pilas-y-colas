package pilas;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se usan en la Pila.
 * Implementacion con un array
 */
class PilaArray<E> {

    private E[] array;
    private int contador;

    public PilaArray() {
        array = (E[]) (new Object[10]);
        contador = 0;
    }

    // Inserta un elemento en la pila
    public void apilar(E e) throws DesbordamientoSuperior {
        if (contador >= array.length) {
            throw new DesbordamientoSuperior("Desbordamiento superior de la pila");
        }

        array[contador++] = e;
    }

    // Elimina el último elemento insertado
    public void desapilar() throws DesbordamientoInferior {
        if (contador == 0) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }

        contador--;
    }

    //Devuelve el último elemento insertado
    public E cima() throws DesbordamientoInferior {
        if (contador == 0) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }

        return array[contador - 1];
    }

    //Devuelve y elimina el  último elemento insertado
    public E cimaYDesapilar() throws DesbordamientoInferior {
        if (contador == 0) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        }

        return array[--contador];
    }

    //Devuelve true si vacía, si no false
    public boolean esVacia() {
        return contador == 0;
    }

    //Elimina todos los elementos
    public void vaciar() {
        contador = 0;

    }
}
