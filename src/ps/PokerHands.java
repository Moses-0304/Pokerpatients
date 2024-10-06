package ps;
import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

public class PokerHands {

    private PokerHands(){ // Konstruktorn är privat för att förhindra instansiering av klassen.

    }

    public static PokerCombo getPokerCombo(Pile p){
        if(quads(p)){
            return PokerCombo.QUADS;
        }
        else if(flush(p)){
            return PokerCombo.FLUSH;
        }
        else if (trips(p)) {
            return PokerCombo.TRIPS;
        }
        else if (twoPairs(p)) {
            return PokerCombo.TWO_PAIRS;
        }
        else if (pair(p)) {
            return (PokerCombo.PAIR);
        }
        else {
            return PokerCombo.NONE;
        }
    }

    private static boolean quads(Pile p){ //Static behöver inte skapa objektinstans tillgängliga på klassnivå
        for(Rank rank : Rank.values()){
            int rankC = p.noOfRank(rank);
            if(rankC == 4){
                return true;
            }
        }
        return false;
    }

    private static boolean flush(Pile p){
        for(Suit suit : Suit.values()){
            int suitC = p.noOfSuit(suit);
            if(suitC == 5){
                return true;
            }
        }
        return false;
    }

    private static boolean trips(Pile p){
        for (Rank rank : Rank.values()){
            int rankC = p.noOfRank(rank);
            if(rankC == 3){
                return  true;
            }
        }
        return false;
    }

    private static boolean twoPairs(Pile p){
        int pairC = 0;
        for(Rank rank : Rank.values()){
            int rankC = p.noOfRank(rank);
            if(rankC == 2){
                pairC++;
            }

            if (pairC == 2){
                return true;
            }
        }
        return false;
    }

    private static boolean pair(Pile p){
        for(Rank rank : Rank.values()){
            int rankC = p.noOfRank(rank);
            if(rankC == 2){
                return true;
            }
        }
        return false;
    }
}
