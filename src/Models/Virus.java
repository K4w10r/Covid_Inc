package Models;

import Services.InfectionPipeline;

public class Virus implements Runnable{
    private InfectionPipeline infectionPipeline;
    private int speed;
    private long deadliness;

    // it will use the upgrades and will idk what
    private void infect(){}
    private double effects(){return 1;}
    @Override
    public void run() {

    }

    public void setInfectionPipeline(InfectionPipeline infectionPipeline) {
        this.infectionPipeline = infectionPipeline;
    }
}
