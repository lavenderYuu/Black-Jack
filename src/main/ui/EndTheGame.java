package ui;

import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTheGame {
    private JFrame frame = new JFrame();
    private JButton quit;
    private GameApp app;

    //MODIFIES: this
    //EFFECTS: initialize the EndGame Window, with a sentence and a quit button
    public EndTheGame(GameApp app) {
        this.app = app;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410,300);
        frame.setLayout(null);
        app.centreOnScreen(frame);
        quitButton();

        JLabel question = new JLabel("You are broke. See you next time");
        question.setBounds(40,100,400,25);
        frame.add(question);
        frame.setVisible(true);

    }

    public void quitButton() {
        quit = new JButton("quit");
        quit.setBounds(155,200,100,40);
        quit.setFocusable(false);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player brokenPlayer = app.getPlayer();
                brokenPlayer.moneyAddMins(1,1000);
                app.savePlayer();
                System.exit(0);
            }
        });
        frame.add(quit);
    }


}
