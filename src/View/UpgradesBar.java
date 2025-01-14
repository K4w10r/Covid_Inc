package View;

import Models.Upgrade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpgradesBar extends JScrollPane implements ActionListener{
    private JLabel countryName;
    private UpgradeButton up1;
    private UpgradeButton up2;
    private UpgradeButton up3;
    private UpgradeButton up4;
    private UpgradeButton up5;
    private UpgradeButton up6;
    private UpgradeButton up7;
    private UpgradeButton up8;
    private UpgradeButton up9;
    private JPanel panel;
    private List<UpgradeButton> buttonList;
    public UpgradesBar(String countryName){
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setViewportView(panel); // wraps JScrollPane around panel
        this.countryName = new JLabel("Selected Country:\n" + countryName);
        this.buttonList = new ArrayList<>();


        this.countryName.setHorizontalTextPosition(JLabel.CENTER);
        this.countryName.setVerticalTextPosition(JLabel.TOP);

        setupButtons();

        panel.add(Box.createVerticalGlue()); //centers buttons vertically
        panel.add(this.countryName);
        for(UpgradeButton button : buttonList) {
            panel.add(button);
        }
        panel.add(Box.createVerticalGlue());

        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void setupButtons(){
        this.up1 = new UpgradeButton(Upgrade.Borders1.name());
        this.up2 = new UpgradeButton(Upgrade.Borders2.name());
        this.up3 = new UpgradeButton(Upgrade.BordersFinal.name());
        this.up4 = new UpgradeButton(Upgrade.Vaccine1.name());
        this.up5 = new UpgradeButton(Upgrade.Vaccine2.name());
        this.up6 = new UpgradeButton(Upgrade.VaccineFinal.name());
        this.up7 = new UpgradeButton(Upgrade.WashingHands1.name());
        this.up8 = new UpgradeButton(Upgrade.WashingHands2.name());
        this.up9 = new UpgradeButton(Upgrade.WashingHandsFinal.name());

        buttonList.add(up1);
        buttonList.add(up2);
        buttonList.add(up3);
        buttonList.add(up4);
        buttonList.add(up5);
        buttonList.add(up6);
        buttonList.add(up7);
        buttonList.add(up8);
        buttonList.add(up9);

        for(UpgradeButton button : buttonList){
            button.addActionListener(this);
            button.setFocusable(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
