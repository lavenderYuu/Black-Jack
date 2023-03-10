package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;

//represent the information area
public class InfoPanel extends JPanel {
    //EFFECTS: show the Money player have and the bet player place
    public InfoPanel(Player player) {
        setPreferredSize(new Dimension(1000, 180));
        setBackground(Color.decode("#0c6339"));
        setLayout(null);

        JLabel money = new JLabel();
        money.setText("Money: " + player.getMoney() + "\n        Bet: " + player.getBet());
        money.setFont(new Font("Serif", Font.BOLD, 20));
        money.setForeground(Color.WHITE);
        money.setBounds(720, 30, 300, 50);
        add(money);
    }
}
