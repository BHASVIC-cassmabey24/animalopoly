import java.util.ArrayList;

public class Init {
    static ArrayList<Square> initBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        for (int j = 0; j < 40; j++) {
            board.add(j, new Square("nothing :)", j));
        }
        int cornerCounter = 1;
        int regCounter = 1;
        for (int i = 0; i < 40; i++) {
            if (i == 0) {
                board.set(0, new Square("start", i));
                cornerCounter += 1;

                System.out.println("Sucessfully added start");
            } else if (regCounter == 9) {
                if (cornerCounter == 2) {
                    board.set(i, new Square("jail", i));
                } else if (cornerCounter == 3) {
                    board.set(i, new Square("free parking", i));
                } else if (cornerCounter == 4) {
                    board.set(i, new Square("go to jail", i));
                }
                cornerCounter += 1;
                regCounter = 0;
            } else {

                regCounter += 1;
            }

        }
        return board;
    }

    private static void initSquares() {

    }

    private static void initPlayers() {

    }
}
