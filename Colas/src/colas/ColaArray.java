package colas;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se guardan en la cola
 */
class ColaArray<E> {

    private final int TAMAÑO = 10;
    private E[] datos;
    private int primero;
    private int numElementos;

    public ColaArray() {
        datos = (E[]) (new Object[TAMAÑO]);
        primero = 0;
        numElementos = 0;
    }

    // Inserta un elemento en la cola
    public void insertar(E e) throws DesbordamientoSuperior {
        if (numElementos > TAMAÑO) {
            throw new DesbordamientoSuperior("Desbordamiento superior de la cola");
        }

        datos[(primero + numElementos) % TAMAÑO] = e;
        numElementos++;
    }

    //Devuelve el elemento más antiguo insertado
    public E primero() throws DesbordamientoInferior {
        if (numElementos <= 0) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }
        return datos[primero];
    }

    //Devuelve y elimina el  último elemento insertado
    public E quitarPrimero() throws DesbordamientoInferior {
        if (numElementos <= 0) {
            throw new DesbordamientoInferior("Desbordamiento inferior de la cola");
        }

        E aux = datos[primero];
        primero = (primero + 1) % TAMAÑO;
        numElementos--;
        return aux;
    }

    //Devuelve true si está vacía, si no false
    public boolean esVacia() {
        return (numElementos == 0);
    }

    //Elimina todos los elementos
    public void vaciar() {
        primero = 0;
        numElementos = 0;
    }

}
