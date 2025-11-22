public class Wall extends GameObject{

    Position position;
    Wall(Position position) {
        super(position);
    }
    @Override
    String getSymbol() {
        return "#";
    }

}
