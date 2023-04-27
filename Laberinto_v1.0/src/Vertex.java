public class Vertex {

    private int x, y;
    private boolean north, south, east, west, visited;
    private Vertex Up, Down, Left, Right;

    public Vertex() {
    }

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return coordenada en x
     */
    public int getX() {
        return x;
    }

    /**
     * @return coordenada en y
     */
    public int getY() {
        return y;
    }

    /**
     * @return acceso a la casilla norte
     */
    public boolean getNorth() { // bird
        return north;
    }

    /**
     * @return acceso a la casilla sur
     */
    public boolean getSouth() {
        return south;
    }

    /**
     * @return acceso a la casilla este
     */
    public boolean getEast() {
        return east;
    }

    /**
     * @return acceso a la casilla oeste
     */
    public boolean getWest() {
        return west;
    }

    /**
     * Dice si el vértice ha sido visitado
     * 
     * @return
     */
    public boolean getVisited() {
        return visited;
    }

    public Vertex getUp() {
        return Up;
    }

    public Vertex getDown() {
        return Down;
    }

    public Vertex getLeft() {
        return Left;
    }

    public Vertex getRight() {
        return Right;
    }

    /**
     * Cambia la primera coordenada del vértice
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Cambia la segunda coordenada del vértice
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Cambia el acceso al vértice norte
     * 
     * @param north
     */
    public void setNorth(boolean north) {
        this.north = north;
    }

    /**
     * Cambia el acceso al vértice sur
     * 
     * @param south
     */
    public void setSouth(boolean south) {
        this.south = south;
    }

    /**
     * Cambia el acceso al vértice este
     * 
     * @param east
     */
    public void setEast(boolean east) {
        this.east = east;
    }

    /**
     * Cambia el acceso al vértice oeste
     * 
     * @param west
     */
    public void setWest(boolean west) {
        this.west = west;
    }

    /**
     * Dice si ya fue visitado el vértice
     * 
     * @param visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setUp(Vertex up) {
        Up = up;
    }

    public void setDown(Vertex down) {
        Down = down;
    }

    public void setLeft(Vertex left) {
        Left = left;
    }

    public void setRight(Vertex right) {
        Right = right;
    }

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

    public boolean avanzar(int r){
        if(r==0)
            return Up!=null && Up.visited!=true;
        else if(r==1)
            return Right!=null && Right.visited!=true;
        else if(r==2)
            return Down!=null && Down.visited!=true;
        else if(r==3)
            return Left!=null && Left.visited!=true;
        else
            return false;
    }

    /**
     * @param v vértice
     * @return boolean
     */
    public boolean equals(Vertex v) {
        return x == v.x && y == v.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}