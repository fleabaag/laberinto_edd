import datos.PilasAndColas.Cola;
import datos.PilasAndColas.Pila;

/**
 * Clase SoluciónLaberinto. Aqui se encuentran los métodos para
 * resolver el laberinto ya creado previamente.
 * 
 * @author gentle_eartquake
 * @author Wallsified
 * @version 1.0
 */
public class SolucionLaberinto extends Laberinto {

    /**
     * Cola Para marcar la solución
     */
    protected Cola<Vertex> solucion;

    /**
     * Cola para marcar la trayectoria del Laberinto
     */
    protected Pila<Vertex> trayectoria;

    /**
     * Constructor único de SoluciónLaberinto.
     * Al extender de laberinto. utilizamos ese mismo constructor
     * para garantizar resolver el laberinto creado.
     * 
     * @param alto  Alto del Laberinto
     * @param ancho Ancho del Laberinto
     */
    public SolucionLaberinto(int alto, int ancho) {
        super(alto, ancho);
        this.solucion = new Cola<>();
        this.trayectoria = new Pila<>();
        asignarPesos();
        trayectoriaSolucion();
    }

    /**
     * Usando los métodos siguientes, re-entramos al laberinto
     * para considerar que la salida siempre sea la más corta.
     */
    public void asignarPesos() {

        undoVisited();
        queue(0, 0);
        while (!solucion.esVacia()) {
            recorrer();
        }

    }

    /**
     * Retiramos estado de visitado para volver a entrar al laberinto
     */
    public void undoVisited() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                laberinto[i][j].setVisited(false);
            }
        }
    }

    /**
     * Método para agregar a la Cola de solución
     * dada la condición de que una casilla haya sido
     * re-visitada.
     * 
     * @param i Posicion X de la casilla
     * @param j Posicion Y de la casilla.
     */
    public void queue(int i, int j) {
        laberinto[i][j].setVisited(true);
        solucion.queue(laberinto[i][j]);
    }

    /**
     * Método para volver a recorrer el laberinto asigando distancias
     * entre los vecinos.
     */
    public void recorrer() {

        if (solucion.peek().vecinosDisponiblesSolucion()) {

            int i = solucion.peek().getX();
            int j = solucion.peek().getY();
            int distance = solucion.peek().getDistancia() + 1;
            Vertex aux = solucion.peek();

            if (aux.getNorth() && !aux.getUp().getVisited()) {
                laberinto[i - 1][j].setDistancia(distance);
                queue(i - 1, j);
            }

            if (aux.getSouth() && !aux.getDown().getVisited()) {
                laberinto[i + 1][j].setDistancia(distance);
                queue(i + 1, j);
            }

            if (aux.getEast() && !aux.getRight().getVisited()) {
                laberinto[i][j + 1].setDistancia(distance);
                queue(i, j + 1);
            }

            if (aux.getWest() && !aux.getLeft().getVisited()) {
                laberinto[i][j - 1].setDistancia(distance);
                queue(i, j - 1);
            }

        } else {
            solucion.dequeue();
        }

    }

    /**
     * Método para revisar las distancias entre casillas vecinas.
     */
    public void verDistancia() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {

                int temp = laberinto[i][j].getDistancia();
                if (temp < 10)
                    System.out.print(" " + temp + " ");
                else
                    System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método para añadir las direcciónes de la trayectoria a
     * la pila del mismo nombre dada la condición de ser
     * visitado.
     * 
     * @param i Punto X de la Coordenada.
     * @param j Punto Y de la Coordenada.
     */
    public void pushT(int i, int j) {
        laberinto[i][j].setVisited(true);
        trayectoria.push(laberinto[i][j]);
    }

    /**
     * Método compilador para trazar la trayectoria más
     * rápida para salir del laberinto.
     */
    public void trayectoriaSolucion() {
        undoVisited();
        pushT(alto - 1, ancho - 1);
        while (trayectoria.top().getDistancia() > 0) {
            setTrayectoria();
        }
        System.out.println("\nLas coordenadas para la salida más rapida del laberinto son:\n" + trayectoria);
        verTrayectoria();
    }

    /**
     * Método para definir la trayectoria del laberinto.
     */
    public void setTrayectoria() {

        boolean encontrado = false;
        int direccion = 0;

        while (!encontrado && direccion < 4) {

            int i = trayectoria.top().getX();
            int j = trayectoria.top().getY();

            if (trayectoria.top().avanzarSolución(direccion)) {

                Vertex aux = trayectoria.top();

                if (direccion == 0 && aux.compareTo(aux.getUp()) == 1) {
                    pushT(i - 1, j);
                    encontrado = true;
                } else if (direccion == 1 && aux.compareTo(aux.getRight()) == 1) {
                    pushT(i, j + 1);
                    encontrado = true;
                } else if (direccion == 2 && aux.compareTo(aux.getDown()) == 1) {
                    pushT(i + 1, j);
                    encontrado = true;
                } else if (direccion == 3 && aux.compareTo(aux.getLeft()) == 1) {
                    pushT(i, j - 1);
                    encontrado = true;
                } else {
                    direccion++;
                }

            } else {
                direccion++;
            }
        }
    }

    /**
     * Método para evitar falsos positvos entre las coordenadas del laberinto
     * y las que se encuentran en la Pila
     * 
     * @param v Coordenada a revisar.
     * @param P Pila de Trayectoria de Salida.
     * @return <code>true</code> Si la coordenada se encuentra en la Pila
     *         <code>false</code> en caso contrario.
     */
    public boolean contiene(Vertex v, Pila<Vertex> P) {
        boolean output = false;

        for (Vertex e : P) {
            if (e.equals(v))
                output = true;
        }
        return output;
    }

    /**
     * Podemos ver este método como el toString de la trayectoria.
     */
    public void verTrayectoria() {

        for (int s = -1; s < ancho; s++) {
            System.out.print("_\s"); // top border
        }
        System.out.println();

        for (int i = 0; i < alto; i++) {
            System.out.print("|"); // left border
            for (int j = 0; j < ancho; j++) {

                if (contiene(laberinto[i][j], trayectoria)) {
                    System.out.print("x "); // marker
                    if (j + 1 == ancho)
                        System.out.print("|\n"); // right border
                } else if (j + 1 == ancho) {
                    System.out.print("# |\n"); // right border
                } else if (i + 1 == alto) {
                    System.out.print("# "); // down border
                } else {
                    System.out.print("# ");
                }
            }
        }
        for (int s = -1; s < ancho; s++) {
            System.out.print("¯\s"); // top border
        }
        System.out.println("");
    }
}