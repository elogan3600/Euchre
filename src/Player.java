import java.util.ArrayList;

public class Player {
    private int points;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int amountTaken;
    private int turnNum;
    private String name;

    //Constructors
    public Player(String name, int turnNum) {
        this.name = name;
        this.points = 0;
        this.turnNum = turnNum;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getTurnNum() {
        return turnNum;
    }
    public int getHandSize() {
        return hand.size();
    }
    /* Gets the number of the next turn
       so if currentTurnNum equals 1
       it will return 2. If
       currentTurnNum equals 4 it will
       return 0
     */
    public int getNextTurnNum(Player[] players, int currentTurnNum, boolean goneAlone) {
        if (currentTurnNum < 4 && !goneAlone) {
            return currentTurnNum + 1;
        }
        else if (currentTurnNum == 4 && !goneAlone) {
            return 0;
        }
        else {
            for (int x = 0; x < players.length; x++) {
                if (players[x].getTurnNum() == currentTurnNum + 1) {
                    return players[x].getTurnNum();
                }
            }
        }
        return -1;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }
    //Methods
    public void addHand(ArrayList<Card> deck) {
        for (int x = 1; x < 6; x++) {
            this.hand.add(deck.remove(1));
        }
    }
    public Card removeHand(int index) {
        Card temp = this.hand.remove(index);
        return temp;
    }
    public void printHand() {
        for (int x = 0; x < hand.size(); x++) {
            System.out.println((x + 1) + ". " + Card.print(hand.get(x)));
        }
    }
    public void addCard(Card card) {
        hand.add(card);
    }
}
