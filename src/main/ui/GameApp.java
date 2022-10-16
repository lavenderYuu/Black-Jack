package ui;

import model.Player;

import java.util.Scanner;

public class GameApp {
    private Player player;
    private Player dealer;
    private Scanner input;

    //runs the game application
    public GameApp() {
        runGame();
    }

    //Modifies: this
    //Effects: process user input
    public void runGame() {
        String commend;
        int bid;
        boolean over = false;

        System.out.println("Welcome to the Game: Black Jack");
        init();

        while (!over) {
            System.out.println("The money you have: $" + player.getMoney());
            bid = placeBid();
            start();
            displayMenu();
            commend = input.next();
            commend = commend.toLowerCase();
            processARound(commend, bid);

            over = ifEndANewRound();
        }

        System.out.println("Good Bye!");

    }

    //MODIFIES: this
    //Effects: initialize player and dealer
    public void init() {
        player = new Player();
        dealer = new Player();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //Effects: check if player still have money left
    public Boolean isGameOver() {

        if (player.getMoney() <= 0) {
            System.out.println("You lose all the money");
            return true;
        } else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: process user commend in a round
    public void processARound(String commend, int bid) {

        if (player.getCards().size() == 5) {
            System.out.println("The maximum card you can draw is 5. Choose the stand automatically.");
            getResult(bid);
        } else if (commend.equals("d")) {
            doDraw();
            displayMenu();
            commend = input.next();
            commend = commend.toLowerCase();
            processARound(commend, bid);
        } else if (commend.equals("s")) {
            getResult(bid);
        } else {
            System.out.println("Select invalid");

            displayMenu();
            commend = input.next();
            commend = commend.toLowerCase();
            processARound(commend, bid);
        }
    }

    //MODIFIES: this
    //EFFECTS: get result after the player choose stand
    public void getResult(int bid) {
        int result = isWinner();

        if (result == -1) {
            System.out.println("You lose :(");
            System.out.println("Dealer's point: " + dealer.getTotalPoint());
            player.moneyAddMins(result, bid);
        } else if (result == 0) {
            System.out.println("Tie :|");
            System.out.println("Dealer's point: " + dealer.getTotalPoint());
            player.moneyAddMins(result, bid);
        } else {
            System.out.println("You Win! :)");
            System.out.println("Dealer's point: " + dealer.getTotalPoint());
            player.moneyAddMins(result, bid);
        }

    }

    //MODIFIES: this
    //EFFECTS: process user commend to decide start a new round or End the game
    public boolean ifEndANewRound() {
        String commend;

        System.out.println("\nThe money you left: $" + player.getMoney());
        System.out.println("\tr -> start a new round");
        System.out.println("\tq -> quit the game");

        commend = input.next();
        commend = commend.toLowerCase();

        if (commend.equals("r")) {
            player.getCards().clear();
            dealer.getCards().clear();
            return isGameOver();
        } else if (commend.equals("q")) {
            return true;
        } else {
            System.out.println("Selection invalid");
            return ifEndANewRound();
        }
    }

    //MODIFIES:this
    //EFFECTS: start a new round, draw 2 cards for player and display the cards they draw
    public void start() {
        player.hitCard();
        player.hitCard();
        System.out.println("The cards you have are " + player.getCards().get(0) + " and " + player.getCards().get(1));
    }

    //REQUIRES: 0 < bid <= player's money
    //MODIFIES: this
    //EFFECTS: place the bid from your money
    public int placeBid() {
        System.out.println("To start a new round please place the bid: ");

        int bid;
        bid = input.nextInt();

        if (bid <= 0) {
            System.out.println("The bid has to be positive");
            bid = placeBid();
        } else if (bid > player.getMoney()) {
            System.out.println("The balance you have is $" + player.getMoney());
            bid = placeBid();
        }

        return bid;
    }

    //EFFECTS: display the choice player have
    public void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> draw a new card");
        System.out.println("\ts -> stand");
    }

    //MODIFIES: this
    //EFFECTS: draw a new card and display which card player draw
    public void doDraw() {
        player.hitCard();
        System.out.println("The cards you have are ");

        for (int i = 0; i < player.getCards().size(); i++) {
            System.out.print(player.getCards().get(i) + " ");
        }

    }

    //MODIFIES: this
    //EFFECTS: compare the card with dealer
    //     -1: lose
    //      0: draw
    //      1: win
    //      2: win with black jack
    public int isWinner() {
        int point = player.getTotalPoint();
        int dealerPoint = dealerPoint();

        if (point > 21) {
            return -1;
        } else if (point == 21) {
            return 2;
        } else if (dealerPoint > 21) {
            return 1;
        } else if (point == dealerPoint) {
            return 0;
        } else if (point > dealerPoint) {
            return 1;
        } else {
            return -1;
        }
    }

    //MODIFIES: this
    //Effects: get the dealer's total point and return it
    public int dealerPoint() {
        dealer.hitCard();
        dealer.hitCard();

        while (dealer.getTotalPoint() < 17) {
            dealer.hitCard();

            if (dealer.getCards().size() >= 5) {
                return dealer.getTotalPoint();
            }
        }
        return dealer.getTotalPoint();
    }

}
