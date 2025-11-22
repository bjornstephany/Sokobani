public class Target extends GameObject {

    Target(Position position) {
        super(position);
    }
    @Override
    String getSymbol() {
        return "T";
    }
}
