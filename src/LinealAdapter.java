
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

/**
 * <p>
 * Clase abstracta para modelar la estructura de datos pila y cola
 * </p>
 * <p>
 * Esta clase implementa una Cola genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 * @param <T> Tipo que tienen los objetos que guarda esta cola.
 */
public abstract class LinealAdapter<T> extends Lista<T> {

    @Override
    public void eliminar(T elemento) {
        throw new UnsupportedOperationException("Operacion no valida");
    }

    /**
     * Método para eliminar el elemento del inicio de la estructura.
     * 
     * @return Elemento que se ha borrado
     */
    protected T eliminarInicio() throws NoSuchElementException {
        if (esVacia())
            throw new NoSuchElementException("así no mijo, de verdad que no");

        T eliminarInicio = (T) cabeza.elemento;
        cabeza = cabeza.siguiente;
        longitud--;

        return eliminarInicio;
        // aqui va tu codigo
    }
    
    protected Nodo ver() throws NoSuchElementException {
        return cabeza;
        // Aqui va tu codigo
    }

}
