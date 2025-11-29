public abstract class GameObject {

    // A Position field
    public Position position;

    // A constructor to set the position
    GameObject(Position position) {
        this.position = position;
    }

    // A getPosition() method
    Position getPosition() {
        return position;
    }

    // A getSymbol() method that returns a character (e.g., 'P', '#', or '.')
    abstract char getSymbol();

    boolean isAt(int x, int y) {
        if(position.getX() == x && position.getY() == y) {
            return true;
        }
        return false;
    }
}
