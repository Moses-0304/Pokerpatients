package cardutils;
import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> theCards;

    public Pile(){
        this.theCards = new ArrayList<>();
    }

    public int getSize(){
        return theCards.size();
    }

    public void clear(){
        theCards.clear();
    }

    public void add(Card c){
        theCards.add(c);
    }

    public void add(ArrayList<Card> cardsAdd){
        theCards.addAll(cardsAdd);
    }

    public Card get(int index){
        return theCards.get(index);
    }

    public ArrayList<Card> getCards() {
        return theCards;
    }

    public Card remove(int index){
        Card c = theCards.remove(index);
        return c;
    }

    public boolean remove(Card c){
        return theCards.remove(c);
    }

    public boolean contains(Card c){
        return theCards.contains(c);
    }

    public boolean remove(ArrayList<Card> cardsRemove){
        return theCards.removeAll(cardsRemove);
    }

    public int noOfSuit(Suit s){
        int count = 0;
        for (Card c: theCards){
            if(c.getSuit() == s){
                count++;
            }
        }
        return count;
    }

    public int noOfRank(Rank r){
        int count = 0;
        for (Card c: theCards){
            if(c.getRank() == r){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString(){
        return "" + theCards;
    }
}
