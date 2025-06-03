
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public int currentSquare;
    private int money;
    private boolean missGo;
    private String symbol;
    public String name;

    public Player(String symbol, String name) {
        this.symbol = symbol;
        this.money = 1500;
        this.missGo = false;
        this.currentSquare = 0;
        this.name = name;
    }

    public void Roll(ArrayList<Square> board, ArrayList<Player> players, ArrayList<Card> cards) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        if (missGo == false) {
            int doublecount = 0;
            boolean ondouble = true;
            while (ondouble == true) {
                int d1 = r.nextInt(7);
                int d2 = r.nextInt(7);
                if (d1 == d2) {
                    doublecount++;
                }
                if (doublecount >= 3) {
                    currentSquare = 10;
                    missGo = true;
                    break;
                } else {

                    int rollTotal = d1 + d2; //total squares moved
                    currentSquare = rollTotal + currentSquare;
                    if (currentSquare > 39) {
                        currentSquare = currentSquare - 40;
                        money = money + 200;
                    }
                    if (currentSquare == 27) {
                        currentSquare = 10;
                        missGo = true;
                    } else {

                        if ((board.get(currentSquare)).isAnimal()) { //checking if square is animal
                            Animal animal = (Animal) board.get(currentSquare); // setting variable a to the animal landed on
                            if ((animal.getOwner() == null)) { //checking if there is no owner and letting you buy it
                                System.out.println("Would you like to buy this animal?");
                                boolean valid = false;
                                while (valid == false) { // validation for the choice of buying it
                                    String choice = scanner.nextLine();
                                    //System.out.println("The price is", animal.getPrice(), "Enter y/n");
                                    if (choice == "y") {
                                        String aName = scanner.nextLine();
                                        System.out.println("Please enter the name of the animal : ");
                                        // animal.buy(name, aName);
                                        valid = true;
                                    } else if (choice == "n") {
                                        valid = true;
                                    }
                                }
                            } else { //renting the player if this is not there tile

                                money = money - animal.getRent();
                                String Owner = animal.getOwner();
                                Player aOwner = null;
                                for (int i = 0; i < players.size(); i++) {
                                    if (players.get(i).name.equals(Owner)) {
                                        aOwner = players.get(i);
                                    }
                                }
                                aOwner.setMoney(aOwner.getMoney() + animal.getRent());
                            }

                        } else if (currentSquare == 0) {
                            money = money + 200;
                        } else if (board.get(currentSquare).isChance()) {

                            int Rcard = r.nextInt(19);
                            Card Chance = cards.get(Rcard);
                            Chance.ability(this);

                        }
                    }
                }

                    //allowing to increase levels of pets
                    ArrayList<Animal> portfolio = new ArrayList<Animal>();
                    for (int i = 0; i < 40; i++) {

                        if (board.get(currentSquare).isAnimal()) {
                            Animal tempAnimal = (Animal) board.get(currentSquare);
                            portfolio.add(tempAnimal);
                        }

                    }
                    int[] rarity = new int[8];
                    for (int i = 0; i < portfolio.size(); i++) {
                        Animal tempA = portfolio.get(i);
                        rarity[tempA.getRarity()] = rarity[tempA.getRarity()] + 1;

                    }
                    for (int i = 0; i < 8; i++) {
                        if ((i == 0 || i == 7) && rarity[i] == 4) {
                            System.out.println("Would you like to an animal in rarity " + i);
                            boolean valid = false;
                            ArrayList<Animal> set = new ArrayList<Animal>(); //creating the set for the owner to choose with animal to upgrade
                            for (int j = 0; j < portfolio.size(); j++) {
                                if (portfolio.get(j).isAnimal()) {
                                    Animal tempAnimal = portfolio.get(j);
                                    if (tempAnimal.getRarity() == rarity[i]) {
                                        set.add(tempAnimal);
                                    }
                                }

                            }
                            System.out.println("The animals you can choose between are: ");
                            for (int p = 0; p < set.size(); p++) {
                                System.out.println(set.get(p).getName());
                            }
                            while (valid == false) { // validation for the choice of upgrading it
                                String Achoice = scanner.nextLine();
                                System.out.println("Enter an animal name");
                                for (int j = 0; j < set.size(); j++) {
                                    Animal tempAnimal = set.get(j);
                                    if (Achoice == tempAnimal.getName()) {
                                        if (tempAnimal.getlevel() <= 4) {
                                            String choice = scanner.nextLine();
                                            System.out.println("The price is "+toString(tempAnimal.getUprice())+" Enter y/n");
                                            if (choice == "y") {
                                                tempAnimal.upgrade();
                                                valid = true;
                                            } else if (choice == "n") {
                                                valid = true;
                                            }
                                        }
                                    }

                                }
                            }
                        }

                    }


                }

            }

        }

        public String toString (int value){
        return String.valueOf(value);
        }
        public void Buy () {
        }

        public void morgage () {
        }

        public void setMoney ( int money){
            this.money = money;
        }

        public int getMoney () {
            return this.money;
        }

        public boolean checkLoss () {

            if (money <= 0) {

                return true;

            } else {
                return false;
            }

        }

    public void setMissGo(boolean missGo) {
        this.missGo = missGo;
    }

    public void setCurrentSquare(int currentSquare) {
        this.currentSquare = currentSquare;
    }

    public String getSymbol(){return symbol;}

        public String getName(){return name;}

    public int getCurrentSquare(){return currentSquare;}
    }


