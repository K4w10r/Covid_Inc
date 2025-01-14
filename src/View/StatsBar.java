package View;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class StatsBar extends JPanel implements Runnable {
    private JLabel points;
    private JLabel population;
    private JLabel infected;
    private JLabel immune;
    private TimeLabel time;

    public StatsBar(){
        points = new JLabel("Points: " + 0);
        //population = new JLabel("Population: " + countryService.getAllPopulation());
        population = new JLabel("Population: " + 0);
        //infected = new JLabel("Immune: " + countryService.getAllImmune());
        infected = new JLabel("Infected: " + 0);
        //immune = new JLabel("Infected: " + countryService.getAllInfected());
        immune = new JLabel("Immune: " + 0);
        time = new TimeLabel(Duration.ZERO);

        this.setLayout(new FlowLayout());

        this.add(time);
        this.add(population);
        this.add(infected);
        this.add(immune);
        this.add(points);


    }

    @Override
    public void run() {
        //update variables
    }
}
