/**
 * Clase Vertex que serán nuestras coordenadas en la matriz
 * del Laberinto. Notemos que una coordenada es un par ordenado
 * (x,y).
 * 
 * Nota: Se usan Coordenada y Vertice para referirse al mismo
 * concepto a lo largo del código.
 * 
 * @author Wallsified
 * @author gentle_earthquake
 * @version 1.0
 */
public class Vertex {

    /**
     * Punto X de la coordenada.
     */
    private int x;

    /**
     * Punto Y de la coordenada
     */
    private int y;

    /**
     * Éstos booleanos sirven como indicadores de vecinos en una dirección.
     * Vecino Norte.
     */
    private boolean north;// bird

    /**
     * Vecino Sur.
     */
    private boolean south;

    /**
     * Vecino Este/Derecho
     */
    private boolean east;

    /**
     * Vecino Oeste/Izquierdo
     */
    private boolean west;

    /**
     * Indicador de si una coordenada ya fue visitada.
     */
    private boolean visited;

    /**
     * Coordenada Superior a la que se refiere.
     */
    private Vertex Up;

    /**
     * Coordenada Inferior a la que se refiere.
     */
    private Vertex Down;

    /**
     * Coordenada Lateral Izquierda a la que se refiere.
     */
    private Vertex Left;

    /**
     * Coordenada Lateral Derecha a la que se refiere.
     */
    private Vertex Right;

    /**
     * Constructor Vacio por omisión.
     */
    public Vertex() {
    }

    /**
     * Constructor que inicializa dados parametros para cada entrada en
     * la coordenada.
     * 
     * @param x Valor de X en la coordenada.
     * @param y Valor de Y en la coordenada.
     */
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter del Punto X de la coordenada.
     * 
     * @return Coordenada en x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter del Punto Y de la coordenada.
     * 
     * @return Coordenada en y
     */
    public int getY() {
        return y;
    }

    /**
     * Getter del vecino al Norte.
     * 
     * @return acceso a la casilla norte
     */
    public boolean getNorth() { // bird
        return north;
    }

    /**
     * Getter del vecino al Sur.
     * 
     * @return acceso a la casilla sur
     */
    public boolean getSouth() {
        return south;
    }

    /**
     * Getter del vecino Este.
     * 
     * @return acceso a la casilla este
     */
    public boolean getEast() {
        return east;
    }

    /**
     * Getter del vecino Oeste.
     * 
     * @return acceso a la casilla oeste
     */
    public boolean getWest() {
        return west;
    }

    /**
     * Dice si el vértice ha sido visitado
     * 
     * @return <code>true</code> Si el vecino ha sido visitado,
     *         <code>false</code> en caso contrario.
     */
    public boolean getVisited() {
        return visited;
    }

    /**
     * Getter del Vecino Superior.
     * 
     * @return Vecino Superior.
     */
    public Vertex getUp() {
        return Up;
    }

    /**
     * Getter del Vecino Inferior.
     * 
     * @return Vecino Inferior.
     */
    public Vertex getDown() {
        return Down;
    }

    /**
     * Getter del Vecino Izquierdo.
     * 
     * @return Vecino Izquierdo.
     */
    public Vertex getLeft() {
        return Left;
    }

    /**
     * Getter del Vecino Derecho.
     * 
     * @return Vecino Derecho.
     */
    protected Vertex getRight() {
        return Right;
    }

    /**
     * Cambia la primera coordenada del vértice
     * 
     * @param x Punto X de la Coordenada
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Cambia la segunda coordenada del vértice
     * 
     * @param y Punto Y de la coordenada.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Cambia el acceso al vértice norte
     * 
     * @param north Coordenada Norte
     */
    public void setNorth(boolean north) {// bird, again
        this.north = north;
    }

    /**
     * Cambia el acceso al vértice sur
     * 
     * @param south Coordenada Sur
     */
    public void setSouth(boolean south) {
        this.south = south;
    }

    /**
     * Cambia el acceso al vértice este
     * 
     * @param east Coordenada Este
     */
    public void setEast(boolean east) {
        this.east = east;
    }

    /**
     * Cambia el acceso al vértice oeste
     * 
     * @param west Coordenada Oeste
     */
    public void setWest(boolean west) {
        this.west = west;
    }

    /**
     * Dice si ya fue visitado el vértice (Setter)
     * 
     * @param visited Coordenada visitada
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Setter de la coordenada Norte a la referida.
     * 
     * @param up
     */
    public void setUp(Vertex up) {
        Up = up;
    }

    /**
     * Setter de la coordenada Sur a la referida.
     * 
     * @param down
     */
    public void setDown(Vertex down) {
        Down = down;
    }

    /**
     * Setter de la coordenada Oeste a la referida.
     * 
     * @param left
     */
    public void setLeft(Vertex left) {
        Left = left;
    }

    /**
     * Setter de la coordenada Este a la referida.
     * 
     * @param right
     */
    public void setRight(Vertex right) {
        Right = right;
    }

    /**
     * Método que nos indica si dada una coordenada, ésta tiene
     * aun direcciones a donde desplazarse.
     * 
     * @return <code>true</code> Si tiene a donde dirigirse,
     *         <code>false</code> en caso contrario.
     */
    public boolean vecinosDisponibles() {
        int a = 0;

        if (Up == null || Up.visited)
            a++;
        if (Down == null || Down.visited)
            a++;
        if (Right == null || Right.visited)
            a++;
        if (Left == null || Left.visited)
            a++;

        return a < 4;
    }

    /**
     * Método para saber si dada una coordenada, ésta tiene a donde avanzar.
     * Es el método compañero de vecinosDisponibles().
     * 
     * @param r Dirección en numero de hacia donde se puede avanzar. (ie. 1 = norte,
     *          2= sur, etc.)
     * @return <code>true</code> Si se puede avanzar,
     *         <code>false</code> en caso contrario.
     */
    public boolean avanzar(int r) {
        if (r == 0)
            return Up != null && Up.visited != true;
        else if (r == 1)
            return Right != null && Right.visited != true;
        else if (r == 2)
            return Down != null && Down.visited != true;
        else if (r == 3)
            return Left != null && Left.visited != true;
        else
            return false;
    }

    /**
     * Método para comparar dos coordenadas dadas sus entradas.
     * 
     * @param v Vértice a comparar.
     * @return <code>true</code> Si se habla de la misma coordenada,
     *         <code>false</code> en caso contrario.
     */
    public boolean equals(Vertex v) {
        return x == v.x && y == v.y;
    }

    /**
     * Representación en cadena de una Coordenada.
     * 
     * @return String Coordenada en Cadena.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}