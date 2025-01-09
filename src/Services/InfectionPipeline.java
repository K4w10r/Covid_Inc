package Services;

import Models.Country;
import Models.Transport;
import Models.Virus;

import java.util.List;

public class InfectionPipeline {
    private Virus virus;
    private Country country;
    private List<Transport> transports;

    public InfectionPipeline(Virus virus, Country country){
        this.virus = virus;
        this.country = country;
    }

    public static void infect(){}

    //will get the number of people to infect and then either call or not on methods that will alter the number of infections
    public long infectionModifiers(){return 0;}

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

}
