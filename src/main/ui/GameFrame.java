package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private CardPanel cardPanel;
    private InfoPanel info;
    private GameApp app;
    private Player player;
    private JPanel gameButtons;
    private ResultPanel resultPanel;
    private JButton draw;

    public GameFrame(GameApp app) {
        this.app = app;
        player = app.getPlayer();

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Black Jack");
        app.centreOnScreen(this);

        setVisible(true);


        info = new InfoPanel(player);
        cardPanel  = new CardPanel(app);
        draw = cardPanel.drawButton();
        resultPanel = new ResultPanel(app, this, draw);


        buttonsPanel();
        add(info, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.EAST);
        add(resultPanel, BorderLayout.SOUTH);


        pack();
    }

    public void buttonsPanel() {
        gameButtons = new JPanel();
        gameButtons.setSize(new Dimension(200, 100));
        gameButtons.setLayout(null);
        gameButtons.setBackground(Color.decode("#0c6339"));

        draw.setBounds(30,10,100,35);
        gameButtons.add(draw);

        JButton stand = resultPanel.standButton();
        stand.setBounds(30,60,100,35);
        gameButtons.add(stand);

        JButton save = resultPanel.saveAndQuitButton();
        save.setBounds(30,110,100,35);
        gameButtons.add(save);

        add(gameButtons, BorderLayout.CENTER);
    }

}
