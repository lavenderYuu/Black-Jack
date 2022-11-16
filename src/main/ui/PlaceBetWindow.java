package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represent the window let player place the bet
public class PlaceBetWindow {
    private GameApp app;
    private JFrame frame;
    private JTextField field;
    private Player player;

    //Constructor
    //EFFECTS: create a window with notification, button and a text field
    public PlaceBetWindow(GameApp gameApp) {
        app = gameApp;
        frame = new JFrame("Initial the game");
        player = app.getPlayer();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 300);
        frame.setLayout(null);
        app.centreOnScreen(frame);

        addNotification();
        addTextField();
        addButton();

        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: add a button to confirm place a bet
    public void addButton() {
        JButton placeBet = new JButton("Place the bet");
        placeBet.setBounds(240, 180, 100, 35);

        placeBet.addActionListener(new ActionListener() {
            @Override
            //MODIFIES: Player
            //EFFECTS: place the bet if the number enter is a positive number <= money player have,
            //  dispose current window and jump to gameFrame.
            //         Otherwise, click the button will still stay on the place bet window
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(field.getText());
                if (bet > player.getMoney() || bet <= 0) {
                    frame.dispose();
                    new PlaceBetWindow(app);
                } else {
                    player.placeBet(bet);
                    frame.dispose();
                    new GameFrame(app);
                }
            }
        });
        frame.add(placeBet);
    }

    //MODIFIES: this
    //EFFECTS: add notification about the money player have and what they need to input
    public void addNotification() {
        JLabel notice = new JLabel("Please place your bet to start the game. ");
        notice.setBounds(20, 50, 410, 35);
        notice.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(notice);

        JLabel money = new JLabel("Money you have is $" + player.getMoney());
        money.setBounds(20, 100, 410, 35);
        money.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(money);
    }

    //MODIFIES: this
    //EFFECTS: add the text field allow player to place the bet.
    public void addTextField() {
        field = new JTextField(5);
        field.setBounds(70, 180, 100, 35);
        frame.add(field);

    }
}
