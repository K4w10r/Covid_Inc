package Models;

import Services.InfectionPipeline;

public class Virus implements Runnable{
    private InfectionPipeline infectionPipeline;
    private boolean stop;
    private int speed;
    private long deadliness;

    // lambda for other difficulty levels
    //default level == Normal 1x
    private double effects(){
        return 1.01;
    }

    public long infect(long alreadyInfected){
        return (long)(effects() * alreadyInfected);
    }

    @Override
    public void run() {
        System.out.println("please work");
        while(!stop){
            System.out.println("infecting");
            infectionPipeline.infect();
            try {
                Thread.sleep(speed*1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n\n\n\n");
        }
        System.out.println("stopping");
    }

    public void setInfectionPipeline(InfectionPipeline infectionPipeline) {
        this.infectionPipeline = infectionPipeline;
    }

    public void stop(){
        stop = true;
    }

    public Virus(int speed){
        this.speed = speed;
        stop = false;
    }
}
