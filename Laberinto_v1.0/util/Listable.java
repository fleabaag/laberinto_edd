/**
 * <p> Interfaz para listas </p> <p>Esta clase contiene las
 * operaciones elementales que debe tener el TAD Lista </p>
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.1
 */
public interface Listable<T> {

    /**
     * Método que devuelve la posición en la lista que tiene la primera
     * aparición del <code> elemento</code>.
     * @param elemento El elemnto del cuál queremos saber su posición.
     * @return i la posición del elemento en la lista, -1, si no se encuentra en ésta.
     */
    public int indiceDe(T elemento);

    /**
     * Método que nos dice en qué posición está un elemento en la lista
     * @param i La posición cuyo elemento deseamos conocer.
     * @return <code> elemento </code> El elemento que contiene la lista,
     * <code>null</code> si no se encuentra
     * @throws IndexOutOfBoundsException Si el índice es < 0 o >longitud()
     */
    public T getElemento(int i)throws IndexOutOfBoundsException;

    /**
     * Método que devuelve una copia de la lista, pero en orden inverso
     * @return Una copia con la lista l revés.
     */
    public Lista<T> reversa();

    /**
     * Método que devuelve una copi exacta de la lista
     * @return la copia de la lista.
     */
    public Lista<T> copia();

}
