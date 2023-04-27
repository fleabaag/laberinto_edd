import java.util.Random;
// import java.util.Scanner;
import java.util.Scanner;

public class Laberinto {

    private int alto, ancho, contador;
    private Vertex[][] laberinto;
    private Vertex inicio, fin;
    private Pila<Vertex> llenado;

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
        weave();
        setMapa();
    }

    public void weave() {
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

    public int Random(int limit) {

        Random random = new Random();
        int output = random.nextInt(limit);

        return output;
    }

    public void setInicio() {
        this.inicio = laberinto[0][0];
    }

    public void setFin() {
        this.fin = laberinto[alto-1][ancho-1];
    }

    public void setMapa() {
        setInicio();
        setFin();
        primero();
        while (!llenado.esVacia()) {
            llenar();
        }
        System.out.println(contador);
    }

    public void llenar() {
        if (llenado.top().vecinosDisponibles()) {
            int uwu = Random(4);
            if (llenado.top().avanzar(uwu)) {

                int i = llenado.top().getX();
                int j = llenado.top().getY();

                if (uwu == 0) {
                    llenado.top().setNorth(true);
                    push(i - 1, j);
                    llenado.top().setSouth(true);
                }
                if (uwu == 1) {
                    llenado.top().setEast(true);
                    push(i, j + 1);
                    llenado.top().setWest(true);
                }
                if (uwu == 2) {
                    llenado.top().setSouth(true);
                    push(i + 1, j);
                    llenado.top().setNorth(true);
                }

                if (uwu == 3) {
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

    public void primero() {
        int i = Random(this.alto);
        int j = Random(this.ancho);
        push(i, j);
    }

    public void push(int i, int j) {
        laberinto[i][j].setVisited(true);
        llenado.push(laberinto[i][j]);
    }

    public void verLaberinto() {
        for (int s = 0; s < ancho; s++) {
            System.out.print(" _");
        }
        System.out.println();
        for (int i = 0; i < alto; i++) {
            System.out.print("|");
            for (int j = 0; j < ancho; j++) {

                if (laberinto[i][j].equals(inicio) && !laberinto[i][j].getSouth())
                    System.out.print("i");
                else if(laberinto[i][j].equals(inicio))
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

    public static void start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe el alto del laberinto: ");
        int i = sc.nextInt();
        System.out.print("Escribe el ancho del laberinto: ");
        int j = sc.nextInt();

        Laberinto laberinto = new Laberinto(i, j);
        laberinto.verLaberinto();

    }
}