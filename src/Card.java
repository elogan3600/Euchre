import java.util.ArrayList;

public class Card {
    private int value = 0;
    private int actualValue = 0;
    private String suit = "spades";
    private String face = "grjieo";
    private static String trump = "";
    private static String opposite = "";

    public Card(int actualValue, String suit) { //ActualValue is the number that appears on the card
        this.value = actualValue;
        this.actualValue = this.value;
        this.suit = suit;
        if (isTrump(suit) == true) {
            this.value += 6;
        }
    }
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
        if (face.equals("jack")) {
            this.value = 11;
        }
        else if (face.equals("queen")) {
            this.value = 12;
        }
        else if (face.equals("king")) {
            this.value = 13;
        }
        else if (face.equals("ace")){
            this.value = 14;
        }


    }
    public static void trumpSuit(String suit) {
        trump = suit;
        if (trump.equals("spades")) {
            opposite = "clubs";
        }
        if (trump.equals("clubs")) {
            opposite = "spades";
        }
        if (trump.equals("hearts")) {
            opposite = "diamonds";
        }
        if (trump.equals("diamonds")) {
            opposite = "hearts";
        }
    }
    public static boolean isTrump(String suit) {
        if (trump.equals(suit)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setTrump(Card card) {
        if (card.getValue() <= 10 || (!(card.getFace().equals("grjieo"))) && !(card.getFace().equals("jack"))) {
            this.value += 6;
        }
        else if (card.getFace().equals("jack") && isTrump(card.getSuit())) {
            this.value += 10;
        }
        else {
            this.value += 9;
        }

    }
    public int getValue() {
        return value;
    }
    public int getActualValue() {
        return actualValue;
    }
    public String getTrump() {
        return trump;
    }
    public void addValue(int value) {
        this.value += value;
    }
    public static String print(Card card) {
        if (card.getActualValue() != 0) {
            return "The " + card.getActualValue() + " of " + card.getSuit();
        }
        else {
            return "The " + card.getFace() + " of " + card.getSuit();
        }
    }

    public static void addTrump(ArrayList<Card> deck) {
        for (int x = 0; x < deck.size(); x++) {
            if (isTrump(deck.get(x).getSuit()) == true) {
                if (!(deck.get(x).getFace().equals("jack"))) {
                    deck.get(x).addValue(6);
                }
                else if (deck.get(x).getFace().equals("jack")) {
                    deck.get(x).addValue(10);
                }
            }
            else if (deck.get(x).getSuit().equals(opposite) && deck.get(x).getFace().equals("jack")) {
                deck.get(x).addValue(9);
            }
        }
    }

    public String getSuit() {
        return suit;
    }
    public String getFace() {
        return face;
    }
}
