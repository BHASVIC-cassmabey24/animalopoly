public class Square {
    private String squareName;
    private int index;


    public Square(String squareName, int index) {
        this.squareName = squareName;
        this.index = index;
    }

    public boolean isAnimal() {
        return false;
    }

    public String getSquareName() {
        return squareName;
    }

    public int getIndex() {
        return index;
    }

}
