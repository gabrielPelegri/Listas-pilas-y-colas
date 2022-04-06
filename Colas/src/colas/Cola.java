package colas;

/**
 * 
 * @author Jesús Sánchez Allende
 * @param <E> La clase de objetos que se guardan en la cola
 */
class Cola<E> {
    private ListaSimple<E> lista;
    
    public Cola(){
        lista = new ListaSimple();   
    }
    
    // Inserta un elemento en la cola	
    public void insertar (E e) {
        lista.insertarUltimo(e);
    }
            
    //Devuelve el elemento más antiguo insertado
    public E primero() throws Exception {
        if (lista.estaVacia())
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");
        return lista.cabecera.siguiente.dato;
    }
    
    //Devuelve y elimina el elemento insertado m�s antiguo
    public void quitarPrimero()throws Exception {
        if (lista.estaVacia())
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");

        lista.eliminar(primero());
    }
    
    //Devuelve y elimina el elemento insertado más antiguo
    public E primeroYQuitar()throws Exception {
        if (lista.estaVacia())
            throw new DesbordamientoInferior("Desbordamiento inferior de la pila");

        E aux=primero();
        quitarPrimero();
        return aux;
    }

    //Devuelve true si vacía, si no false
    public boolean esVacia (){
            return lista.estaVacia();
    }
    
    //Elimina todos los elementos
    public void vaciar(){
            lista.vaciar();
    }
    
 }