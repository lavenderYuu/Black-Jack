package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represent the window to choose load information or not
public class LoadWindow {
    private JFrame frame;
    private JButton yes;
    private JButton no;
    private GameApp app;

    //Constructor
    //EFFECTS: create the Load window with label and 2 buttons
    public LoadWindow(GameApp gameApp) {
        app = gameApp;
        yes = new JButton("yes");
        no = new JButton("no");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 300);
        frame.setLayout(null);

        setYesButton();
        setNoButton();
        app.centreOnScreen(frame);

        JLabel question = new JLabel("Do you want to load your information from last time?");
        question.setBounds(40, 100, 400, 25);
        frame.add(question);
        frame.setVisible(true);

    }

    //MODIFIES: this
    //EFFECTS: add a yes button to the window
    private void setYesButton() {
        yes.setBounds(70, 200, 100, 40);
        yes.setFocusable(false);
        yes.addActionListener(new ActionListener() {
            //EFFECTS: load the player, dispose the window and jump to place bet window
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == yes) {
                    frame.dispose();
                    app.loadPlayer();
                    new PlaceBetWindow(app);
                }
            }
        });
        frame.add(yes);
    }

    //MODIFIES: this
    //EFFECTS: add a no button to the window
    private void setNoButton() {
        no.setBounds(240, 200, 100, 40);
        no.setFocusable(false);
        no.addActionListener(new ActionListener() {
            //EFFECTS: dispose the window and jump to place bet window
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == no) {
                    frame.dispose();
                    new PlaceBetWindow(app);
                }
            }
        });
        frame.add(no);
    }


}
