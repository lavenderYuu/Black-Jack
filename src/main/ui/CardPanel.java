package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the area to place the card player draw. Image Designed by Macrovector / Freepik
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
            setA();
        } else if (card.equals("2")) {
            set2();
        } else if (card.equals("3")) {
            set3();
        } else if (card.equals("4")) {
            set4();
        } else if (card.equals("5")) {
            set5();
        } else if (card.equals("6")) {
            set6();
        } else if (card.equals("7")) {
            set7();
        } else if (card.equals("8")) {
            set8();
        } else if (card.equals("9")) {
            set9();
        } else if (card.equals("10")) {
            set10();
        } else if (card.equals("J")) {
            setJ();
        } else if (card.equals("Q")) {
            setQ();
        } else {
            setK();
        }
    }

    //MODIFIES: this
    //EFFECTS: display card A in the card area
    public void setA() {
        imageAsLabel = new JLabel(imageA);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 2 in the card area
    public void set2() {
        imageAsLabel = new JLabel(image2);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 3 in the card area
    public void set3() {
        imageAsLabel = new JLabel(image3);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 4 in the card area
    public void set4() {
        imageAsLabel = new JLabel(image4);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 5 in the card area
    public void set5() {
        imageAsLabel = new JLabel(image5);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 6 in the card area
    public void set6() {
        imageAsLabel = new JLabel(image6);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 7 in the card area
    public void set7() {
        imageAsLabel = new JLabel(image7);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 8 in the card area
    public void set8() {
        imageAsLabel = new JLabel(image8);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 9 in the card area
    public void set9() {
        imageAsLabel = new JLabel(image9);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card 10 in the card area
    public void set10() {
        imageAsLabel = new JLabel(image10);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card J in the card area
    public void setJ() {
        imageAsLabel = new JLabel(imageJ);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card Q in the card area
    public void setQ() {
        imageAsLabel = new JLabel(imageQ);
        add(imageAsLabel);
    }

    //MODIFIES: this
    //EFFECTS: display card K in the card area
    public void setK() {
        imageAsLabel = new JLabel(imageK);
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
