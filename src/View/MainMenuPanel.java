package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel implements ActionListener {
    private static Image backgroundImage = new ImageIcon("resources/arial view of the ocean.jpeg").getImage();
    private JButton newGameButton;
    private JButton highScoresButton;
    private JButton exitButton;
    private GameFrame gameFrame;

    public MainMenuPanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        highScoresButton = new JButton("High Scores");
        highScoresButton.addActionListener(this);
        highScoresButton.setFocusable(false);
        highScoresButton.setAlignmentX(CENTER_ALIGNMENT);

        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        newGameButton.setFocusable(false);
        newGameButton.setAlignmentX(CENTER_ALIGNMENT);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue()); //centers buttons vertically
        this.add(newGameButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(highScoresButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(exitButton);
        this.add(Box.createVerticalGlue());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitButton){
            //close
            System.out.println("Exiting");
        }else if(e.getSource() == highScoresButton){
            //show high scores
            System.out.println("Getting high scores");
        }else if(e.getSource() == newGameButton){
            // start new game
            System.out.println("Starting new game");
            this.setVisible(false);
            gameFrame.setupGame();
        }
    }

}
