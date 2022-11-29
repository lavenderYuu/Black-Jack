package ui;

import model.Event;
import model.EventLog;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Game application
public class GameApp {
    private static final String STORAGE = "./data/player.json";
    private Player player;
    private Player dealer;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: Initialize the game and start the graphic
    public GameApp() {
        init();
        new LoadWindow(this);
    }

    //MODIFIES: this
    //EFFECTS: initialize player and dealer
    public void init() {
        player = new Player();
        dealer = new Player();
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
        int point = dealer.calculate(dealer.getCards());

        while (point < 17) {
            dealer.hitCard();
            point = dealer.calculate(dealer.getCards());

            if (dealer.getCards().size() >= 5) {
                return point;
            }
        }
        return point;
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

    //EFFECTS: load the player from file
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

    //EFFECTS: getter for player
    public Player getPlayer() {
        return player;
    }

    //EFFECTS: getter for dealer
    public Player getDealer() {
        return dealer;
    }

    //EFFECTS: print all the Events
    public void printLog() {
        EventLog el = EventLog.getInstance();
        for (Event next : el) {
            System.out.println(next.toString() + "\n");
        }
    }

    // Play the game
    public static void main(String[] args) {
        new GameApp();
    }


}
