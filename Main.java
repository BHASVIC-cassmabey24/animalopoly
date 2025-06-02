import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // Init
        Init init = new Init();
        ArrayList<Square> board = Init.initBoard();
        int count = 0;
        for (Square square : board) {
            int tmpIndex = square.getIndex();
            System.out.println("count " + count + " | " + tmpIndex + ": " + square.getSquareName());
            count += 1;
        }
    }



}
