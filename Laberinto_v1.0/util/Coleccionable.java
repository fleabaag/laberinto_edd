
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * <p>Interface para colecciones, con operaciones para agregar y eliminar
 * elementos, y consultar si un elemento está contenido, así como para obtener
 * el número de elementos en la colección. Además, Las colecciones son
 * iterables.</p>
 *
 * <p>Las colecciones no aceptan a <code>null</code> como elemento; el
 * comportamiento de las clases que implementen esta interfaz no está definido
 * si <code>null</code> es pasado como parámetro a ninguno de sus métodos.</p>
 * @param <T> Tipo genérico de los elementos que guarda.
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.1
 */
public interface Coleccionable<T> extends Iterable<T> {

    /**
     * Agrega un elemento a la colección.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregar(T elemento) throws IllegalArgumentException;

    /**
     * Elimina un elemento de la colección.
     * @throws NoSuchElementException si la colección es vacía.
     * @param elemento el elemento a eliminar.
     */
    public void eliminar(T elemento) throws NoSuchElementException;

    /**
     * Nos dice si un elemento está contenido en la colección.
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la colección.
     * @return <code>true</code> si el elemento está contenido en la colección,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(T elemento);

    /**
     * Nos dice si el conjunto de elementos en la colección es vacío.
     * @return <code>true</code> si el conjunto de elementos en la colección es
     *         vacío, <code>false</code> en otro caso.
     */
    public boolean esVacia();
    /**
     * Método para eliminar todos los elementos en la colección 
     */
    public void vaciar();

    /**
     * Regresa el número de elementos en la colección.
     * @return el número de elementos en la colección.
     */
    public int getTamanio();

    /**
     * Método que devuelve un iterador sobre la lista
     * @return java.util.Iterador -- iterador sobre la lista
     */
    public Iterator<T> iterator();
}
