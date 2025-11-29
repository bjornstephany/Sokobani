
public class Player extends GameObject implements Movable{

    //GameMap reference for inBounds
    GameMap map;

    //starting position constructor
    Player(Position position) {
        super(position);
    }

    @Override
    String getSymbol() {
        return "P";
    }

    @Override
    public void move(int dx, int dy) {
        int targetX = position.getX() + dx;
        int targetY = position.getY() + dy;
        if (map.inBounds(targetX, targetY)) {
            position.setX(targetX);
            position.setY(targetY);
        } else {
            System.out.println("out of bounds");
        }
    }
}
