package Models;

import java.util.List;

public abstract class Transport {
    private List<Country> route;
    private boolean isInfected;
    private long maxInfections;
    public long calculateAmountOfTransmittedDisease(){return 0;}

    //each subclass will calculate its own route
    public void calculateRoute(){}
}
