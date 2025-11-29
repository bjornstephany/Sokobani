public class InputHandler {
    
    static void fireMoveUp(GameMap map) {
        map.movePlayer(0, -1);
    }

    static void fireMoveLeft(GameMap map) {
        map.movePlayer(-1, 0);
    }

    static void fireMoveRight(GameMap map) {
        map.movePlayer(1, 0);
    }

    static void fireMoveDown(GameMap map) {
        map.movePlayer(0, 1);
    }

    static void restart(GameMap map) {
        
    }
}
