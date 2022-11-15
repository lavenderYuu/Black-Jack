package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceBetWindow {
    private GameApp app;
    private JButton placeBet;
    private JFrame frame;
    private JTextField field;
    private Player player;

    public PlaceBetWindow(GameApp gameApp) {
        app = gameApp;
        frame = new JFrame("Initial the game");
        player = app.getPlayer();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410,300);
        frame.setLayout(null);
        app.centreOnScreen(frame);

        addButton();
        addNotification();

        field = new JTextField(5);
        field.setBounds(70, 180, 100, 35);
        frame.add(field);


        frame.setVisible(true);
    }

    public void addButton() {
        placeBet = new JButton("Place the bet");
        placeBet.setBounds(240,180,100,35);

        placeBet.setActionCommand("myButton");
        placeBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("myButton")) {
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
            }
        });
        frame.add(placeBet);
    }

    public void addNotification() {

        JLabel notice = new JLabel("Please place your bet to start the game. ");
        notice.setBounds(20,50,410,35);
        notice.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(notice);

        JLabel money = new JLabel("Money you have is $" + player.getMoney());
        money.setBounds(20,100,410,35);
        money.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(money);
    }
}
