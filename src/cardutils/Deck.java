package cardutils;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> theCards;
    private static final ArrayList<Card> protoDeck = new ArrayList<>(); //intern lista med dessa prototyp-kort, static. variabeln delas av alla instanser av klassen
    //gemensam kortlek som används av alla objekt som representerar en kortlek

    static { //lista behöver fyllas med kort en enda gång,
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                protoDeck.add(new Card(rank, suit));
            }
        }
    }

    public Deck(){
        theCards = new ArrayList<>();
        fillDeck();
    }

    public void fillDeck() {
        theCards.clear();
        theCards.addAll(protoDeck); //fylla den med 52 referenser till korten i protoDeck
    }

    public Card dealCard(){
        return theCards.remove(theCards.size() - 1);
    }

    public void shuffle(){
        Collections.shuffle(theCards);
    }

    public int getSize() {
        return theCards.size();
    }

    @Override
    public String toString(){
        return "Cards:\n" + theCards;
    }
}
