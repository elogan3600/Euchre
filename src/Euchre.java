import java.util.ArrayList;
import java.util.Scanner;

public class Euchre {
    private static ArrayList<Card> deck = new ArrayList<Card>();
    private static String trump;
    private static Player p1 = new Player("P1",0);
    private static Player p2 = new Player("P2",0);
    private static Player p3 = new Player("P3",0);
    private static Player p4 = new Player("P4",0);
    private static Player[] players = {
            new Player("P1",0),
            new Player("P2", 1),
            new Player("P3", 2),
            new Player("P4", 3)
    };
    static Scanner myScanner = new Scanner(System.in);


    public static void main(String[] args) {
        game();
    }

    public static void game() {
        //Pre-game
        String suit = "spades";
        for (int x = 2; x <= 5; x++) {
            if (x == 3) {
                suit = "clubs";
            }
            if (x == 4) {
                suit = "hearts";
            }
            if (x == 5) {
                suit = "diamonds";
            }
            for (int y = 9; y <= 14; y++) {
                if (y <= 10) {
                    deck.add(new Card(y, suit));
                }
                else if (y == 11) {
                    deck.add(new Card("jack", suit));
                }
                else if (y == 12) {
                    deck.add(new Card("queen", suit));
                }
                else if (y == 13) {
                    deck.add(new Card("king", suit));
                }
                else if (y == 14) {
                    deck.add(new Card("ace", suit));
                }
            }
        }
        shuffle();
        Card.trumpSuit(deck.get(0).getSuit());
        System.out.println(Card.print(deck.get(0)) + " is trump");
        Card.addTrump(deck);
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(Card.print(deck.get(i)));
        }
        System.out.println();
        System.out.println("P1 hand:");
        p1.addHand(deck);
        System.out.println();
        System.out.println("P2 hand:");
        p2.addHand(deck);
        System.out.println();
        System.out.println("P3 hand:");
        p3.addHand(deck);
        System.out.println();
        System.out.println("P4 hand:");
        p4.addHand(deck);

        //Calling trump starts
        System.out.println();
        String answer;
        int start = -1;
        while (start == -1) {
            System.out.println("Which player is the dealer?");
            answer = myScanner.next();
            if (answer.equalsIgnoreCase("p1")) {
                start = 0;
                break;
            }
            else if (answer.equalsIgnoreCase("p2")) {
                start = 1;
                break;
            }
            else if (answer.equalsIgnoreCase("p3")) {
                start = 2;
                break;
            }
            else if (answer.equalsIgnoreCase("p4")) {
                start = 3;
                break;
            }
        }
        boolean called = false;
        for (int x = 0; x < players.length; x++) {
            if (start == 4) {
                start = 0;
            }
            System.out.println("Does " + players[start].getName() + " want to call?");
            answer = myScanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                players[start].addCard(deck.get(0));
                called = true;
                break;
            }
            else if (answer.equalsIgnoreCase("no")) {
                start++;
            }
            else {
                System.out.println("Not a valid answer");
                x--;
            }
        }
        if (called == false) {
            System.out.println(Card.print(deck.get(0)) + " is flipped down");
            for (int x = 0; x < 4; x++) {

            }
        }
    }
    public static void shuffle() {
        for (int x = 0; x < 1500; x++) {
            Card temp = deck.remove((int) (Math.random() * 24));
            deck.add(0, temp);
        }
    }
}
