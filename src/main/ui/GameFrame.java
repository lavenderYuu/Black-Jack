package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;

//Represent the game frame
public class GameFrame extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private ResultPanel resultPanel;
    private JButton draw;

    //Constructor
    //EFFECTS: place each area to the frame
    public GameFrame(GameApp app) {
        Player player = app.getPlayer();

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Black Jack");
        app.centreOnScreen(this);

        setVisible(true);

        InfoPanel info = new InfoPanel(player);
        CardPanel cardPanel = new CardPanel(app);
        draw = cardPanel.drawButton();
        resultPanel = new ResultPanel(app, this, draw);

        addButtonsPanel();
        add(info, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.EAST);
        add(resultPanel, BorderLayout.SOUTH);

        pack();
    }

    //MODIFIES: this
    //EFFECTS: add the panel with 3 buttons on the left side of the frame
    public void addButtonsPanel() {
        JPanel gameButtons = new JPanel();
        gameButtons.setSize(new Dimension(200, 100));
        gameButtons.setLayout(null);
        gameButtons.setBackground(Color.decode("#0c6339"));

        draw.setBounds(30, 10, 100, 35);
        gameButtons.add(draw);

        JButton stand = resultPanel.standButton();
        stand.setBounds(30, 60, 100, 35);
        gameButtons.add(stand);

        JButton save = resultPanel.saveAndQuitButton();
        save.setBounds(30, 110, 100, 35);
        gameButtons.add(save);

        add(gameButtons, BorderLayout.CENTER);
    }

}
