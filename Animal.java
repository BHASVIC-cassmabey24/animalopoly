import java.util.ArrayList;
import java.util.Objects;

public class Animal {
    private String owner;
    private int rarity;
    private int level; // starts at 0
    private int level0Rent;
    private int level1Rent;
    private int level2Rent;
    private int level3Rent;
    private int level4Rent;
    private int level5Rent;
    private int totalSpent;
    private boolean fullSet;
    private ArrayList<Square> arr;


    public void construct(int rarity, String owner, int level, boolean fullSet, int boughtFor) {
        this.rarity = rarity;
        this.owner = owner;
        this.level = level;
        this.fullSet = fullSet;
        this.totalSpent += boughtFor;

    }

    public int getRarity() {
        return rarity;
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

    public void buy(int rarity, String owner, ArrayList<Square> arr) {
        this.rarity = rarity;
        this.owner = owner;
        this.level = 0;
        // need to do levels of rent
        this.arr = arr;
    }

    public int getMortgageCost() {
        return totalSpent;
    }

    public void upgrade(int upgradeCost) {
        totalSpent += upgradeCost;
        level += 1;
    }

    public boolean checkFullSet(ArrayList<Square> arr) {
        int animalCount = 0;
        int ownedCount = 0;
        for (Square s : arr) {
            if (s.checkRarity() == rarity) {
                animalCount += 1;
                if (Objects.equals(s.checkOwner(), owner)) { // this is not AI its intellij autofill being wierd recoomending
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
}
