package Models;

import java.util.ArrayList;
import java.util.List;

public class Boat extends Transport{
    @Override
    public void calculateRoute(){
        List<Country> countryList = new ArrayList<>(currentCountry.getMarinePorts().keySet());
        if(countryList.isEmpty())return;
        if(currentCountry.getBorders().containsValue(true)) {
            while (nextOnRoute == currentCountry) {
                int i = (int) (Math.random() * countryList.size());
                Country selectedCountry = countryList.get(i);
                if (selectedCountry.getBorders().get(currentCountry)) nextOnRoute = selectedCountry;
                /*System.out.println("boat");
                System.out.println("Current Country: " + currentCountry.getName());
                System.out.println("next country: " + nextOnRoute.getName());*/
            }
        }
        return;
    }

    // assume there is 10 people onboard
    @Override
    public void willGetInfected(){
        double chance = currentCountry.getInfectionRatio() * 10;
        if(Math.random() <= chance) isInfected = true;
    }

    @Override
    public void willGetHealthy(){
        double chance = 0.1;
        if(Math.random() <= chance) isInfected = false;
    }

    public Boat(Country startingCountry){
        super(startingCountry);
        calculateRoute();
        maxInfections = 30;
    }
}
