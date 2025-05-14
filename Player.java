import java.util.ArrayList;

public class Player {
    public int currentSquare;
    private int money;
    private boolean missGo;
    private char symbol;
    public String name;
    public void Roll(Dice dice, ArrayList<Square> board){
        if (missGo==false){
        this.currentSquare=dice.roll(currentSquare,this); //this moves the player the correct number of squares

        }


    }
    public void Buy(){}
    public void morgage(){}
    public void constructor(char Symbol,String name){
        this.symbol = Symbol;
        this.money = 1500;
        this.missGo = false;
        this.currentSquare = 0;
        this.name = name;
    }
    public int getMoney(){return money;}
}
