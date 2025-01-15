package View;
import javax.swing.*;
import java.awt.*;

public class ScoresPanel extends JPanel {
    private JList<String> scores;
    public ScoresPanel(){
        this.setLayout(new BorderLayout());
        scores = new JList<>();
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        updateScores();
        this.add(scores, BorderLayout.CENTER);
    }

    public void updateScores(){
        String[] arr = {"kasia", "basia"};
        scores.setListData(arr);
    }

}
