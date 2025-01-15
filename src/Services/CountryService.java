package Services;

import Models.Country;
import Models.Upgrade;

import java.util.List;

public class CountryService {
    private List<Country> countries = Country.extent;


    public void chooseStartingCountry(Country country){
        country.setInfected((long)country.getPopulation()/20);
    }

    // adding Borders, Marine Ports, AirPorts
    public void addBorders(List<Country> borderingCountries){
        if (borderingCountries == null) throw new IllegalArgumentException("Countries list cannot be null");
        for (Country country : borderingCountries) {
            if (country == null) throw new IllegalArgumentException("A country cannot be null");
        }
        for (Country country : borderingCountries){
            for(Country border : borderingCountries){
                country.addCountryBorders(border);
            }
        }
        System.out.println("added borders to countries");
    }

    public void addMarinePorts(List<Country> marinePortsInCountries){
        if (marinePortsInCountries == null) throw new IllegalArgumentException("Countries list cannot be null");
        for (Country country : marinePortsInCountries) {
            if (country == null) throw new IllegalArgumentException("A country cannot be null");
        }
        for (Country country : marinePortsInCountries){
            for(Country port : marinePortsInCountries){
                country.addCountryMarinePorts(port);
            }
        }
        System.out.println("added marine ports to countries");
    }

    public void addAirports(){
        for(Country country : countries){
            for(Country airPort : countries){
                country.addCountryAirPorts(airPort);
            }
        }
        System.out.println("added airports to countries");
    }


    // blocking / unblocking Borders, Marine Ports, AirPorts
    /*public void blockConnectionsWithCountry(Country infectedCountry){
        if(infectedCountry == null) throw new IllegalArgumentException("Infected Country cannot be null");
        for(Country country : countries){
            country.blockBordersWithCountry(infectedCountry);
        }
    }

    public void unlockConnectionsWithCountry(Country healedCountry){
        if(healedCountry == null) throw new IllegalArgumentException("Healed country cannot be null");
        for(Country country : countries){
            country.unlockBordersWithCountry(healedCountry);
        }
    }*/


    //Upgrades
    public void addUpgrade(Country country, Upgrade upgrade){
        if(country == null) throw new IllegalArgumentException("Country cannot be null");
        country.addUpgrade(upgrade);
    }

}
