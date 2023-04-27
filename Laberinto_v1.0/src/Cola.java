import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Clase concreta para modelar la estructura de datos Cola
 * </p>
 * <p>
 * Esta clase implementa una Cola genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 * @param <T> Tipo que tienen los objetos que guarda esta cola.
 */
public class Cola<T> extends LinealAdapter<T> implements Encolable<T> {

    private class IteradorCola implements Iterator<T> {
        private Nodo siguiente;

        private IteradorCola() {
            siguiente = cabeza;
            // Aqui va tu codigo
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            return siguiente.siguiente != null;
            // Aqui va tu codigo
        }

        /* Nos da el elemento siguiente. */
        @Override
        public T next() {
            return (T) peek();
            // aqui va tu codigo
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

    }

    /**
     * Constructor por omisión de la clase.
     */
    public Cola() {
        // Aqui no hay que hacer nada,
        // ya que los valores por default nos sirven al crear un objeto.
    }

    /**
     * Constructor que recibe un arreglo de elementos de tipo <code>T</code>.
     * Crea una cola con los elementos del arreglo.
     * 
     * @param elementos El arreglo que se recibe como parámetro.
     */
    public Cola(T[] elementos) {
        for (T e : elementos) {
            queue(e);
        }
        // Aqui va tu codigo
    }

    /**
     * Constructor que recibe una colección de tipo {@link Coleccionable}
     * de elementos de tipo <code>T</code> y los agrega a la nueva cola.
     * 
     * @param elementos La colección de elementos a agregar.
     */
    public Cola(Coleccionable<T> elementos) {
        for (T e : elementos) {
            queue(e);
        }
        // Aqui va tu codigo
    }

    /**
     * Agrega un elemento en el rabo de la Cola.
     * 
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void queue(T elemento) throws IllegalArgumentException {

        if (elemento != null) {
            Nodo nodo = new Nodo(elemento);

            if (!esVacia())
                cola.siguiente = nodo;
            else
                cabeza = nodo;
            cola = nodo;
            longitud++;

        } else {
            throw new IllegalArgumentException();
        }
        // aqui va tu codigo
    }

    /**
     * Elimina el elemento del inicio de la Cola y lo regresa.
     * 
     * @throws NoSuchElementException si la cola es vacía
     */
    public T dequeue() throws NoSuchElementException {
        return (T) eliminarInicio();
        // aqui va tu codigo
    }

    /**
     * Nos permite ver el elemento en el inicio de la Cola
     *
     * @return el elemento en un extremo de la estructura.
     */
    public T peek() {
        return (T) ver().elemento;
        // Aqui va tu codigo
    }

    @Override
    public String toString() {
        return super.toString();
        // Aqui va tu codigo
    }

}
