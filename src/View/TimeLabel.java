package View;

import javax.swing.*;
import java.time.Duration;

public class TimeLabel extends JLabel {
    private Duration time;
    public TimeLabel(Duration time){
        this.time = time;
        this.setText("Time: " + time.toString());
    }
}
