public class Utility extends Square {
    private static int index;
    private String squareName;
    public Utility(String squareName, boolean isStart) {
        super(squareName, index);
        this.squareName = squareName;
    }

}
