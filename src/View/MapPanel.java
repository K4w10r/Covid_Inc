package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapPanel extends JPanel {
    private static Image backgroundImage = new ImageIcon("resources/arial view of the ocean.jpeg").getImage();
    private JPanel europa;
    private JPanel asia;
    private JPanel africa;
    private JPanel northAmerica;
    private JPanel southAmerica;
    private JPanel australiaCont;

    //countries
    private CountryButton poland;
    private CountryButton spain;
    private CountryButton uk;
    private CountryButton china;
    private CountryButton japan;
    private CountryButton india;
    private CountryButton usa;
    private CountryButton canada;
    private CountryButton brazil;
    private CountryButton colombia;
    private CountryButton egypt;
    private CountryButton morocco;
    private CountryButton rpa;
    private CountryButton australiaCountry;


    public MapPanel(){
        setupContinents();


    }

    private void setupContinents(){
        europa = new JPanel(new FlowLayout());
        asia = new JPanel(new FlowLayout());
        africa = new JPanel(new FlowLayout());
        northAmerica = new JPanel(new FlowLayout());
        southAmerica = new JPanel(new FlowLayout());
        australiaCont = new JPanel(new FlowLayout());

        //location
    }

    private void setupEuropa(){
        uk = new CountryButton("path");
        spain = new CountryButton("path");
        poland = new CountryButton("path");

        europa.add(uk);
        europa.add(spain);
        europa.add(poland);
    }

    private void setupAsia(){
        china = new CountryButton("path");
        india = new CountryButton("path");
        japan = new CountryButton("path");

        asia.add(china);
        asia.add(india);
        asia.add(japan);
    }

    private void setupAfrica(){
        morocco = new CountryButton("path");
        egypt = new CountryButton("path");
        rpa = new CountryButton("path");

        africa.add(morocco);
        africa.add(egypt);
        africa.add(rpa);
    }

    private void setupNorthAmerica(){
        usa = new CountryButton("path");
        canada = new CountryButton("path");

        northAmerica.add(usa);
        northAmerica.add(canada);
    }

    private void setupSouthAmerica(){
        brazil = new CountryButton("path");
        colombia = new CountryButton("path");

        southAmerica.add(brazil);
        southAmerica.add(colombia);
    }

    private void setupAustralia(){
        australiaCountry = new CountryButton("path");

        australiaCont.add(australiaCountry);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
