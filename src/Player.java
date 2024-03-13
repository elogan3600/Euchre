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
    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }
    //Methods
    public void setDealer(Player player) {

    }
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
