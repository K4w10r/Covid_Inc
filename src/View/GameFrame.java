package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {
    private MapPanel map;
    private UpgradesBar upgrades;
    private StatsBar statsBar;
    private MainMenuPanel mainMenu;
    public GameFrame(){
        this.setTitle("Covid clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(new BorderLayout());

        setupMainMenuPanel();

        this.setVisible(true);

    }

    private void setupMainMenuPanel(){
        mainMenu = new MainMenuPanel(this);
        this.add(mainMenu,BorderLayout.CENTER);
    }

    // Game
    public void setupGame(){

        map = new MapPanel();
        this.add(map, BorderLayout.CENTER);

        // docelowo ma byc 0 na poczatku i jak nacisnie na kraj to wtedy wybierze z listy albo zrobi nowy
        upgrades = new UpgradesBar("Nazwa kraju");
        upgrades.setPreferredSize(new Dimension(150,100));
        this.add(upgrades, BorderLayout.EAST);

        statsBar = new StatsBar();
        statsBar.setPreferredSize(new Dimension(100,25));
        this.add(statsBar, BorderLayout.NORTH);
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == exitButton){
            //close
            System.out.println("Exiting");
            disableButtons();
        }else if(e.getSource() == highScoresButton){
            //show high scores
            System.out.println("Getting high scores");
        }else if(e.getSource() == newGameButton){
            // start new game
            setupGame();
            System.out.println("Starting new game");
        }*/
    }
}
