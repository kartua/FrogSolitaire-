/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kartua
 */
public class GamePlay extends JPanel {

    private Frog game;//gameplay object
    private JButton deckButton;// deck
    private JButton reserveButton;// reserve
    private JButton found1, found2, found3, found4;// foundation piles
    private JButton waste1, waste2, waste3, waste4;// waste piles
    private JButton hand;// card on hand
    //fucntion buttons
    private JButton restartButton, helpButton, dealButton;

    private JLabel scoreLabel;// show score for the user
    //Image for back, deck and reserve
    private ImageIcon backImage, deckImage, reserveImage, emptyFoundImage;
    private ImageIcon found1Image, found2Image, found3Image, found4Image;
    private ImageIcon waste1Image, waste2Image, waste3Image, waste4Image;
    private ImageIcon handImage;

    private String emptyHand = "Cards/hand.jpg";
    private String deckBack = "Cards/back.jpg";
    private String empty = "Cards/empty.jpg";
    private String emptyWaste = "Cards/waste.jpg";
    private String emptyFound = "Cards/found.jpg";

    //A Condition is used wheaterh to show back for front card of deck
    boolean deckShowsBack = true;

    public GamePlay() {

        // Start new game play
        game = new Frog();

        System.out.println(game.reserve.size());
        System.out.println(game.deck.size());
        System.out.println(game.foundation1.size());

        System.out.println(game.foundation2.size());
        System.out.println(game.foundation3.size());
        System.out.println(game.foundation4.size());

        JLabel lay1 = new JLabel();
        lay1.setPreferredSize(new Dimension(1500, 20));
        JLabel lay2 = new JLabel();
        lay2.setPreferredSize(new Dimension(300, 1));
        JLabel lay3 = new JLabel();
        lay3.setPreferredSize(new Dimension(25, 1));
        JLabel lay4 = new JLabel();
        lay4.setPreferredSize(new Dimension(25, 1));
        JLabel lay5 = new JLabel();
        lay5.setPreferredSize(new Dimension(25, 1));
        JLabel lay6 = new JLabel();
        lay6.setPreferredSize(new Dimension(1500, 20));
        JLabel lay7 = new JLabel();
        lay7.setPreferredSize(new Dimension(380, 1));
        JLabel lay8 = new JLabel();
        lay8.setPreferredSize(new Dimension(25, 1));
        JLabel lay9 = new JLabel();
        lay9.setPreferredSize(new Dimension(25, 1));
        JLabel lay10 = new JLabel();
        lay10.setPreferredSize(new Dimension(25, 1));
        JLabel lay11 = new JLabel();
        lay11.setPreferredSize(new Dimension(1500, 20));
        JLabel lay12 = new JLabel();
        lay12.setPreferredSize(new Dimension(600, 1));
        JLabel lay13 = new JLabel();
        lay13.setPreferredSize(new Dimension(150, 1));
        JLabel lay14 = new JLabel();
        lay14.setPreferredSize(new Dimension(200, 40));
        JLabel lay15 = new JLabel();
        lay15.setPreferredSize(new Dimension(200, 40));

        scoreLabel = new JLabel();
//        scoreLabel.setText("Comment");
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 38));
        scoreLabel.setPreferredSize(new Dimension(1400, 100));
        scoreLabel.setForeground(Color.BLACK);

        //Create deck button and set image icon
        deckButton = new JButton();
        backImage = new ImageIcon(deckBack);
        deckButton.setIcon(backImage);

        //Create foundation buttons and set starting image icon
        emptyFoundImage = new ImageIcon(emptyFound);

        found1 = new JButton();
        found2 = new JButton();
        found3 = new JButton();
        found4 = new JButton();
        reserveButton = new JButton();
        waste1 = new JButton();
        waste2 = new JButton();
        waste3 = new JButton();
        waste4 = new JButton();
        hand = new JButton();

        //Create function buttons
        restartButton = new JButton("Shuffle");
        restartButton.setPreferredSize(new Dimension(200, 40));
        restartButton.setFont(new Font("Serif", Font.BOLD, 25));
        dealButton = new JButton("Deal");
        dealButton.setFont(new Font("Serif", Font.BOLD, 25));
        dealButton.setPreferredSize(new Dimension(200, 40));
        helpButton = new JButton("Help");
        helpButton.setFont(new Font("Serif", Font.BOLD, 25));
        helpButton.setPreferredSize(new Dimension(200, 40));
        JPanel functionPanel = new JPanel();
        functionPanel.setPreferredSize(new Dimension(250, 250));
        functionPanel.add(restartButton);
        functionPanel.add(lay14);
        functionPanel.add(dealButton);
        functionPanel.add(lay15);
        functionPanel.add(helpButton);

        //Add action listener to each button
        deckButton.addActionListener(new DeckListener());
        waste1.addActionListener(new Waste1Listener());
        waste2.addActionListener(new Waste2Listener());
        waste3.addActionListener(new Waste3Listener());
        waste4.addActionListener(new Waste4Listener());
        found1.addActionListener(new Found1Listener());
        found2.addActionListener(new Found2Listener());
        found3.addActionListener(new Found3Listener());
        found4.addActionListener(new Found4Listener());
        reserveButton.addActionListener(new ReserveListener());
        restartButton.addActionListener(new RestartListener());
        helpButton.addActionListener(new HelpListener());
        dealButton.addActionListener(new DealListener());

        //set Image for each pile.
        setWaste1Image();
        setWaste2Image();
        setWaste3Image();
        setWaste4Image();
        setFound1Image();
        setFound2Image();
        setFound3Image();
        setFound4Image();
        setHandImage();
        setReserveImage();

        //add all buttons to the panel
        add(lay1);
        add(deckButton);
        add(lay2);
        add(found1);
        add(lay3);
        add(found2);
        add(lay4);
        add(found3);
        add(lay5);
        add(found4);
        add(lay6);
        add(lay7);
        add(waste1);
        add(lay8);
        add(waste2);
        add(lay9);
        add(waste3);
        add(lay10);
        add(waste4);
        add(lay11);
        add(reserveButton);
        add(lay12);
        add(hand);
        add(lay13);
        add(functionPanel);
        add(scoreLabel);

        Color bg = new Color(8, 89, 35);
        deckButton.setBackground(bg);
        found1.setBackground(bg);
        found2.setBackground(bg);
        found3.setBackground(bg);
        found4.setBackground(bg);
        reserveButton.setBackground(bg);
        waste1.setBackground(bg);
        waste2.setBackground(bg);
        waste3.setBackground(bg);
        waste4.setBackground(bg);
        hand.setBackground(bg);
        functionPanel.setBackground(bg);
        setBackground(bg);
        updateScore();

        setPreferredSize(new Dimension(1500, 900));

    }

    private void setFound1Image() {
        if (game.foundation1.isEmpty()) {
            found1.setIcon(emptyFoundImage);
        } else {
            found1Image = new ImageIcon(game.getfound1Card().getImage());
            found1.setIcon(found1Image);
        }
    }

    private void setFound2Image() {
        if (game.foundation2.isEmpty()) {
            found2.setIcon(emptyFoundImage);
        } else {
            found2Image = new ImageIcon(game.getfound2Card().getImage());
            found2.setIcon(found2Image);
        }
    }

    private void setFound3Image() {
        if (game.foundation3.isEmpty()) {
            found3.setIcon(emptyFoundImage);
        } else {
            found3Image = new ImageIcon(game.getfound3Card().getImage());
            found3.setIcon(found3Image);
        }
    }

    private void setFound4Image() {
        if (game.foundation4.isEmpty()) {
            found4.setIcon(emptyFoundImage);
        } else {
            found4Image = new ImageIcon(game.getfound4Card().getImage());
            found4.setIcon(found4Image);
        }
    }

    private void setHandImage() {
        if (game.hand.isEmpty()) {
            handImage = new ImageIcon(emptyHand);
            hand.setIcon(handImage);
        } else {
            handImage = new ImageIcon(game.gethandCard().getImage());
            hand.setIcon(handImage);
        }
    }

    private void setWaste1Image() {
        if (game.wastePile1.isEmpty()) {
            waste1Image = new ImageIcon(emptyWaste);
            waste1.setIcon(waste1Image);
        } else {
            waste1Image = new ImageIcon(game.getwaste1Card().getImage());
            waste1.setIcon(waste1Image);
        }
    }

    private void setWaste2Image() {
        if (game.wastePile2.isEmpty()) {
            waste2Image = new ImageIcon(emptyWaste);
            waste2.setIcon(waste2Image);
        } else {
            waste2Image = new ImageIcon(game.getwaste2Card().getImage());
            waste2.setIcon(waste2Image);
        }
    }

    private void setWaste3Image() {
        if (game.wastePile3.isEmpty()) {
            waste3Image = new ImageIcon(emptyWaste);
            waste3.setIcon(waste3Image);
        } else {
            waste3Image = new ImageIcon(game.getwaste3Card().getImage());
            waste3.setIcon(waste3Image);
        }
    }

    private void setWaste4Image() {
        if (game.wastePile4.isEmpty()) {
            waste4Image = new ImageIcon(emptyWaste);
            waste4.setIcon(waste4Image);
        } else {
            waste4Image = new ImageIcon(game.getwaste4Card().getImage());
            waste4.setIcon(waste4Image);
        }
    }

    private void setReserveImage() {
        if (game.reserve.isEmpty()) {
            reserveImage = new ImageIcon(empty);
            reserveButton.setIcon(reserveImage);
        } else {
            reserveImage = new ImageIcon(game.getreserveCard().getImage());
            reserveButton.setIcon(reserveImage);
        }
    }

    private void updateScore() {
        int score;
        score = game.foundation1.size() + game.foundation2.size()
                + game.foundation3.size() + game.foundation4.size();
        if (score == 52) {
            scoreLabel.setText("YOU WIN!!!!!!!!!!");
        } else {
            scoreLabel.setText("Reserve remaning: " + game.reserve.size()
                    + "                                          "
                    + "Your score: " + score + "/52             ");
        }
    }

    private void restart() {
        while (!game.hand.isEmpty()) {
            game.hand.pop();
        }
        while (!game.deck.isEmpty()) {
            game.deck.pop();
        }
        while (!game.reserve.isEmpty()) {
            game.reserve.pop();
        }
        while (!game.wastePile1.isEmpty()) {
            game.wastePile1.pop();
        }
        while (!game.wastePile2.isEmpty()) {
            game.wastePile2.pop();
        }
        while (!game.wastePile3.isEmpty()) {
            game.wastePile3.pop();
        }
        while (!game.wastePile4.isEmpty()) {
            game.wastePile4.pop();
        }
        while (!game.foundation1.isEmpty()) {
            game.foundation1.pop();
        }
        while (!game.foundation2.isEmpty()) {
            game.foundation2.pop();
        }
        while (!game.foundation3.isEmpty()) {
            game.foundation3.pop();
        }
        while (!game.foundation4.isEmpty()) {
            game.foundation4.pop();
        }

        game = new Frog();

        setWaste1Image();
        setWaste2Image();
        setWaste3Image();
        setWaste4Image();
        setFound1Image();
        setFound2Image();
        setFound3Image();
        setFound4Image();
        setHandImage();
        setReserveImage();
        deckShowsBack = true;
        backImage = new ImageIcon(deckBack);
        deckButton.setIcon(backImage);
        updateScore();

    }

    private class DeckListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            //Check if the deck is empty does no action.
            if (Frog.getMode() == game.FROM_DECK) {
                game.putCardBacktoDeck();
                deckImage = new ImageIcon(game.getdeckCard().getImage());
                deckButton.setIcon(deckImage);
                handImage = new ImageIcon(emptyHand);
                hand.setIcon(handImage);
                deckShowsBack = false;

            } else if (!game.deck.isEmpty()) {
                //Check if the back of card is show up, then open the card
                //else pop the showing card to the hand.
                if (deckShowsBack) {
                    deckShowsBack = false;
                    deckImage = new ImageIcon(game.getdeckCard().getImage());
                    deckButton.setIcon(deckImage);
                } else //check if there is no card in the hand,
                //then pop card from deck to the hand
                 if (game.hand.isEmpty()) {
                        deckShowsBack = true;
                        deckImage = new ImageIcon(deckBack);
                        deckButton.setIcon(deckImage);
                        game.getCardFromDeck();
                        //if the deck is empty after taking the card to hand,
                        //then show empty deck image
                        //else 
                        if (game.deck.isEmpty()) {
                            deckImage = new ImageIcon(empty);
                            deckButton.setIcon(deckImage);
                        }
                        handImage = new ImageIcon(game.gethandCard().getImage());
                        hand.setIcon(handImage);

                    }
            }
        }
    }

    private class DealListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.deal();
            setReserveImage();
            setFound1Image();
            setFound2Image();
            setFound3Image();
            setFound4Image();

        }

    }

    private class Waste1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnWaste1();
            setHandImage();
            setWaste1Image();
        }

    }

    private class Waste2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnWaste2();
            setHandImage();
            setWaste2Image();
        }
    }

    private class Waste3Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnWaste3();
            setHandImage();
            setWaste3Image();
        }
    }

    private class Waste4Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnWaste4();
            setHandImage();
            setWaste4Image();
        }
    }

    private class Found1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnFoundation1();
            setFound1Image();
            setHandImage();
            updateScore();
        }

    }

    private class Found2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnFoundation1();
            setFound1Image();
            setHandImage();
            updateScore();
        }

    }

    private class Found3Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnFoundation3();
            setFound1Image();
            setHandImage();
            updateScore();
        }

    }

    private class Found4Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnFoundation4();
            setFound1Image();
            setHandImage();
            updateScore();
        }

    }

    private class ReserveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            game.playOnReserve();
            setHandImage();
            setReserveImage();
        }

    }

    private class RestartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            restart();

        }
    }

    private class HelpListener implements ActionListener {

        private JFrame frame = new JFrame("Help");

        public void actionPerformed(ActionEvent e) {

            if (!frame.isShowing()) {
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel helpPanel = new JPanel();
                JTextArea helpText = new JTextArea();
                helpText.setPreferredSize(new Dimension(1000, 300));
                helpPanel.add(helpText);
                String helpMessage;
                helpMessage = "Click Deal to start the game.\n"
                        + "Click Shuffle to reset the card.\n";
                helpMessage += "The top left card is \"Deck\"\n";
                helpMessage += "The bottom left card is \"Reserve\" \n";
                helpMessage += "1)You can take a card from deck, reserve "
                        + "or waste pile by clicking on it.\n";
                helpMessage += "2)After clicking on the card, "
                        + "it will appeal in hand\n";
                helpMessage += "3)Then you can place the card from hand"
                        + " to a waste pile or a foundation according "
                        + "to the rule.\n";
                helpMessage += "4)You can also put the card from hand"
                        + " back to the place where it from by clicking again"
                        + " at \n     the pile that you took the card from.\n";


                helpText.setFont(new Font("Serif", Font.BOLD, 25));
                helpText.setText(helpMessage);
                frame.getContentPane().add(helpPanel);
                frame.pack();
                frame.setVisible(true);
                frame.setLocation(400, 300);
                frame.setResizable(false);
            }

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frog Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePlay panel = new GamePlay();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setLocation(200, 50);
        frame.setResizable(false);

    }
}
