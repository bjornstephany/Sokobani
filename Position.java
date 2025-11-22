public class Position {
    public int x;
    public int y;

    //Constructor for initial x and y values
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getter methods for X and Y
    public int getX() {
        return x;
    }
    public int getY() { 
        return y;
    }

    //Setter methods for X and Y
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    //A toString() method that returns a textual representation of the position, such as (2,3)
    public String toString() {
        return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
    }
}
