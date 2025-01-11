package Models;

import java.util.ArrayList;
import java.util.List;

public class Car extends Transport{
    @Override
    public void calculateRoute(){
        List<Country> countryList = new ArrayList<>(currentCountry.getBorders().keySet());
        if(countryList.isEmpty())return;
        if(currentCountry.getBorders().containsValue(true)) {
            while (nextOnRoute != currentCountry) {
                int i = (int) (Math.random() * countryList.size());
                Country selectedCountry = countryList.get(i);
                if (selectedCountry.getBorders().get(currentCountry)) nextOnRoute = selectedCountry;
            }
        }
        return;
    }

    // assume there is 100 people onboard
    @Override
    public void willGetInfected(){
        double chance = (double) (currentCountry.getInfected() / currentCountry.getPopulation()) * 5;
        if(Math.random() <= chance) isInfected = true;
    }

    @Override
    public void willGetHealthy(){
        double chance = 0.2;
        if(Math.random() <= chance) isInfected = false;
    }

    public Car(Country startingCountry){
        super(startingCountry);
        calculateRoute();
        maxInfections = 15;
    }
}
