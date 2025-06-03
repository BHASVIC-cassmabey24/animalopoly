public class Card extends Square {
    private int index;
    private String name;

    public Card(String squareName, int index) {
        super(squareName, index);
        this.index = index;
        this.name = squareName;

    }

    public void ability(Player player) {
        switch (this.index) {

            case 0:
            case 1:
                player.setCurrentSquare(9);
                player.setMissGo(true);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                player.setMoney(player.getMoney() - 150);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                player.setMoney(player.getMoney() + 150);
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                player.setMoney(player.getMoney() + 200);
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                player.setMoney(player.getMoney() - 200);
                break;
            case 18:
            case 19:
                player.setCurrentSquare(0);
                player.setMoney(player.getMoney()+400);;
        }
    }

    @Override
    public boolean isChance() {
        return true;
    }
}
