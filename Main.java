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

    public static void drawBoard(ArrayList<Square> board) {
        // top row
        // first line
        String line = "";
        for (int i = 0; i < 10; i++) {
            line += " _________  ";
        }
        System.out.println(line);
        // second line
        line = "";
        for (int i = 0; i < 10; i++) {
            line += "| ";
            line += String.valueOf(i);
            line += "      |  ";

        }
        System.out.println(line);
        // third line. contains square name
        line = "";
        String name;
        String tempLine;
        int leftchars = 0;
        for (int i = 0; i < 10; i++) {
            name = board.get(i).getSquareName();


            // 12 chars
            leftchars = 12 - (5 + name.length());
            tempLine = "| "  // 2 chars
            + name; // we dont know how many chars
            for (int j = 0; j < leftchars; j++) {
                tempLine += " ";
            }
            line += tempLine + "|  "; // 3 extra char
            leftchars = 0;
            name = "";
        }
        System.out.println(line);
        // forth line
        line = ""; // 2 chars
        String playersOnSquare = "";
        leftchars = 0;
        for (int i = 0; i < 10; i++) {
            line += "| ";
            for (Player player : players) {
                if (player.getCurrentSquare() == i) {
                    playersOnSquare += player.getSymbol() + " ";
                }
            }
            leftchars = 12 - (5 + playersOnSquare.length());
            line += playersOnSquare;
            for (int j = 0; j < leftchars; j++) {
                line += " ";
            }
            line += "|  ";
            playersOnSquare = "";
            leftchars = 0;
        }
        System.out.println(line);
        // fifth line
        line = ""; // 2 chars
        for (int i = 0; i < 10; i++) {
            line += "----------  ";
        }

        System.out.println(line);

        createCornerBits(35, 10, board);
        createCornerBits(34, 11, board);
        createCornerBits(33, 12, board);
        createCornerBits(32, 13, board);
        createCornerBits(31, 14, board);
        createCornerBits(30, 15, board);
        createCornerBits(29, 16, board);
        createCornerBits(28, 17, board);


        line = "";
        for (int i = 0; i < 10; i++) {
            line += " _________  ";
        }
        System.out.println(line);
        // second line
        line = "";
        for (int i = 27; i > 17; i--) {
            //line += "|        |  ";
            line += "| ";
            line += String.valueOf(i);
            if (String.valueOf(i).length() == 1) {
                line += "      |  ";
            } else {
                line += "     |  ";
            }

        }
        System.out.println(line);
        // third line. contains square name
        line = "";

        leftchars = 0;
        for (int i = 27; i > 17; i--) {
            name = board.get(i).getSquareName();


            // 12 chars
            leftchars = 12 - (5 + name.length());
            tempLine = "| "  // 2 chars
                    + name; // we dont know how many chars
            for (int j = 0; j < leftchars; j++) {
                tempLine += " ";
            }
            line += tempLine + "|  "; // 3 extra char
            leftchars = 0;
            name = "";
        }
        System.out.println(line);
        // forth line
        line = ""; // 2 chars
        playersOnSquare = "";
        leftchars = 0;
        for (int i = 27; i > 17; i--) {
            line += "| ";
            for (Player player : players) {
                if (player.getCurrentSquare() == i) {
                    playersOnSquare += player.getSymbol() + " ";
                }
            }
            leftchars = 12 - (5 + playersOnSquare.length());
            line += playersOnSquare;
            for (int j = 0; j < leftchars; j++) {
                line += " ";
            }
            line += "|  ";
            playersOnSquare = "";
            leftchars = 0;
        }
        System.out.println(line);
        // fifth line
        line = ""; // 2 chars
        for (int i = 0; i < 10; i++) {
            line += "----------  ";
        }



    }


    public static void createCornerBits(int num1, int num2, ArrayList<Square> board) {

        // sixth line
        String line = "";
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                line += "----------  ";
            } else if (i == 9) {
                line += "----------  ";
            } else {
                line += "            ";
            }
        }
        System.out.println(line);

        // seventh line
        line = "";
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                //line += "|        |  ";
                line += "| ";
                line += String.valueOf(num1);
                if (String.valueOf(num1).length() == 1) {
                    line += "      |  ";
                } else {
                    line += "     |  ";
                }


            } else if (i == 9) {
                //line += "|        |  ";
                line += "| ";
                line += String.valueOf(num2);
                if (String.valueOf(num2).length() == 1) {
                    line += "      |  ";
                } else {
                    line += "     |  ";
                }
            } else {
                line += "            ";
            }
        }
        System.out.println(line);

        // eighth line
        line = "";
        String name = "";
        String tempLine = "";
        int leftchars = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                name = board.get(35).getSquareName();


                // 12 chars
                leftchars = 12 - (5 + name.length());
                tempLine = "| "  // 2 chars
                        + name; // we dont know how many chars
                for (int j = 0; j < leftchars; j++) {
                    tempLine += " ";
                }
                line += tempLine + "|  "; // 3 extra char
            } else if (i == 9) {
                name = board.get(10).getSquareName();


                // 12 chars
                leftchars = 12 - (5 + name.length());
                tempLine = "| "  // 2 chars
                        + name; // we dont know how many chars
                for (int j = 0; j < leftchars; j++) {
                    tempLine += " ";
                }
                line += tempLine + "|  "; // 3 extra char
            } else {
                line += "            ";
            }

            leftchars = 0;
            name = "";
        }
        System.out.println(line);

        line = ""; // 2 chars
        String playersOnSquare = "";
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                line += "| "; // 2 chars
                for (Player player : players) {
                    if (player.getCurrentSquare() == num1) {
                        playersOnSquare += player.getSymbol() + " ";
                    }
                }
                leftchars = 12 - (5 + playersOnSquare.length());
                line += playersOnSquare;
                for (int j = 0; j < leftchars; j++) {
                    line += " ";
                }
                line += "|  ";
            } else if (i == 9) {
                line += "| ";
                for (Player player : players) {
                    if (player.getCurrentSquare() == num2) {
                        playersOnSquare += player.getSymbol() + " ";
                    }
                }
                leftchars = 12 - (5 + playersOnSquare.length());
                line += playersOnSquare;
                for (int j = 0; j < leftchars; j++) {
                    line += " ";
                }
                line += "|  ";
            } else {
                line += "            ";
            }

            playersOnSquare = "";
        }
        System.out.println(line);

        line = "";
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                line += "----------  ";
            } else if (i == 9) {
                line += "----------  ";
            } else {
                line += "            ";
            }
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        // Init
        Init init = new Init();
        ArrayList<Square> board = Init.initBoard();

        //for (int i = 0; i < board.size(); i++) {
        //    System.out.println(board.get(i).toString());
        //}

        //amountOfPlayers = getAmountOfPlayers();
//
        //getPlayersInfo(amountOfPlayers);

        players.add(new Player("!", "CassidyOne"));
        players.add(new Player("$", "CassidyTwo"));
        System.out.println("Game Initialised");

        drawBoard(board);
    }



}
