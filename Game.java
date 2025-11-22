import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        GameMap map = new GameMap();
        
        map.loadFromFile("level1.txt");

        Scanner scanner = new Scanner(System.in);
        map.draw();
        while (true) {
            System.out.print("Enter move (w/a/s/d):\n> ");
            String input = scanner.nextLine();
            if (input.equals("w")) {
                map.movePlayer(0, -1);
            }
            if (input.equals("a")) {
                map.movePlayer(-1, 0);
            }
            if (input.equals("s")) {
                map.movePlayer(0, 1);
            }
            if (input.equals("d")) {
                map.movePlayer(1, 0);
            }
            if (input.equals("q")) {
                break;
            }
        }
        scanner.close();
    }
}
