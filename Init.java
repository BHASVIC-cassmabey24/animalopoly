import java.util.ArrayList;

public class Init {
    static ArrayList<Square> initBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        for (int j = 0; j < 36; j++) {
            board.add(j, new Square("empty", j));
        }
        
        // brown
        board.set(1, new Animal("Mouse", 0, 0));
        board.set(3, new Animal("Rat", 0, 0));
        
        // light blue
        board.set(5, new Animal("Chicken", 1, 0));
        board.set(6, new Animal("Vulture", 1, 0));
        board.set(8, new Animal("Eagle", 1, 0));
        
        // pink
        board.set(10, new Animal("Donkey", 2, 0));
        board.set(11, new Animal("Mule", 2, 0));
        board.set(12, new Animal("Horse", 2, 0));
        
        // orange
        board.set(14, new Animal("Wombat", 3, 0));
        board.set(15, new Animal("Koala", 3, 0));
        board.set(17, new Animal("Kangaroo", 3, 0));
        
        // red
        board.set(19, new Animal("Shark", 4, 0));
        board.set(21, new Animal("Fish", 4, 0));
        board.set(22, new Animal("Whale", 4, 0));
        
        // yellow
        board.set(24, new Animal("Jaguar", 5, 0));
        board.set(25, new Animal("Tiger", 5, 0));
        board.set(26, new Animal("Lion", 5, 0));
        
        // green
        board.set(28, new Animal("Bear", 6, 0));
        board.set(32, new Animal("Monkey", 6, 0));
        board.set(34, new Animal("Snail", 6, 0));
        
        // blue
        board.set(35, new Animal("Allig", 7, 0));
        board.set(35, new Animal("Crock", 7, 0));

        // corners
        board.set(0, new Square("Start", 0));
        board.set(9, new Square("Jail", 9));
        board.set(18, new Square("Chance", 18));
        board.set(27, new Square("Jail", 27));
        
        // chances

        board.set(2, new Card("Chance", 0));
        board.set(4, new Card("Chance", 1));
        board.set(13, new Card("Chance", 2));
        board.set(16, new Card("Chance", 3));
        board.set(20, new Card("Chance", 4));
        board.set(23, new Card("Chance", 5));
        board.set(29, new Card("Chance", 6));
        board.set(30, new Card("Chance", 7));
        board.set(31, new Card("Chance", 8));
        board.set(33, new Card("Chance", 9));
        

        return board;
    }

    private static ArrayList<Square> initSquares(ArrayList<Square> board) {
        return board;
    }

    private static void initCards() {

    }

}
