import java.util.ArrayList;
import java.util.Random;

public class Player {
    public int currentSquare;
    private int money;
    private boolean missGo;
    private char symbol;
    public String name;
    public void Roll(ArrayList<Square> board){
        Random r= new Random();
        if (missGo==false){
        int doublecount=0;
        boolean ondouble=true;
        while (ondouble == true){
            int d1 = r.nextInt(7);
            int d2 = r.nextInt(7);
            if (d1==d2){
                doublecount++;
            }
            if (doublecount>3){
                currentSquare=10;
                missGo=true;
                break;
            }
            else{

                int rollTotal = d1+d2;
                currentSquare=rollTotal+currentSquare;
                if ((board.get(currentSquare)).isAnimal() == true){

                    //if ((board.get(currentSquare)).getOwner()==null){
                    //    System.out.println("would you like to buy");
                    //}

                }
            }





        }

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
