package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {
    private JButton stand;
    private GameApp app;
    private Player player;
    private Player dealer;
    private GameFrame gameFrame;
    private JButton draw;

    public ResultPanel(GameApp app, GameFrame gameFrame, JButton draw) {
        this.app = app;
        player = app.getPlayer();
        dealer = app.getDealer();
        this.gameFrame = gameFrame;
        this.draw = draw;

        setPreferredSize(new Dimension(1000, 200));
        setBackground(Color.decode("#0c6339"));
        setLayout(null);

    }

    public JButton standButton() {
        stand = new JButton("Stand");
        stand.setFocusable(false);
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = app.isWinner();

                if (result == -1) {
                    resultPanel("You lose :(");
                    player.moneyAddMins(result, player.getBet());
                } else if (result == 0) {
                    resultPanel("Tie :|      ");
                    player.moneyAddMins(result, player.getBet());
                } else {
                    resultPanel("You Win! :)");
                    player.moneyAddMins(result, player.getBet());
                }

                stand.setVisible(false);
                draw.setVisible(false);

                validate();
                repaint();
            }
        });
        return stand;
    }

    public JButton saveAndQuitButton() {
        JButton save = new JButton("Save and quit");
        save.setFocusable(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.savePlayer();
                System.exit(0);
            }
        });
        return save;
    }

    public void resultPanel(String result) {
        JLabel lose = new JLabel();
        lose.setText(result + "    Dealer's point is " + dealer.getTotalPoint());
        lose.setFont(new Font("Arial", Font.BOLD, 30));
        lose.setForeground(Color.WHITE);
        lose.setBounds(100, 60, 800, 50);
        setVisible(true);
        addRestartButton();
        add(lose);
    }

    public void addRestartButton() {
        JButton restart =  new JButton("start a new round");
        restart.setFocusable(false);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.getCards().clear();
                dealer.getCards().clear();
                if (player.getMoney() <= 0) {
                    new EndTheGame(app);
                    gameFrame.dispose();
                } else {
                    new PlaceBetWindow(app);
                    gameFrame.dispose();
                }
            }
        });
        restart.setBounds(700, 60,150, 40);
        add(restart);
    }


}
