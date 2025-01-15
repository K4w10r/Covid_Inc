package View;

import javax.swing.*;
import java.awt.*;

public class CountryButton extends JButton {
    public CountryButton(String name, String imagePath){
        this.setText(name);
        this.setPreferredSize(new Dimension(160,30));
    }
}
