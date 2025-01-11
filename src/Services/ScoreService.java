package Services;

import Models.Score;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class ScoreService {
    private static List<Score> scores = Score.extent;
    private static final String filename = "";

    public Score calculateScore(String name, Duration time, String difficultyLevel){
        //calculations
        long score = 0;
      return new Score(name, time, score, difficultyLevel);
    }

    public void serialize(){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(scores);

            out.close();
            file.close();

            System.out.println("Serialization Successful (I hope)");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void deserialize(){
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
             Score.setExtent((List<Score>)in.readObject());

            in.close();
            file.close();

            System.out.println("Deserialization Successful (I also hope)");
        }

        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("Class not found: \n" + ex.getMessage());
        }
    }
}
