package ui;

import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Game application
public class GameApp {
    private static final String STORAGE = "./data/player.json";
    private Player player;
    private Player dealer;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: runs the game application
    public GameApp() {
        init();
        new LoadWindow(this);
    }

    //MODIFIES: this
    //EFFECTS: initialize player and dealer
    public void init() {
        player = new Player();
        dealer = new Player();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(STORAGE);
        jsonReader = new JsonReader(STORAGE);
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
    //EFFECTS: let dealer draw card with point greater or equal to 17.
    //         Then get the dealer's total point and return it
    public int dealerPoint() {

        while (dealer.getTotalPoint() < 17) {
            dealer.hitCard();

            if (dealer.getCards().size() >= 5) {
                return dealer.getTotalPoint();
            }
        }
        return dealer.getTotalPoint();
    }

    // EFFECTS: saves the player to file
    public void savePlayer() {
        try {
            jsonWriter.open();
            jsonWriter.write(player);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file " + STORAGE);
        }
    }

    public void loadPlayer() {
        try {
            player = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Sorry, unable to find your information");
        }

    }

    // Centres frame on desktop cite: get method from SpaceInvaders
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    public void centreOnScreen(JFrame frame) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screen.width - frame.getWidth()) / 2, (screen.height - 100 - frame.getHeight()) / 2);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }


}
