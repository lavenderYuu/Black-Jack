package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represent the end game window when the player lose all the money
public class EndTheGame {
    private JFrame frame = new JFrame();
    private JButton quit;
    private GameApp app;

    //constructor
    //EFFECTS: initialize the EndGame Window, with a sentence and a quit button
    public EndTheGame(GameApp app) {
        this.app = app;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 300);
        app.centreOnScreen(frame);
        frame.setLayout(null);
        addQuitButton();
        addNotice();
        frame.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: add a notification on the window
    private void addNotice() {
        JLabel question = new JLabel("You are broke. See you next time");
        question.setBounds(40, 100, 400, 25);
        question.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(question);
    }

    //MODIFIES: this
    //EFFECTS: add a quit Button on the window to quit the game
    public void addQuitButton() {
        quit = new JButton("quit");
        quit.setBounds(155, 200, 100, 40);
        quit.setFocusable(false);
        quit.addActionListener(new ActionListener() {
            @Override
            //EFFECTS: quit the game and initialize the player money
            public void actionPerformed(ActionEvent e) {
                Player brokenPlayer = app.getPlayer();
                brokenPlayer.placeBet(1000);
                brokenPlayer.moneyAddMins(1);
                app.savePlayer();
                System.exit(0);
            }
        });
        frame.add(quit);
    }


}
