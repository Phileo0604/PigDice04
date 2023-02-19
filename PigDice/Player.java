package PigDice;

public class Player {
    private int turn;
    private int playerNo;
    private int totalPoints;
    private int diceRoll;
    Player(){
        this.turn = 1;
        this.playerNo = 1;
        this.totalPoints = 0;
        this.diceRoll = 1;
    }
    Player(int turn, int playerNo){
        this.turn=turn;
        this.playerNo = playerNo;
    }


    public int getTurn() {
        return turn;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    public int getTotalPoints() {
        return totalPoints;
    }

    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }
    public int getDiceRoll() {
        return diceRoll;
    }
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void addPoints(){
        if (diceRoll > 1){
            setTotalPoints(getDiceRoll()+getTotalPoints());
        }
    }
}
