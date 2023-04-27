import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

/**
 * <p>
 * Clase concreta para modelar la estructura de datos Lista
 * </p>
 * <p>
 * Esta clase implementa una Lista genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.1
 */
public class Lista<T> implements Listable<T>, Coleccionable<T> {

    /* Clase interna para construir la estructura */
    protected class Nodo {
        /* Referencias a los nodos anterior y siguiente */
        public Nodo anterior, siguiente;
        /* El elemento que almacena un nodo */
        public T elemento;

        /* Unico constructor de la clase */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.anterior = null;
            this.siguiente = null;
            // aqui va tu codigo
        }

        public T getElemento() {
            return elemento;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setAnterior(Nodo anterior) {
            this.anterior = anterior;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public boolean equals(Nodo n) {
            if (n != null)
                return this.elemento.equals(n.elemento);
            return false;
            // aqui va tu codigo
        }
    }

    private class IteradorLista implements Iterator {
        /* La lista a recorrer */
        private Lista<T> lista;
        /* Elementos del centinela que recorre la lista */
        private Lista<T>.Nodo anterior, siguiente;

        public IteradorLista(Lista<T> lista) {
            this.lista = lista;
            this.siguiente = lista.cabeza;
            this.anterior = null;
            // aqui va tu codigo
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
            // aqui va tu codigo
        }

        @Override
        public T next() {
            if (hasNext()) {
                this.anterior = this.siguiente;
                this.siguiente = this.siguiente.getSiguiente();

                return anterior.getElemento();
            }
            return null;
            // aqui va tu codigo
        }

        @Override
        public void remove() {
            Nodo aux = siguiente;
            anterior.anterior.setSiguiente(aux);
            siguiente.setAnterior(anterior.anterior);
        }
    }

    /* Atributos de la lista */
    protected Nodo cabeza, cola;
    protected int longitud = 0;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
    }

    public Lista(Nodo node) {
        this.cabeza = node;
        this.cola = node;
        this.longitud++;
    }

    public Lista(T elem) {
        Nodo node = new Nodo(elem);
        this.cabeza = node;
        this.cola = node;
        this.longitud++;
    }

    /**
     * Método que nos dice si las lista está vacía.
     * 
     * @return <code>true</code> si el conjunto está vacío, <code>false</code>
     *         en otro caso.
     */
    public boolean esVacia() {
        return longitud <= 0;
        // aqui va tu codigo
    }

