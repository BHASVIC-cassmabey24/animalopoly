import java.util.ArrayList;

public class Init {
    static ArrayList<Square> initBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        int cornerCounter = 0;
        for (int i = 0; i < 40; i++) {
            if (i == 0) {
                board.add(1, new Square("start"));
                cornerCounter += 1;
            }
            if (i % 10 == 0) {
                if (cornerCounter == 2) {
                    board.add(1, new Square("jail"));
                } else if (cornerCounter == 3) {
                    board.add(1, new Square("free parking"));
                } else if (cornerCounter == 4) {
                    board.add(1, new Square("jail"));
                }
            }
        }
        return board;
    }

    private static void initSquares() {

    }

    private static void initPlayers() {

    }
}
