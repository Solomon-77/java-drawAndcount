/*
    Create a Java class for the following.
    Object: Deck

    Description: A deck is a set of playing cards composed of the following cards defined below.
    1. 4 Suits (Clubs, Spades, Hearts, Diamonds)
    2. 13 values per Suit (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)

    Methods
    1. draw - provides a randomly retrieved Card represented by a suit and value. This also deducts the number of cards available from the deck. When a card has already been drawn, it can never be drawn back again.
    2. count- tells the number of cards left in the deck.

    @author
    Eustaquio, Cyrill Kieron R.

    @date
    11/17/2022
*/

import java.util.*;

public class CardsQuiz
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Card card;
        Deck deck = new Deck();

        System.out.print("\nDraw a random card: ");
        int numberCards = scan.nextInt();

        System.out.println("\nCARDS DRAWN: ");
        for(int i = 0; i < numberCards; i++) {
            card = deck.drawRandomCard();
            System.out.println(card.toString());
        }
        System.out.println(deck.toString());
        System.out.println("");
    }
}

class Card 
{
    private int type, value;
    private String[] suit = {"Clubs", "Spades", "Diamonds", "Hearts"};
    private String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Card(int types, int values) {
        type = types; 
        value = values;
    }
    public String toString() {
        String finalCard = rank[value] + " of " + suit[type];
        return finalCard;
    }
}

class Deck 
{
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for(int a = 0; a <= 3; a++) {
            for(int b = 0; b <= 12; b++) {
                cards.add(new Card(a, b));
            }
        }  
    }
    public Card drawRandomCard() {
        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }
    public String toString() {
        String result = "\nCARDS LEFT:\n" + cards;
        return result;
    }    
}

/*  
    Output sample will be

    Draw a random card: 5

    CARDS DRAWN: 
    A of Spades  
    10 of Clubs  
    6 of Hearts
    K of Diamonds
    5 of Spades

    CARDS LEFT: 
    [A of Clubs, 2 of Clubs, 3 of Clubs, 4 of Clubs, 5 of Clubs, 6 of Clubs, 7 of Clubs, 8 of Clubs, 9 of Clubs, J of Clubs, Q of Clubs, K of Clubs, 2 of Spades, 3 of Spades, 4 of Spades, 6 of Spades, 7 of Spades, 8 of Spades, 9 of Spades, 10 of Spades, J of Spades, Q of Spades, K of Spades, A of Diamonds, 2 of Diamonds, 3 of Diamonds, 4 of Diamonds, 5 of Diamonds, 6 of Diamonds, 7 of Diamonds, 8 of Diamonds, 9 of Diamonds, 10 of Diamonds, J of Diamonds, Q of Diamonds, A of Hearts, 2 of Hearts, 3 of Hearts, 4 of Hearts, 5 of Hearts, 7 of Hearts, 8 of Hearts, 9 of Hearts, 10 of Hearts, J of Hearts, Q of Hearts, K of Hearts]
*/