package Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    public static List<Transport> extent = new ArrayList<>();
    protected Country currentCountry;
    protected Country nextOnRoute;
    private boolean moving;
    protected boolean isInfected;
    protected static long maxInfections;
    private long infections;

    private long calculateAmountOfTransmittedDisease(){
        if (!isInfected)return 0;
        return (long)(Math.random() * maxInfections + 1);
    }

    public long move(){
        currentCountry = nextOnRoute;
        calculateRoute();
        if(isInfected)willGetHealthy();
        if(!isInfected)willGetInfected();
        moving = false;
        infections = calculateAmountOfTransmittedDisease();
        System.out.println(infections);
        return infections;
    }

    //each subclass will calculate its own route
    public void calculateRoute(){}
    public void willGetInfected(){}
    public void willGetHealthy(){}

    protected Transport(Country startingCountry){
        currentCountry = startingCountry;
        nextOnRoute = currentCountry;
        isInfected = false;
        moving = false;
        extent.add(this);
    }

    public Country getCurrentCountry() {
        return currentCountry;
    }

    public long getInfections() {
        return infections;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isMoving() {
        return moving;
    }
}
