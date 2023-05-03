import java.util.Random;
import datos.PilasAndColas.Pila;

/**
 * Clase Laberinto. Desde aqui funciona todo, más no se ejecuta directamente.
 * 
 * @author gentle_earthquake
 * @author Wallsified
 * @version 1.0
 */

public class Laberinto {

    /**
     * Alto del Laberinto
     */
    protected int alto;

    /**
     * Ancho del laberinto.
     */
    protected int ancho;

    /**
     * Total de coordenadas en el laberinto.
     * i.e un laberinto de 10x10 tiene 100 cordenadas.
     */
    protected int contador;

    /**
     * Matriz de Coordenadas que se volverá el laberinto.
     */
    protected Vertex[][] laberinto;

    /**
     * Coordenada de Inicio.
     */
    protected Vertex inicio;

    /**
     * Coordenada de Salida
     */
    protected Vertex fin;

    /**
     * Pila de Vertex(Coordenadas) que usaremos para
     * dar sentido a las direcciones del Laberinto.
     */
    protected Pila<Vertex> llenado;

    /**
     * Constructor del Laberinto dado paramentros de ancho y alto.
     * 
     * @param alto  Alto del Laberinto.
     * @param ancho Ancho del Laberinto.
     */
    public Laberinto(int alto, int ancho) {
        this.laberinto = new Vertex[alto][ancho];
        this.llenado = new Pila<Vertex>();
        this.alto = alto;
        this.ancho = ancho;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                laberinto[i][j] = new Vertex(i, j);
            }
        }
        esquinar();
        setMapa();
        verLaberinto();

    }

    /**
     * Método para llenar de esquinas el laberinto.
     */
    public void esquinar() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {

                if (i == 0)
                    laberinto[i][j].setUp(null);
                else
                    laberinto[i][j].setUp(laberinto[i - 1][j]);

                if (i + 1 == alto)
                    laberinto[i][j].setDown(null);
                else
                    laberinto[i][j].setDown(laberinto[i + 1][j]);

                if (j == 0)
                    laberinto[i][j].setLeft(null);
                else
                    laberinto[i][j].setLeft(laberinto[i][j - 1]);

                if (j + 1 == ancho)
                    laberinto[i][j].setRight(null);
                else
                    laberinto[i][j].setRight(laberinto[i][j + 1]);

            }
        }

    }

    /**
     * Método que selecciona un aleatorio para indicar la siguiente dirección
     * a donde ir en el laberinto. Vease como que 1 = ir norte, 2 = ir este, etc.
     * 
     * @param limit Limite de rango entre los aleatorios.
     * @return int Valor a considerar como dirección.
     */
    public int Random(int limit) {

        Random random = new Random();
        int output = random.nextInt(limit);

        return output;
    }

    /**
     * Setter del punto de inicio de nuestros Laberintos.
     * Por defecto, serán en la coordenada (0,0).
     */
    public void setInicio() {
        this.inicio = laberinto[0][0];
        inicio.setDistancia(0);
        laberinto[0][0].setDistancia(0);
    }

    /**
     * Setter del punto de inicio de nuestros Laberintos.
     * Por defecto, serán en la coordenada (alto-1,ancho-1)
     * osea, la esquina inferior derecha del laberinto.
     */
    public void setFin() {
        this.fin = laberinto[alto - 1][ancho - 1];
    }

    /**
     * Éste método funciona como un compilado de los métodos del
     * laberinto para usarlo directamente en el constructor.
     */
    public void setMapa() {
        setInicio();
        setFin();
        primero();
        while (!llenado.esVacia()) {
            llenar();
        }
    }

    /**
     * Método que llena de "obstaculos" el laberinto.
     */
    public void llenar() {
        if (llenado.top().vecinosDisponibles()) {
            int direccion = Random(4);
            if (llenado.top().avanzar(direccion)) {

                int i = llenado.top().getX();
                int j = llenado.top().getY();

                if (direccion == 0) {
                    llenado.top().setNorth(true);
                    push(i - 1, j);
                    llenado.top().setSouth(true);
                }
                if (direccion == 1) {
                    llenado.top().setEast(true);
                    push(i, j + 1);
                    llenado.top().setWest(true);
                }
                if (direccion == 2) {
                    llenado.top().setSouth(true);
                    push(i + 1, j);
                    llenado.top().setNorth(true);
                }

                if (direccion == 3) {
                    llenado.top().setWest(true);
                    push(i, j - 1);
                    llenado.top().setEast(true);
                }

            } else {
                llenar();
            }

        } else {
            contador += 1;
            llenado.pop();
        }
    }

    /**
     * Método para añadir la primera coordenada consecuente
     * de la coordenada inicial.
     */
    public void primero() {
        int i = Random(this.alto);
        int j = Random(this.ancho);
        push(i, j);
    }

    /**
     * Método personzalidado al push de la Pilas para nuestro laberinto.
     * Primero marcamos la coordenada en cuestión como visitada y posteriormente
     * se añade a la Pila.
     * 
     * @param i Punto X de la coordenada
     * @param j Punto Y de la coordenada
     */
    public void push(int i, int j) {
        laberinto[i][j].setVisited(true);
        llenado.push(laberinto[i][j]);
    }

    /**
     * Podemos ver este método como el toString() de nuestros laberintos.
     */
    public void verLaberinto() {
        System.out.println("\nEl laberinto aleatorio generado es:");
        for (int s = 0; s < ancho; s++) {
            System.out.print(" _");
        }
        System.out.println();
        for (int i = 0; i < alto; i++) {
            System.out.print("|");
            for (int j = 0; j < ancho; j++) {

                if (laberinto[i][j].equals(inicio) && !laberinto[i][j].getSouth())
                    System.out.print("i");
                else if (laberinto[i][j].equals(inicio))
                    System.out.print("I");
                else if (laberinto[i][j].equals(fin))
                    System.out.print("F");
                else if (laberinto[i][j].getSouth())
                    System.out.print(" ");
                else
                    System.out.print("_");

                if (laberinto[i][j].getEast())
                    System.out.print(" ");
                else
                    System.out.print("|");

            }
            System.out.println();
        }
    }

    /**
     * Formatters
     */
    /*
     * public static String padRight(String s, int n) {
     * return String.format("%-" + n + "s", s);
     * }
     * 
     * public static String padLeft(String s, int n) {
     * return String.format("%" + n + "s", s);
     * }
     */
}
