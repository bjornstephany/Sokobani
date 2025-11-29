
import java.io.IOException;
import java.util.Scanner;

public class Game {

    // I think it's okay to just put throws IOException since we have our own custom
    // ones printed anyways
    public static void main(String[] args) throws IOException {
        GameMap map = new GameMap();
        try {
            map.loadFromResource("level1.txt");
            //map.writeToFile("level1.txt");
        } catch (GameMap.InvalidLevelFormatException e) {
            // exit gracefully
            System.out.println(e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        map.draw();
        while (true) {
            
            System.out.print("Enter move (w/a/s/d):\n> ");
            String line = scanner.nextLine();
            char c = Character.toLowerCase(line.charAt(0));
            
            switch (c) {
                case 'w' -> InputHandler.fireMoveUp(map);
                case 'a' -> InputHandler.fireMoveLeft(map);
                case 's' -> InputHandler.fireMoveDown(map);
                case 'd' -> InputHandler.fireMoveRight(map);
                case 'r' -> InputHandler.restart(map);
                default ->
                    System.out.println("Invalid input. Use w/a/s/d to move.");
            }
        }
    }
}
