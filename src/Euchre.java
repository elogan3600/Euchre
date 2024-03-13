import java.util.ArrayList;
import java.util.Scanner;

public class Euchre {
    private static ArrayList<Card> deck = new ArrayList<Card>();
    private static String trump;
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
        System.out.println(Card.print(deck.get(0)) + " is trump");
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(Card.print(deck.get(i)));
        }
        System.out.println();
        System.out.println("P1 hand:");
        players[0].addHand(deck);
        players[0].printHand();
        System.out.println();
        System.out.println("P2 hand:");
        players[1].addHand(deck);
        players[1].printHand();
        System.out.println();
        System.out.println("P3 hand:");
        players[2].addHand(deck);
        players[2].printHand();
        System.out.println();
        System.out.println("P4 hand:");
        players[3].addHand(deck);
        players[3].printHand();

        //Calling trump starts
        System.out.println();
        String answer;
        int intDealer = -1;
        int caller = -1;
        while (caller == -1) {
            System.out.println("Which player is the dealer?");
            String dealer = myScanner.next();
            if (dealer.equalsIgnoreCase("p1")) {
                caller = 1;
                intDealer = 0;
                break;
            }
            else if (dealer.equalsIgnoreCase("p2")) {
                caller = 2;
                intDealer = 1;
                break;
            }
            else if (dealer.equalsIgnoreCase("p3")) {
                caller = 3;
                intDealer = 2;
                break;
            }
            else if (dealer.equalsIgnoreCase("p4")) {
                caller = 0;
                intDealer = 3;
                break;
            }
            else {
                System.out.println("Not a valid option");
            }
        }
        boolean called = false;
        int start = caller;
        int temp = caller;
        for (int x = 0; x < players.length; x++) {
            if (caller == 4) {
                caller = 0;
            }
            System.out.println("Does " + players[caller].getName() + " want to call?");
            answer = myScanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                Card.trumpSuit(deck.get(0).getSuit());
                Card.addTrump(deck);
                players[intDealer].addCard(deck.remove(0));
                System.out.println(players[intDealer].getName() + " picks up " + Card.print(deck.get(0)).toLowerCase());
                System.out.println("Which card would " + players[intDealer].getName() + " like to discard?");
                players[intDealer].printHand();
                int discard = myScanner.nextInt();
                if (discard > 0 && discard < 7) {
                    System.out.println(Card.print(players[intDealer].removeHand(discard)) + " is discarded");
                    players[intDealer].removeHand(discard - 1);
                }
                else if (discard >= 7) {
                    System.out.println("You don't have that many cards");
                }
                else if (discard <= 0) {
                    System.out.println("You don't have that few cards");
                }
                called = true;

                break;
            }
            else if (answer.equalsIgnoreCase("no")) {
                caller++;
            }
            else {
                System.out.println("Not a valid answer");
                x--;
            }
        }
        if (called == false) {
            System.out.println(Card.print(deck.get(0)) + " is flipped down");
            for (int x = 0; x < 4; x++) {
                if (temp == 4) {
                    temp = 0;
                }
                System.out.println("Does " + players[temp].getName() + " want to choose trump?");
                answer = myScanner.next();
                x = 0;
                if (answer.equalsIgnoreCase("yes")) {
                    while (x != 1) {
                        System.out.println("Which suit does " + players[temp].getName() + " want to be trump?");
                        answer = myScanner.next();
                        if (Card.isTrump(answer)) {
                            System.out.println("You can't call that suit");
                        }
                        if (answer.equalsIgnoreCase("spades")
                                || answer.equalsIgnoreCase("clubs")
                                || answer.equalsIgnoreCase("diamonds")
                                || answer.equalsIgnoreCase("hearts")) {
                            Card.trumpSuit(answer);
                            Card.addTrump(deck);
                            x = 1;
                        }
                        else {
                            System.out.println("Not a valid option");
                        }
                    }
                }
                temp++;
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
