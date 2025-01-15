package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class MapPanel extends JPanel {
    private static Image backgroundImage = new ImageIcon("resources/arial view of the ocean.jpeg").getImage();
    private JPanel europe;
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
        this.setLayout(null);

        setupContinents();


    }

    private void setupContinents(){
        europe = new JPanel(new FlowLayout());
        asia = new JPanel(new FlowLayout());
        africa = new JPanel(new FlowLayout());
        northAmerica = new JPanel(new FlowLayout());
        southAmerica = new JPanel(new FlowLayout());
        australiaCont = new JPanel(new FlowLayout());

        setupEurope();
        setupAsia();
        setupAfrica();
        setupNorthAmerica();
        setupSouthAmerica();
        setupAustralia();

        //location
        europe.setBounds(500, 50, 200, 120);
        asia.setBounds(700, 50, 300, 200);
        africa.setBounds(500, 200, 200, 250);
        northAmerica.setBounds(50, 30, 250, 150);
        southAmerica.setBounds(100, 220, 200, 250);
        australiaCont.setBounds(850, 450, 180, 120);

        this.add(europe);
        this.add(asia);
        this.add(africa);
        this.add(northAmerica);
        this.add(southAmerica);
        this.add(australiaCont);

        /*JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(northAmerica, BorderLayout.NORTH);
        leftPanel.add(southAmerica, BorderLayout.SOUTH);
        this.add(leftPanel, BorderLayout.WEST);

        JPanel topPanel = new JPanel(new BorderLayout());
        leftPanel.add(southAmerica, BorderLayout.);
        this.add(leftPanel, BorderLayout.WEST);*/
    }

    private void setupEurope(){
        uk = new CountryButton("UK","path");
        spain = new CountryButton("Spain","path");
        poland = new CountryButton("Poland", "path");

        europe.add(uk);
        europe.add(spain);
        europe.add(poland);
    }

    private void setupAsia(){
        china = new CountryButton("China", "path");
        india = new CountryButton("India", "path");
        japan = new CountryButton("Japan", "path");

        asia.add(china);
        asia.add(india);
        asia.add(japan);
    }

    private void setupAfrica(){
        morocco = new CountryButton("Morocco", "path");
        egypt = new CountryButton("Egypt", "path");
        rpa = new CountryButton("RPA", "path");

        africa.add(morocco);
        africa.add(egypt);
        africa.add(rpa);
    }

    private void setupNorthAmerica(){
        usa = new CountryButton("USA", "path");
        canada = new CountryButton("Canada", "path");

        northAmerica.add(usa);
        northAmerica.add(canada);
    }

    private void setupSouthAmerica(){
        brazil = new CountryButton("Brazil", "path");
        colombia = new CountryButton("Colombia", "path");

        southAmerica.add(brazil);
        southAmerica.add(colombia);
    }

    private void setupAustralia(){
        australiaCountry = new CountryButton("Australia", "path");

        australiaCont.add(australiaCountry);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
