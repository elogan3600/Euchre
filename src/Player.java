import java.util.ArrayList;

public class Player {
    private int points;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int amountTaken;
    private int turnNum;
    private String name;

    //Constructors
    public Player(String name, int turnNum) {
        this.points = 0;
        this.turnNum = turnNum;
    }

    //Getters
    public String getName() {
        return name;
    }
    //Methods
    public void setDealer(Player player) {

    }
    public void addHand(ArrayList<Card> deck) {
        for (int x = 1; x < 6; x++) {
            System.out.println(Card.print(deck.get(1)));
            hand.add(deck.remove(1));
        }
    }
    public void addCard(Card card) {
        hand.add(card);
    }
}
