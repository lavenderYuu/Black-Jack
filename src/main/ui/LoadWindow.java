package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadWindow {
    private JFrame frame = new JFrame();
    private JButton yes;
    private JButton no;
    private GameApp app;

    public LoadWindow(GameApp gameApp) {
        app = gameApp;
        yes = new JButton("yes");
        no = new JButton("no");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410,300);
        frame.setLayout(null);

        setYesButton();
        setNoButton();
        app.centreOnScreen(frame);

        JLabel question = new JLabel("Do you want to load your information from last time?");
        question.setBounds(40,100,400,25);
        frame.add(question);
        frame.setVisible(true);

    }

    private void setYesButton() {
        yes.setBounds(70, 200,100,40);
        yes.setFocusable(false);
        yes.addActionListener(new ActionListener() {
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

    private void setNoButton() {
        no.setBounds(240, 200,100,40);
        no.setFocusable(false);
        no.addActionListener(new ActionListener() {
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
