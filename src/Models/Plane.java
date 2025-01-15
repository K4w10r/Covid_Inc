package Models;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Transport{
    @Override
    public void calculateRoute(){
        List<Country> countryList = new ArrayList<>(currentCountry.getAirConnections().keySet());
        if(countryList.isEmpty())return;
        if(currentCountry.getBorders().containsValue(true)) {
            while (nextOnRoute == currentCountry) {
                int i = (int) (Math.random() * countryList.size());
                Country selectedCountry = countryList.get(i);
                if (selectedCountry.getBorders().get(currentCountry)) nextOnRoute = selectedCountry;
                /*System.out.println("plane");
                System.out.println("Current Country: " + currentCountry.getName());
                System.out.println("next country: " + nextOnRoute.getName());*/
            }
        }
        return;
    }

    // assume there is 100 people onboard
    @Override
    public void willGetInfected(){
        double chance = currentCountry.getInfectionRatio() * 5;
        if(Math.random() <= chance) {
            System.out.println("Is infected lets gooooo");
            isInfected = true;
        }
    }

    @Override
    public void willGetHealthy(){
        double chance = 0.01;
        if(Math.random() <= chance) {
            System.out.println("got healthy nooooo");
            isInfected = false;
        }
    }

    public Plane(Country startingCountry){
        super(startingCountry);
        calculateRoute();
        maxInfections = 300;
    }
}
