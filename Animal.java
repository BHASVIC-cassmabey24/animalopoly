import java.util.ArrayList;
import java.util.Objects;

public class Animal extends Square {
    private String owner;
    private String name;
    private int rarity;
    private int level;
    private int level0Rent;
    private int level1Rent;
    private int level2Rent;
    private int level3Rent;
    private int level4Rent;
    private int level5Rent;
    private int totalSpent;
    private int price;
    private boolean fullSet;
    private ArrayList<Square> arr;
    private static int index;
    private int upgradeCost;

    public Animal(String squareName, int rarity, int level) {
        super(squareName, index);
        this.rarity = rarity;
        this.owner = null;
        this.level = level;
        switch (rarity) {
            case 0: // Brown
                this.price = 60;
                this.upgradeCost = 50;
                this.level0Rent = 2;
                this.level1Rent = 10;
                this.level2Rent = 30;
                this.level3Rent = 90;
                this.level4Rent = 160;
                this.level5Rent = 250;
                break;
            case 1: // Light blue
                this.price = 100;
                this.upgradeCost = 50;
                this.level0Rent = 6;
                this.level1Rent = 30;
                this.level2Rent = 90;
                this.level3Rent = 270;
                this.level4Rent = 400;
                this.level5Rent = 550;
                break;
            case 2: // Pink
                this.price = 140;
                this.upgradeCost = 100;
                this.level0Rent = 10;
                this.level1Rent = 50;
                this.level2Rent = 150;
                this.level3Rent = 450;
                this.level4Rent = 625;
                this.level5Rent = 750;
                break;
            case 3: // Orange
                this.price = 180;
                this.upgradeCost = 100;
                this.level0Rent = 14;
                this.level1Rent = 70;
                this.level2Rent = 200;
                this.level3Rent = 550;
                this.level4Rent = 750;
                this.level5Rent = 950;
                break;
            case 4: // Red
                this.price = 220;
                this.upgradeCost = 150;
                this.level0Rent = 18;
                this.level1Rent = 90;
                this.level2Rent = 250;
                this.level3Rent = 700;
                this.level4Rent = 875;
                this.level5Rent = 1050;
                break;
            case 5: // Yellow
                this.price = 260;
                this.upgradeCost = 150;
                this.level0Rent = 22;
                this.level1Rent = 110;
                this.level2Rent = 330;
                this.level3Rent = 800;
                this.level4Rent = 975;
                this.level5Rent = 1150;
                break;
            case 6: // Green
                this.price = 300;
                this.upgradeCost = 200;
                this.level0Rent = 26;
                this.level1Rent = 130;
                this.level2Rent = 390;
                this.level3Rent = 900;
                this.level4Rent = 1100;
                this.level5Rent = 1275;
                break;
            case 7: // Blue
                this.price = rarity == 7 ? 350 : 400;
                this.upgradeCost = 200;
                this.level0Rent = rarity == 7 ? 35 : 50;
                this.level1Rent = rarity == 7 ? 175 : 200;
                this.level2Rent = rarity == 7 ? 500 : 600;
                this.level3Rent = rarity == 7 ? 1100 : 1400;
                this.level4Rent = rarity == 7 ? 1300 : 1700;
                this.level5Rent = rarity == 7 ? 1500 : 2000;
                break;
        }



        this.name = squareName;

    }

    public int getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getLevel() {
        return level;
    }

    public int getRent() {
        switch (level) {
            case 0:
                return level0Rent;
            case 1:
                return level1Rent;
            case 2:
                return level2Rent;
            case 3:
                return level3Rent;
            case 4:
                return level4Rent;
            case 5:
                return level5Rent;
            default:
                System.out.println("Invalid level");
                break;
        }

        return 0;
    }

    public boolean isFullSet() {
        return fullSet;
    }

    public void buy(String owner) {
        this.rarity = rarity;
        this.owner = owner;
        this.level = 0;
        // need to do levels of rent
        this.arr = arr;
    }

    public int getMortgageCost() {
        return (int) (totalSpent * 0.75);
    }

    public void upgrade() {
        totalSpent += upgradeCost;
        level += 1;
    }

    public boolean checkFullSet(ArrayList<Square> arr) {
        int animalCount = 0;
        int ownedCount = 0;
        for (Square s : arr) {
            if (getRarity() == rarity) {
                animalCount += 1;
                if (Objects.equals(getOwner(), owner)) { 
                    ownedCount += 1;
                }
            }
        }

        if (ownedCount == animalCount) {
            return true;
        } else {
            return false;
        }

    }

    public int getlevel() {

        return level;
    }

    public int getUprice() {
        return upgradeCost;
    }

    public int getPrice() {
        return price;
    }

    @Override // idk google told me to do that https://www.geeksforgeeks.org/overriding-in-java/
    public boolean isAnimal() {
        return true;
    }

}
