package Models;

import java.util.List;

public abstract class Transport {
    public static List<Transport> extent;
    protected Country currentCountry;
    protected Country nextOnRoute;
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
        return infections = calculateAmountOfTransmittedDisease();
    }

    //each subclass will calculate its own route
    public void calculateRoute(){}
    public void willGetInfected(){}
    public void willGetHealthy(){}

    protected Transport(Country startingCountry){
        currentCountry = startingCountry;
        isInfected = false;
        extent.add(this);
    }
}
