package cardutils;
import java.util.ArrayList;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public int getSuitValue() {
        return suit.ordinal();
    }


    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
