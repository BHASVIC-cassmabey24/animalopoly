public class Dice {
    public static int roll() {
        return (int) (Math.random() * 6) + 1;
    }
    
    public static int rollTwo() {
        return roll() + roll();
    }
}
