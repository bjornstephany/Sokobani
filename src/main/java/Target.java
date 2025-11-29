
public class Target extends GameObject {

    Target(Position position) {
        super(position);
    }
    @Override
    char getSymbol() {
        return 'T';
    }
}
