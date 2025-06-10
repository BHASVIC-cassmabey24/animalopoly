import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static boolean debugging = false;
    public static int amountOfPlayers = 0;
    public static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Square> board;
    private static final Scanner scanner = new Scanner(System.in);

    private static int getAmountOfPlayers() {
        String tempInput = "";
        boolean correctAmountOfPlayers = false;
        while (!correctAmountOfPlayers) {
            System.out.println("Please enter the amount of players playing (2-4): ");
            tempInput = scanner.nextLine();
            if (Validation.isInteger(tempInput)) {
                if (Integer.parseInt(tempInput) <= 4 && Integer.parseInt(tempInput) >= 2) {
                    correctAmountOfPlayers = true;
                } else {
                    System.out.println("Are you blind or just stupid. 2-4");
                }
            } else {
                System.out.println("Please enter a number between 2 and 4 inclusive.");
            }


        }
        return Integer.parseInt(tempInput);
    }

    private static void getPlayersInfo(int amountOfPlayers) {
        boolean gotName = false;
        String name = "";
        boolean gotSymbol = false;
        String symbol = "";
        String tempInput = "";

        for (int i = 0; i < amountOfPlayers; i++) {
            while (!gotName || !gotSymbol) {
                System.out.println("----------------------");
                System.out.println("Player " + (i + 1));
                if (!gotName) {
                    System.out.println("Please enter your name: ");
                    tempInput = scanner.nextLine();
                    if (tempInput.length() > 2 && tempInput.length() <= 16 && !Validation.containsNumber(tempInput)) {
                        gotName = true;
                        name = tempInput;
                    } else {
                        System.out.println("name must be 3-16 characters and not contain numbers");
                    }
                } else if (!gotSymbol) {
                    System.out.println("Please enter a symbol from the following: ");
                    System.out.println("!, £, $, %, ^, &, *, (, ), <, >, ?, /, @, ;, :, [, ], {, }");
                    tempInput = scanner.nextLine();
                    if (tempInput.length() == 1 && Validation.containsSymbol(tempInput)) {
                        boolean dupeSymbol = false;
                        for (Player player : players) {
                            if (player.getSymbol().equals(tempInput)) {
                                System.out.println("This symbol is being used by " + player.getName());
                                dupeSymbol = true;
                                break;
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
                name = board.get(num1).getSquareName();


                // 12 chars
                leftchars = 12 - (5 + name.length());
                tempLine = "| "  // 2 chars
                        + name; // we dont know how many chars
                for (int j = 0; j < leftchars; j++) {
                    tempLine += " ";
                }
                line += tempLine + "|  "; // 3 extra char
            } else if (i == 9) {
                name = board.get(num2).getSquareName();


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

    private static void displayPlayerAssets(Player player) {
        System.out.println(player.getName() + "'s animals:");
        for (Square square : board) {
            if (square instanceof Animal) {
                Animal animal = (Animal) square;
                if (animal.getOwner() != null && animal.getOwner().equals(player.getName())) {
                    System.out.println(animal.getName() + " - Level: " + animal.getLevel() + ", Rarity: " + animal.getRarity());
                }
            }
        }
        System.out.println("Money: $" + player.getMoney());
    }

    private static void processSquare(Player player, Square square) {
        if (square instanceof Animal) {
            Animal animal = (Animal) square;
            if (animal.getOwner() == null) {
                System.out.println("would you like to buy " + animal.getName() + " for $" + animal.getPrice() + "? (y/n)");
                String input = scanner.nextLine();
                if (input.equals("y") && player.getMoney() >= animal.getPrice()) {
                    animal.buy(player.getName());
                    player.setMoney(player.getMoney() - animal.getPrice());
                    System.out.println("purchased " + animal.getName());
                }
            } else if (animal.getOwner().equals(player.getName())) {
                System.out.println("would you like to upgrade " + animal.getName() + " for $" + animal.getUprice() + "? (y/n)");
                String input = scanner.nextLine();
                while (input.equals("y") && player.getMoney() >= animal.getUprice() && animal.getLevel() < 5) {
                    animal.upgrade();
                    player.setMoney(player.getMoney() - animal.getUprice());
                    System.out.println("upgraded " + animal.getName() + " to level " + animal.getLevel());
                    if (animal.getLevel() < 5) {
                        System.out.println("upgrade again for $" + animal.getUprice() + "? (y/n)");
                        input = scanner.nextLine();
                    }
                }
            } else {
                int rent = animal.getRent();
                System.out.println("you must pay $" + rent + " to " + animal.getOwner());
                player.setMoney(player.getMoney() - rent);
                for (Player p : players) {
                    if (p.getName().equals(animal.getOwner())) {
                        p.setMoney(p.getMoney() + rent);
                    }
                }
            }
        } else if (square.getSquareName().equals("Chance")) {

            Card card = new Card("Chance", (int)(Math.random() * 20));
            int oldMoney = player.getMoney();
            int oldPosition = player.getCurrentSquare();
            boolean wasMissGo = player.isMissGo();
            
            card.ability(player);
            
            if (player.getMoney() != oldMoney) {
                if (player.getMoney() > oldMoney) {
                    System.out.println("chance card: gained $" + (player.getMoney() - oldMoney));
                } else {
                    System.out.println("chance card: lost $" + (oldMoney - player.getMoney()));
                }
            }
            if (player.getCurrentSquare() != oldPosition) {
                if (player.getCurrentSquare() == 9 && player.isMissGo()) {
                    System.out.println("chance card: go to jail!");
                } else if (player.getCurrentSquare() == 0) {
                    System.out.println("chance card: advance to go!");
                } else {
                    System.out.println("chance card: moved to " + board.get(player.getCurrentSquare()).getSquareName());
                }
            }

        }
    }

    private static void checkBankruptcy() {
        ArrayList<Player> bankruptPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getMoney() <= 0) {
                bankruptPlayers.add(player);
                for (Square square : board) {
                    if (square instanceof Animal) {
                        Animal animal = (Animal) square;
                        if (animal.getOwner() != null && animal.getOwner().equals(player.getName())) {
                            animal.buy(null);
                        }
                    }
                }
            }
        }
        players.removeAll(bankruptPlayers);
        if (!bankruptPlayers.isEmpty()) {
            System.out.println("players eliminated: ");
            for (Player player : bankruptPlayers) {
                System.out.println(player.getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        board = Init.initBoard();
        System.out.println("game initialised");
        amountOfPlayers = getAmountOfPlayers();
        getPlayersInfo(amountOfPlayers);

        while (players.size() > 1) {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                System.out.println("\n" + currentPlayer.getName() + "'s turn");
                drawBoard(board);
                displayPlayerAssets(currentPlayer);
                  System.out.println(currentPlayer.getName() + ", press enter to roll your first die");
                scanner.nextLine();
                int roll1 = Dice.roll();
                System.out.println("first die: " + roll1);
                
                System.out.println("press enter to roll your second die");
                scanner.nextLine();
                int roll2 = Dice.roll();
                System.out.println("second die: " + roll2);
                
                int totalRoll = roll1 + roll2;
                System.out.println("total roll: " + totalRoll);
                
                int newPosition = (currentPlayer.getCurrentSquare() + totalRoll) % 36;
                currentPlayer.setCurrentSquare(newPosition);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("landed on " + board.get(newPosition).getSquareName());
                TimeUnit.SECONDS.sleep(1);


                processSquare(currentPlayer, board.get(newPosition));

                checkBankruptcy();
                
                if (players.size() == 1) {
                    break;
                }
            }
        }
        
        if (players.size() == 1) {
            System.out.println("\nwinner: " + players.get(0).getName());
        }
        scanner.close();
    }
}
