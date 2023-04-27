import java.util.NoSuchElementException;


/**
 * <p> Interfaz para colas </p> <p>Esta clase contiene las
 * operaciones elementales que debe tener el TAD cola </p>
 * @author Adriana Sanchez Del Moral <adrisanchez@ciencias.unam.mx>
 * @version 1.0
 */
public interface Encolable<T> { 
    	
    /**
     * Agrega un elemento en el rabo de la Cola.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     * <code>null</code>.
     */
    public void queue(T elemento) throws IllegalArgumentException;

    /**
     * Elimina el elemento del inicio de la Cola y lo regresa.
     * @throws NoSuchElementException si la cola es vacía
     * @return el elemento en el inicio de la Cola.
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * Nos permite ver el elemento en el inicio de la Cola
     *
     * @return el elemento en un extremo de la estructura.
     */
    public T peek();


}
