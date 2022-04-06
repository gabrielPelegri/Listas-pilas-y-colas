import javax.security.auth.DestroyFailedException;

//los objetos se añaden al final de la lista (9,8,7) Los objetos más antiguos están en las primeras posiciones
public class Cola<E> {
    private Lista<E> lista;

    public Cola() {
        lista = new Lista<>();
    }

    public void insertar(E e) {
        lista.insertarUltimo(e);
    }

    public E Primero() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento");
        } else {
            return lista.cabecera.siguiente.dato;
        }
    }

    public void quitarPrimero() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Desbordamiento");
        } else {
            lista.Eliminar(Primero());

        }
    }

    public boolean esVacia() {
        return lista.estaVacia();
    }

    public void Vaciar() throws DesbordamientoInferior {
        if (lista.estaVacia()) {
            throw new DesbordamientoInferior("Ha habido un desbordamiento");
        } else {
            lista.Vaciar();
        }
    }
}