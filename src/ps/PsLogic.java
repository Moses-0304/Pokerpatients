package ps;
import cardutils.Card;
import cardutils.Deck;
import cardutils.Pile;

import java.util.ArrayList;

public class PsLogic implements IPsLogic{
    private Card nextCard;
    private Deck deck;
    private Pile[] piles;
    public PsLogic(){
        deck = new Deck(); //Ny kortlek
        piles = new Pile[5]; //Array skaps med 5 högar
        this.nextCard =  null; //inget kort valt
        for (int i = 0; i < 5; i++) {
            piles[i] = new Pile(); //Nya högar skapas och lagras i arrayen
        }
    }

    public void initNewGame(){
        for (Pile pile : piles) {
            pile.clear(); //Återställer högar
        }

        deck.fillDeck();
        deck.shuffle();
        nextCard = null;
    }

    public int getCardCount(){
        int totalCardCount = 0;
        for (Pile pile : piles) {
            totalCardCount += pile.getSize(); //Summerar alla kort i högarna
        }

        return totalCardCount;
    }

    public Card pickNextCard(){
        if(nextCard != null){
            throw new IllegalStateException("Finns ett valt kort");
        }
        else{
            nextCard = deck.dealCard(); //Nytt kort dras
        }
        return nextCard;
    }

    public void addCardToPile(int pIndex){
        if(nextCard == null){
            throw new IllegalStateException("Inget kort valt");
        }

        if(pIndex >= 0 && pIndex < piles.length){
            Pile p = piles[pIndex]; //Valda kortet lagras i specifik hög
            p.add(nextCard);
            nextCard = null; //Återställer till null
        }
        else {
            throw new IllegalStateException("Indexet skall vara 0-4");
        }
    }

    public ArrayList<Pile> getPiles(){
        ArrayList<Pile> copyPiles = new ArrayList<>();
        //Skapar kopior av högarna och return
        for (Pile p : piles){
            Pile copyPile = new Pile();
            copyPile.add(p.getCards());
            copyPiles.add(copyPile);
        }

        return copyPiles;
    }

    public boolean isGameOver(){
        return getCardCount() >= 25;
    }

    public int getPoints(){
        int points = 0;

        for(Pile p : piles){
            PokerCombo c = PokerHands.getPokerCombo(p);

            if(c == PokerCombo.PAIR){
                points += 1;
            }
            else if(c == PokerCombo.TWO_PAIRS){
                points += 3;
            }
            else if(c == PokerCombo.TRIPS){
                points += 6;
            }
            else if(c == PokerCombo.FLUSH){
                points += 5;
            }
            else if(c == PokerCombo.QUADS){
                points += 16;
            }
        }
        return points;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < piles.length; i++) {
            result += i + ": " + piles[i] + "\n";
        }

        return result;
    }
}
