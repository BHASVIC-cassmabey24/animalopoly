import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public int currentSquare;
    private int money;
    private boolean missGo;
    private char symbol;
    public String name;

    public void Roll(ArrayList<Square> board, ArrayList<Player> players) {
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
                if (doublecount > 3) {
                    currentSquare = 10;
                    missGo = true;
                    break;
                } else {

                    int rollTotal = d1 + d2; //total squares moved
                    currentSquare = rollTotal + currentSquare;

                    if ((board.get(currentSquare)).isAnimal()) { //checking if square is animal
                        Animal animal = (Animal) board.get(currentSquare); // setting variable a to the animal landed on
                        if ((animal.getOwner() == null)) { //checking if there is no owner and letting you buy it
                            System.out.println("Would you like to buy this animal?");
                            boolean valid = false;
                            while (valid == false) { // validation for the choice of buying it
                                String choice = scanner.nextLine();
                                System.out.println("The price is", animal.getPrice(), "Enter y/n");
                                if (choice == "y") {
                                    String aName = scanner.nextLine();
                                    System.out.println("Please enter the name of the animal : ");
                                    animal.buy(name, aName);
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

                    }
                    //allowing to increase levels of pets
                    ArrayList<Animal> portfolio = new ArrayList<Animal>();
                    for (int i=0;i<40;i++){

                        if (board.get(currentSquare).isAnimal()) {
                            Animal tempAnimal = (Animal) board.get(currentSquare);
                            portfolio.add(tempAnimal);
                        }

                    }
                    for (int i = 0; i < portfolio.size(); i++) {
                        Animal tempA=portfolio.get(i);
                    }

                }


            }

        }


    }

    public void Buy() {
    }

    public void morgage() {
    }

    public void constructor(char Symbol, String name) {
        this.symbol = Symbol;
        this.money = 1500;
        this.missGo = false;
        this.currentSquare = 0;
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public boolean checkLoss() {

        if (money <= 0){

            return true;

        }
        else {return false;}

    }
}