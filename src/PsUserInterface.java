import ps.PsLogic;
import java.util.Scanner;
import cardutils.Card;

public class PsUserInterface {
    private PsLogic psLogic;
    private Scanner scan;

    public PsUserInterface(){
        this.psLogic = new PsLogic();
        this.scan = new Scanner(System.in);
    }

    public void run(){
        char choice = ' ';
        String ans;

        do{
            printMenu();
            ans = scan.nextLine();
            ans = ans.toUpperCase();
            choice = ans.charAt(0);

            switch (choice) {
                case 'A':
                    newGame();
                    break;
                case 'Z':
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Unknown command, Enter 'A' or 'Z'");
            }
        } while (choice != 'Z');
    }

    public void printMenu() {
        System.out.println("---Menu---");
        System.out.println("Press A to Start a new game");
        System.out.println("Press Z to Exit");
        System.out.println("----------");
    }

    public void pickCard(){
        Card nextCard = psLogic.pickNextCard();
        System.out.println(psLogic.toString());
        System.out.println("Next Card: " + nextCard.toString());
        System.out.print("Select a pile [0..4]: ");
        String ans = scan.nextLine();
        int ind = Integer.parseInt(ans.trim());
        psLogic.addCardToPile(ind);
    }

    public void newGame() {
        System.out.println("Init");
        psLogic.initNewGame();
        System.out.println("Ready.");

        while(!psLogic.isGameOver()){
            pickCard();
        }
        System.out.println("Game over");
        System.out.println("You got " + psLogic.getPoints() + " points.");
    }

    public static void main(String[] args) {
        PsUserInterface menu = new PsUserInterface();
        menu.run();
    }
}