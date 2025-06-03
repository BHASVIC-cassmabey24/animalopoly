import java.util.ArrayList;
import java.util.Objects;

public class Animal extends Square {
    private String owner;
    private String name;
    private int rarity;
    private int level; // starts at 0
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
            case 0:
                this.price = 60;
                this.upgradeCost = 50;
                this.level0Rent = 4;
                this.level1Rent = 20;
                this.level2Rent = 60;
                this.level3Rent = 180;
                this.level4Rent = 320;
                this.level5Rent = 450;
                break;
            case 1:
                this.price = 100;
                this.upgradeCost = 50;
                this.level0Rent = 8;
                this.level1Rent = 40;
                this.level2Rent = 100;
                this.level3Rent = 300;
                this.level4Rent = 450;
                this.level5Rent = 600;
                break;
            case 2:
                this.price = 140;
                this.upgradeCost = 100;
                this.level0Rent = 12;
                this.level1Rent = 60;
                this.level2Rent = 180;
                this.level3Rent = 500;
                this.level4Rent = 700;
                this.level5Rent = 900;
                break;
            case 3:
                this.price = 180;
                this.upgradeCost = 100;
                this.level0Rent = 16;
                this.level1Rent = 80;
                this.level2Rent = 220;
                this.level3Rent = 600;
                this.level4Rent = 800;
                this.level5Rent = 1000;
                break;
            case 4:
                this.price = 220;
                this.upgradeCost = 150;
                this.level0Rent = 20;
                this.level1Rent = 100;
                this.level2Rent = 300;
                this.level3Rent = 750;
                this.level4Rent = 925;
                this.level5Rent = 1100;
                break;
            case 5:
                this.price = 260;
                this.upgradeCost = 150;
                this.level0Rent = 24;
                this.level1Rent = 120;
                this.level2Rent = 360;
                this.level3Rent = 850;
                this.level4Rent = 1025;
                this.level5Rent = 1200;
                break;
            case 6:
                this.price = 300;
                this.upgradeCost = 200;
                this.level0Rent = 28;
                this.level1Rent = 150;
                this.level2Rent = 450;
                this.level3Rent = 1000;
                this.level4Rent = 1200;
                this.level5Rent = 1400;
                break;
            case 7:
                this.price = 400;
                this.upgradeCost = 200;
                this.level0Rent = 50;
                this.level1Rent = 200;
                this.level2Rent = 600;
                this.level3Rent = 1400;
                this.level4Rent = 1700;
                this.level5Rent = 2000;
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
                if (Objects.equals(getOwner(), owner)) { // this is not AI its intellij autofill being wierd recoomending
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

    @Override // idk google told me to do that https://www.geeksforgeeks.org/overriding-in-java/
    public boolean isAnimal() {
        return true;
    }

}
