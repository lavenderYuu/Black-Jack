package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the area to place the card player draw. Image Designed by Macro vector / Free pik
public class CardPanel extends JPanel {
    private ImageIcon imageK;
    private ImageIcon imageQ;
    private ImageIcon imageJ;
    private ImageIcon image10;
    private ImageIcon image9;
    private ImageIcon image8;
    private ImageIcon image7;
    private ImageIcon image6;
    private ImageIcon image5;
    private ImageIcon image4;
    private ImageIcon image3;
    private ImageIcon image2;
    private ImageIcon imageA;
    private JLabel imageAsLabel;
    private JButton draw;
    private Player player;
    private String card;

    //EFFECTS: create the area to place the cards
    public CardPanel(GameApp gameApp) {
        player = gameApp.getPlayer();
        loadImages();

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 120));
        setBackground(Color.decode("#0c6339"));
        setVisible(true);

    }

    //EFFECTS: create the button to draw card
    public JButton drawButton() {
        draw = new JButton("Draw");
        draw.setFocusable(false);
        draw.addActionListener(new ActionListener() {
            //MODIFIES: this, Player
            //EFFECTS: hit a card and display the card in the card area, if player have 5 cards, draw button disappear
            @Override
            public void actionPerformed(ActionEvent e) {
                card = player.hitCard();
                drawCard(card);
                validate();
                repaint();

                if (player.getCards().size() >= 5) {
                    draw.setVisible(false);
                }
            }
        });
        return draw;
    }

    //EFFECTS: draw a card according to the new card you get
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void drawCard(String card) {
        if (card.equals("A")) {
            setCard(imageA);
        } else if (card.equals("2")) {
            setCard(image2);
        } else if (card.equals("3")) {
            setCard(image3);
        } else if (card.equals("4")) {
            setCard(image4);
        } else if (card.equals("5")) {
            setCard(image5);
        } else if (card.equals("6")) {
            setCard(image6);
        } else if (card.equals("7")) {
            setCard(image7);
        } else if (card.equals("8")) {
            setCard(image8);
        } else if (card.equals("9")) {
            setCard(image9);
        } else if (card.equals("10")) {
            setCard(image10);
        } else if (card.equals("J")) {
            setCard(imageJ);
        } else if (card.equals("Q")) {
            setCard(imageQ);
        } else {
            setCard(imageK);
        }
    }

    //MODIFIES: this
    //EFFECTS: display Card in the card area
    public void setCard(ImageIcon image) {
        imageAsLabel = new JLabel(image);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: load the image from images package
    private void loadImages() {
        imageK = resize(new ImageIcon("images/K.png"));
        imageQ = resize(new ImageIcon("images/Q.png"));
        imageJ = resize(new ImageIcon("images/J.png"));
        image10 = resize(new ImageIcon("images/10.png"));
        image9 = resize(new ImageIcon("images/9.png"));
        image8 = resize(new ImageIcon("images/8.png"));
        image7 = resize(new ImageIcon("images/7.png"));
        image6 = resize(new ImageIcon("images/6.png"));
        image5 = resize(new ImageIcon("images/5.png"));
        image4 = resize(new ImageIcon("images/4.png"));
        image3 = resize(new ImageIcon("images/3.png"));
        image2 = resize(new ImageIcon("images/2.png"));
        imageA = resize(new ImageIcon("images/A.png"));
    }

    //MODIFIES: this
    //EFFECTS: resize the image to 100, 138
    private ImageIcon resize(ImageIcon i) {
        Image image = i.getImage();
        return new ImageIcon(image.getScaledInstance(100, 138, Image.SCALE_SMOOTH));
    }
}
