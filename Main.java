import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // Init
        Init init = new Init();
        ArrayList<Square> board = Init.initBoard();

        for (Square square : board) {
            System.out.println(square);
        }
    }



}
