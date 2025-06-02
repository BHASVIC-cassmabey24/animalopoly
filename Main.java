import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean debugging = false;
    public static int amountOfPlayers = 0;
    public static ArrayList<Player> players = new ArrayList<>();

    private static int getAmountOfPlayers() {
        String tempInput = "";
        boolean correctAmountOfPlayers = false;
        Scanner scanner = new Scanner(System.in);
        while (!correctAmountOfPlayers) {
            System.out.println("Please enter the amount of players playing (1-4): ");
            tempInput = scanner.nextLine();
            if (Validation.isInteger(tempInput)) {
                if (Integer.parseInt(tempInput) <= 4 && Integer.parseInt(tempInput) >= 1) {
                    correctAmountOfPlayers = true;
                } else {
                    System.out.println("Are you blind or just stupid. 1-4");
                }
            } else {
                System.out.println("Please enter a number between 0 and 4 inclusive.");
            }


        }
        return Integer.parseInt(tempInput);
    }

    private static void getPlayersInfo(int amountOfPlayers) {
        boolean gotName = false;
        String name = "";
        boolean gotSymbol = false;
        String symbol = "";
        Scanner scanner = new Scanner(System.in);
        String tempInput = "";

        for (int i = 0; i < amountOfPlayers; i++) {
            while (!gotName || !gotSymbol) {
                System.out.println("----------------------");
                System.out.println("Player " + (i + 1));
                if (!gotName) {
                    System.out.println("Please enter your name: ");
                    tempInput = scanner.nextLine();
                    if (tempInput.length() > 2 && tempInput.length() <= 16 && !Validation.containsNumber(tempInput)) { // CHECKS ITS NOT > 2 AND < 16 AND DOESNT CONTAIN AN INT
                        gotName = true;
                        name = tempInput;
                    }
                } else if (!gotSymbol) {
                    System.out.println("Please enter a symbol from the following: ");
                    System.out.println("!, £, $, %, ^, &, *, (, ), <, >, ?, /, @, ;, :, [, ], {, }");
                    tempInput = scanner.nextLine();
                    if (tempInput.length() == 1 && Validation.containsSymbol(tempInput)) { //CHECKS THAT ITS 1 CHARACTAR LONG AND CONTAINS A SYMBOL
                        boolean dupeSymbol = false;
                        for (Player player : players) {
                            if (player.getSymbol() == tempInput) {
                                System.out.println("This symbol is being used by " + player.getName());
                                dupeSymbol = true;
                            }
                        }
                        if (!dupeSymbol) {
                            symbol = tempInput;
                            players.add(new Player(symbol, name));
                            System.out.println("Player " + name + " has been added to the game.");
                            gotSymbol = true;
                        }
                    } else {
                        System.out.println("Please make sure that what you enter is a Symbol from the list and nothing else.");
                    }
                }
            }
            gotName = false;
            gotSymbol = false;
            name = "";
            symbol = "";
        }
    }

    public static void main(String[] args) {
        // Init
        Init init = new Init();
        ArrayList<Square> board = Init.initBoard();

        amountOfPlayers = getAmountOfPlayers();

        getPlayersInfo(amountOfPlayers);
    }



}
