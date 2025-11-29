public class Box extends GameObject implements Movable{
    
    Box(Position position) {
        super(position);
    }

    @Override
    String getSymbol() {
        return "B";
    }

    @Override
    public void move(int dx, int dy) {
        position.setX(position.getX() + dx);
        position.setY(position.getY() + dy);
    }
    
}
