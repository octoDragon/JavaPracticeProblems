//Explain how you would put a deck of cards in order by suit(in the
// order spades,hearts,clubs,diamonds)and by rank within each suit,with
// the restriction that the cards must be laid out face down in a row,and
// the only allowed operations are to check the values of two cards and to
// exchange two cards(keeping them face down).

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckSort {
    public static void main(String[] args) {
        Card[] myDeck = Deck.MakeDeck();
        Deck.ShuffleDeck(myDeck);
        Deck.PrintDeck(myDeck);
        StdOut.println("----------------");
        myDeck = Deck.Sort(myDeck);
        Deck.PrintDeck(myDeck);
    }
}

class Deck {
    static int NUMBEROFCARDS = 52;

    static Card[] MakeDeck() {
        Card[] myDeck = new Card[NUMBEROFCARDS];
        int cardCount = 0;
        for (int i = 1; i <= 4; i++)
            for (int k = 1; k <= 13; k++) {
                //uncomment to write deck to a file
                //using termnal command: java-algs4 DeckSort > 'file.txt'
                //StdOut.println(i + " " + k);

                Card card = new Card(i, k);
                myDeck[cardCount] = card;
                cardCount++;
            }
        return myDeck;
    }

    static Card[] ShuffleDeck(Card[] myDeck) {
        List<Card> cardList = Arrays.asList(myDeck);
        Collections.shuffle(cardList);
        cardList.toArray(myDeck);
        return myDeck;
    }

    static void PrintDeck(Card[] myDeck) {
        for (Card card : myDeck) {
            StdOut.println(card.S + " " + card.R);
        }
    }

    static Card[] Sort(Card[] myDeck) {
        int N = myDeck.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(myDeck[j], myDeck[j - 1]); j--) {
                exch(myDeck, j, j - 1);
            }
        }
        return myDeck;
    }

    private static boolean less(Card movingCard, Card comparingCard) {
        if (movingCard.S <= comparingCard.S) {
            if (movingCard.R < comparingCard.R) {
                return true;
            }
        }
        return false;
    }

    private static void exch(Card[] myDeck, int movingCard, int comparedCard) {
        Card t = myDeck[movingCard];
        myDeck[movingCard] = myDeck[comparedCard];
        myDeck[comparedCard] = t;

    }
}

class Card {
    int S;
    int R;

    Card(int suit, int rank) {
        S = suit;
        R = rank;
    }
}

