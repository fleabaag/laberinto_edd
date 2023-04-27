import java.util.NoSuchElementException;

/**
 * <p> Interfaz para pilas </p> <p>Esta clase contiene las
 * operaciones elementales que debe tener el TAD pila </p>
 * @author Adriana Sanchez Del Moral <adrisanchez@ciencias.unam.mx>
 * @version 1.0
 */
public interface Apilable<T> { 
    	
    /**
    * Agrega un elemento al tope de la pila.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     * <code>null</code>.
     **/ 
    public void push(T elemento) throws IllegalArgumentException;

    /**
     * Metodo para eliminar el elemento del tope de la pila y lo regresa.
     * @throws NoSuchElementException si la pila es vacía.
     * @return el elemento en el tope de la pila.
     */
    public T pop() throws NoSuchElementException;

    /**
     * Nos permite ver el elemento en el tope de la pila
     *
     * @return el elemento en un extremo de la estructura.
     */
    public T top();


}
