import java.util.ArrayList;

public class Init {
    static ArrayList<Square> initBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        for (int j = 0; j < 36; j++) {
            board.add(j, new Square("empty", j));
        }
        for (int j = 0; j < 36; j++) {
            if (j == 1 || j == 3) {
                board.set(1, new Animal("Mouse", 0, 0));
                board.set(3, new Animal("Rat", 0, 0));
            } else if (j == 5 || j == 7 || j == 8) {
                board.set(5, new Animal("Chicken", 1, 0));
                board.set(7, new Animal("Vulture", 1, 0));
                board.set(8, new Animal("Eagle", 1, 0));
            } else if (j == 10 || j == 12 || j == 13) {
                board.set(10, new Animal("Donkey", 2, 0));
                board.set(12, new Animal("Mule", 2, 0));
                board.set(13, new Animal("Horse", 2, 0));
            } else if (j == 15 || j == 16 || j == 17) {
                board.set(15, new Animal("Wombat", 3, 0));
                board.set(16, new Animal("Coala", 3, 0));
                board.set(17, new Animal("Kangaroo", 3, 0));
            } else if (j == 19 || j == 20 || j == 21) {
                board.set(19, new Animal("Shark", 4, 0));
                board.set(20, new Animal("Fish", 4, 0));
                board.set(21, new Animal("Whale", 4, 0));
            } else if (j == 23 || j == 24 || j == 26) {
                board.set(23, new Animal("Jaguar", 5, 0));
                board.set(24, new Animal("Tiger", 5, 0));
                board.set(26, new Animal("Lion", 5, 0));
            }

            else{
                board.set(j, new Square("u", j));
            }

        }
        int cornerCounter = 1;
        int regCounter = 0;
        for (int i = 0; i < 36; i++) {
            if (i == 0) {
                board.set(0, new Square("start", i));
                cornerCounter += 1;
                if (Main.debugging) {
                    System.out.println("Sucessfully added start");
                }
            } else if (regCounter == 8) {
                if (cornerCounter == 2) {
                    board.set(i, new Square("jail", i));
                } else if (cornerCounter == 4) {
                    board.set(i, new Square("jail", i));
                }
                cornerCounter += 1;
                regCounter = 0;
            } else {

                regCounter += 1;
            }

        }
        return board;
    }

    private static ArrayList<Square> initSquares(ArrayList<Square> board) {
        return board;
    }

    private static void initCards() {

    }

}
