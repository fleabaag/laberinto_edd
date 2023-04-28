
public class SolucionLaberinto extends Laberinto {

    protected Cola<Vertex> solucion;
    protected Pila<Vertex> trayectoria;

    public SolucionLaberinto(int alto, int ancho) {
        super(alto, ancho);
        this.solucion = new Cola<>();
        this.trayectoria = new Pila<>();
        asignarPesos();
        trayectoriaSolucion();
        // verDistancia();
    }

    public void asignarPesos() {

        undoVisited();
        queue(0, 0);
        while (!solucion.esVacia()) {
            recorrer();
        }

    }

    public void undoVisited() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                laberinto[i][j].setVisited(false);
            }
        }
    }

    public void queue(int i, int j) {
        laberinto[i][j].setVisited(true);
        solucion.queue(laberinto[i][j]);
    }

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

    public void pushT(int i, int j) {
        laberinto[i][j].setVisited(true);
        trayectoria.push(laberinto[i][j]);
    }

    public void trayectoriaSolucion() {

        undoVisited();
        pushT(alto - 1, ancho - 1);
        while (trayectoria.top().getDistancia() > 0) {
            setTrayectoria();
        }
        System.out.println("\nTrayectoria en coordenadas:\n" + trayectoria);
        verTrayectoria();

    }

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

    public boolean contiene(Vertex v, Pila<Vertex> P) {
        boolean output = false;

        for (Vertex e : P) {
            if (e.equals(v))
                output = true;
        }

        return output;
    }

    public void verTrayectoria() {

        for (int s = 0; s < ancho; s++) {
            System.out.print(" _");
        }
        System.out.println();

        for (int i = 0; i < alto; i++) {
            System.out.print("|");
            for (int j = 0; j < ancho; j++) {

                if (contiene(laberinto[i][j], trayectoria)) {
                    System.out.print(" x");
                    if (j + 1 == ancho)
                        System.out.print("|");

                } else if (j + 1 == ancho) {
                    System.out.print("  |");
                } else if (i + 1 == alto) {
                    System.out.print(" _");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

}