    /**
     * Método para eliminar todos los elementos de una lista
     */
    public void vaciar() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
        // aqui va tu codigo
    }

    /**
     * Método para obtener el tamaño de la lista
     * 
     * @return tamanio Número de elementos de la lista.
     **/
    public int getTamanio() {
        return this.longitud;
        // aqui va tu codigo
    }

    /**
     * Método para agregar un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará a la lista.
     */
    public void agregar(T elemento) throws IllegalArgumentException {
        if (elemento == null) {
            throw new IllegalArgumentException("Elemento por agregar es nulo");
        } else {
            agregarAlFinal(elemento);
        }
        // aqui va tu codigo
    }

    /**
     * Método para agregar al inicio un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlInicio(T elemento) {
        if (elemento != null) {
            Nodo head = new Nodo(elemento);
            if (esVacia()) {
                this.cabeza = head;
                this.cola = head;
            } else {
                head.setSiguiente(cabeza);
                cabeza.setAnterior(head);
                this.cabeza = head;
            }
            this.longitud++;
        }
        // aqui va tu codigo
    }

    /**
     * Método para agregar al final un elemento a la lista.
     * 
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlFinal(T elemento) {
        if (elemento != null) {
            Nodo tail = new Nodo(elemento);
            if (esVacia()) {
                this.cabeza = tail;
                this.cola = tail;
            } else {
                tail.setAnterior(cola);
                cola.setSiguiente(tail);
                this.cola = tail;
            }
            this.longitud++;
        }
        // aqui va tu codigo
    }

    /**
     * Método para verificar si un elemento pertenece a la lista.
     * 
     * @param elemento Objeto que se va a buscar en la lista.
     * @return <code>true</code> si el elemento esta en el lista y false en otro
     *         caso.
     */
    public boolean contiene(T elemento) {
        if (elemento != null) {
            Iterator<T> it = iterator();

            while (it.hasNext()) {
                T e = (T) it.next();
                if (e.equals(elemento))
                    return true;
            }
        }
        return false;
        // aqui va tu codigo
    }

    /**
     * Método para eliminar un elemento de la lista.
     * 
     * @param elemento Objeto que se eliminara de la lista.
     */
    public void eliminar(T elemento) throws NoSuchElementException {

        if (contiene(elemento)) {
            if (!esVacia() && elemento != null) {
                if (this.longitud == 1 && cabeza.elemento.equals(elemento)) {
                    vaciar();
                } else {
                    Iterator<T> it = iterator();
                    int a = 0;
                    while (it.hasNext() && a < longitud) {
                        T temporal = it.next();

                        if (temporal.equals(elemento)) {
                            if (cabeza.elemento.equals(temporal) && a == 0) {
                                cabeza.siguiente.setAnterior(null);
                                cabeza = cabeza.siguiente;
                                longitud--;
                                break;
                            } else if (cola.elemento.equals(temporal) && a == (longitud - 1)) {
                                cola.anterior.setSiguiente(null);
                                cola = cola.anterior;
                                longitud--;
                                break;
                            } else if (a > 0 && a < (longitud - 1)) {
                                it.remove();
                                longitud--;
                                break;
                            }
                        }
                        a++;
                    }
                }
            }
        } else {
            throw new NoSuchElementException();
        }

    }

    /**
     * Método que devuelve la posición en la lista que tiene la primera
     * aparición del <code> elemento</code>.
     * 
     * @param elemento El elemnto del cuál queremos saber su posición.
     * @return i la posición del elemento en la lista, -1, si no se encuentra en
     *         ésta.
     */
    public int indiceDe(T elemento) {
        int index = 0;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (elemento.equals(it.next()))
                return index;
            index++;
        }
        return -1;
        // aqui va tu codigo
    }

    /**
     * Método que nos dice en qué posición está un elemento en la lista.
     * 
     * @param i La posición cuyo elemento deseamos conocer.
     * @return <code> elemento </code> El elemento que contiene la lista,
     *         <code>null</code> si no se encuentra
     * @throws IndexOutOfBoundsException Si el índice es < 0 o >longitud()
     */
    public T getElemento(int i) throws IndexOutOfBoundsException {
        if (i >= longitud) {
            throw new IndexOutOfBoundsException();
        } else {
            Iterator<T> it = iterator();
            int a = 0;
            while (a < i) {
                it.next();
                a++;
            }
            return it.next();
        }
        // aqui va tu codigo
    }

    /**
     * Método que devuelve una copia de la lista, pero en orden inverso.
     * 
     * @return Una copia con la lista al revés.
     */
    public Lista<T> reversa() {
        Iterator<T> it = iterator();
        Lista<T> output = new Lista<>();

        while (it.hasNext()) {
            output.agregarAlInicio(it.next());
        }

        return output;
        // aqui va tu codigo
    }

    /**
     * Método que devuelve una copia exacta de la lista.
     * 
     * @return la copia de la lista.
     */
    public Lista<T> copia() {
        Iterator<T> it = iterator();
        Lista<T> output = new Lista<>();

        while (it.hasNext()) {
            output.agregarAlFinal(it.next());
        }

        return output;
        // aqui va tu codigo
    }

    /**
     * Método que nos dice si una lista es igual que otra.
     * 
     * @param o objeto a comparar con la lista.
     * @return <code>true</code> si son iguales, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && (o instanceof Lista)) {

            Lista<T> compare = (Lista<T>) o;

            boolean a = true;
            if (this.longitud == compare.longitud) {

                Iterator<T> it1 = this.iterator();
                Iterator<T> it2 = compare.iterator();

                while (it1.hasNext() && it2.hasNext()) {
                    if (!(it1.next().equals(it2.next())))
                        a = false;
                }

            } else {
                a = false;
            }
            return a;
        }
        return false;
        // aqui va tu codigo
    }

    /**
     * Método que devuelve un iterador sobre la lista.
     * 
     * @return java.util.Iterador -- iterador sobre la lista
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista(this);
    }

    /**
     * Método que devuelve una copia de la lista.
     * 
     * @param <T> Debe ser un tipo que extienda Comparable, para poder distinguir
     *            el orden de los elementos en la lista.
     * @param l   La lista de elementos comparables.
     * @return copia de la lista ordenada.
     */
    public static <T extends Comparable<T>> Lista<T> mergesort(Lista<T> l) {

        if (l.esVacia() || l.longitud == 1)
            return l;

        Iterator<T> it = l.iterator();
        Lista<T> l1 = new Lista<>();
        Lista<T> l2 = new Lista<>();
        int position = 0;

        while (it.hasNext()) {
            if (position < l.longitud / 2) {
                l1.agregar(it.next());
            } else {
                l2.agregar(it.next());
            }
            position++;
        }

        return merge(mergesort(l1), mergesort(l2));
        // aqui va tu codigo
    }

    /**
     * Método que una ordenadamente dos listas dadas.
     * 
     * @param l1 lista uno
     * @param l2 lista dos
     * @return Lista
     */
    public static <T extends Comparable<T>> Lista<T> merge(Lista<T> l1, Lista<T> l2) {
        Lista<T> merge = new Lista<>();

        if (l1.esVacia())
            return l2;
        else if (l2.esVacia())
            return l1;

        while (l1.longitud > 0 || l2.longitud > 0) {
            T head1 = l1.cabeza.elemento;
            T head2 = l2.cabeza.elemento;
            if (head1.compareTo(head2) <= 0) {
                Lista<T> aux = new Lista<>(head1);
                merge = aux.concatena(merge(l1.eliminaCabeza(), l2));

            } else {
                Lista<T> aux = new Lista<>(head2);
                merge = aux.concatena(merge(l1, l2.eliminaCabeza()));
            }
        }
        return merge;
        // aqui va tu codigo
    }

    /**
     * Método que une dos listas, los elementos de la que llama al método seguida
     * de los elementos de la segunda.
     * 
     * @param l segunda lista en la concatenación.
     * @return Lista
     */
    public Lista<T> concatena(Lista<T> l) {
        if (l.esVacia())
            return this;

        agregarAlFinal(l.cabeza.elemento);
        l.eliminaCabeza();
        concatena(l);
        return this;
    }

    /**
     * Método que elimina la cabeza de cualquier lista.
     * 
     * @return Lista
     */
    public Lista<T> eliminaCabeza() {

        if (esVacia() || longitud == 1) {
            vaciar();
        } else {
            cabeza.siguiente.setAnterior(null);
            cabeza = cabeza.siguiente;
            longitud--;
        }
        return this;
    }

    /**
     * Método que regresa la Lista en forma de cadena.
     * 
     * @return String
     */
    @Override
    public String toString() {
        String output = "";
        if (longitud > 0) {
            output = output + "{";
            for (int i = 0; i < longitud; i++) {
                if ((i + 1) == longitud) {
                    output = output + getElemento(i) + "}";
                } else {
                    output = output + getElemento(i) + ", ";
                }
            }
        }

        return output;
        // aqui va tu codigo
    }
}