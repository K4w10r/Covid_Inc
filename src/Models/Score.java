package Models;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Score implements Serializable {
    public static List<Score> extent = new ArrayList<>();
    private String name;
    private Duration time;
    private long score;
    private String diffLevel;

    public Score(String name, Duration duration, long score,String difficultyLevel){
        this.name = name;
        this.time = duration;
        this.score = score;
        this.diffLevel = difficultyLevel;
        extent.add(this);
    }

    public static void setExtent(List<Score> extent) {
        Score.extent = extent;
    }
}
