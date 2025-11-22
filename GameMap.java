import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameMap {

    ArrayList<GameObject> staticObjects = new ArrayList<>();
    ArrayList<GameObject> dynamicObjects = new ArrayList<>();

    int gridHeight;
    int gridWidth = 0;
    Player player;

    void draw() {
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                GameObject object = getObjectAt(x, y);
                if (object == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + object.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    GameObject getObjectAt(int x, int y) {
        //Checks for dynamic objects first so if a tile has a Box and a Target it will print the box!
        for (GameObject object : dynamicObjects) {
            if (object.isAt(x, y)) {
                return object;
            }
        }
        for (GameObject object : staticObjects) {
            if (object.isAt(x, y)) {
                return object;
            }
        }
        return null;
    }

    public boolean inBounds(int x, int y) {
        if (x >= 0 && x <= gridWidth - 1 && y >= 0 && y <= gridHeight - 1)
            return true;
        return false;
    }

    void update() {
        draw();
        checkWinCondition();
    }

    void movePlayer(int dx, int dy) {
        // Target x and y coordinates
        int targetX = player.position.getX() + dx;
        int targetY = player.position.getY() + dy;

        GameObject object = getObjectAt(targetX, targetY);

        // If the target tile is empty move the player
        if (object == null) {
            player.move(dx, dy);
            update();
            return;
        }

        if (object instanceof Wall) {
            System.out.println("Wall");
            return;
        }

        if (object instanceof Box) {
            // Calculate the space behind the box
            int boxTargetX = targetX + dx;
            int boxTargetY = targetY + dy;
            GameObject boxTarget = getObjectAt(boxTargetX, boxTargetY);
            // If that space is empty, move the box, then move the player
            if (boxTarget == null || boxTarget instanceof Target && inBounds(boxTargetX, boxTargetY)) {
                ((Box) object).move(dx, dy);
                player.move(dx, dy);
                update();
                return;
            }
        }
    }

    void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            int y = 0;
            
            while ((line = reader.readLine()) != null) {
                //Make grid as wide as the longest line in the txt.file
                gridWidth = Math.max(gridWidth, line.length());
                for (int x = 0; x < line.length(); x++) {
                    char c = line.charAt(x);
                    //System.out.print(c);
                    Position position = new Position(x, y);
                    //Check for each object symbol
                    switch (c) {
                        case '#':
                            staticObjects.add(new Wall(position));
                            break;
                        case 'P':
                            player = new Player(position);
                            //for the inBounds method in Player
                            player.map = this;
                            dynamicObjects.add(player);
                            break;
                        case 'B':
                            dynamicObjects.add(new Box(position));
                            break;
                        case 'T':
                            staticObjects.add(new Target(position));
                            break;
                        default: //ignore if unknown
                            break;
                    }
                }
                //System.out.println();
                y++;
            }
            gridHeight = y;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loop through all Target objects, and for each one, check if a Box is also present at the same position.
    void checkWinCondition() {
        int targetCount = 0;
        int boxOnTarget = 0;
        for(GameObject target : staticObjects) {
            if (target instanceof Target) {
                targetCount++;
                int tx = ((Target)target).position.getX();
                int ty =((Target)target).position.getY();
                for(GameObject box : dynamicObjects) {
                    if (box instanceof Box) {
                        int bx = ((Box)box).position.getX();
                        int by = ((Box)box).position.getY();
                        if (tx == bx && ty == by) {
                            boxOnTarget++;
                        }
                    }
                }
            }
        }
        if (targetCount == boxOnTarget) {
            System.out.println("You win!");
        }
    }
}
