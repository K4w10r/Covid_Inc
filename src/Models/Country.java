package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Country {
    public static List<Country> extent = new ArrayList<>();
    private String name;
    private long population;
    private long infected;
    private long immune;
    private String flag;
    private List<Upgrade> upgrades;
    private ConcurrentHashMap<Country, Boolean> borders;
    private ConcurrentHashMap<Country, Boolean> airConnections;
    private ConcurrentHashMap<Country, Boolean> marinePorts;


    // Borders, Marine Ports, Air Ports
    public void addCountryBorders(Country country){
        if(country.equals(this))return;
        if(borders.containsKey(country))return;
        borders.put(country, true);
    }

    public void addCountryMarinePorts(Country country){
        if(country.equals(this))return;
        if(marinePorts.containsKey(country))return;
        marinePorts.put(country, true);
    }

    public void addCountryAirPorts(Country country){
        if(country.equals(this))return;
        if(airConnections.containsKey(country))return;
        airConnections.put(country, true);
    }

    public void blockBordersWithCountry(Country country){
        borders.replace(country,true, false);
        airConnections.replace(country,true, false);
        marinePorts.replace(country,true, false);
    }
    public void unlockBordersWithCountry(Country country){
        borders.replace(country,false, true);
        airConnections.replace(country,false, true);
        marinePorts.replace(country,false, true);
    }


    // Upgrades
    public void addUpgrade(Upgrade upgrade){
        if(upgrades.contains(upgrade))return;
        upgrades.add(upgrade);
    }

    public Country(String name, long population, String flag){
        this.name = name;
        this.population = population;
        infected = 0;
        immune = 0;
        this.flag = flag;
        upgrades = new ArrayList<>();
        borders = new ConcurrentHashMap<Country, Boolean>();
        airConnections = new ConcurrentHashMap<Country, Boolean>();
        marinePorts = new ConcurrentHashMap<Country, Boolean>();
        extent.add(this);
    }


    // Getters
    public String getName() {
        return name;
    }

    public ConcurrentHashMap<Country, Boolean> getBorders() {
        return borders;
    }

    public long getInfected() {
        return infected;
    }

    public long getPopulation() {
        return population;
    }

    public ConcurrentHashMap<Country, Boolean> getAirConnections() {
        return airConnections;
    }

    public ConcurrentHashMap<Country, Boolean> getMarinePorts() {
        return marinePorts;
    }
}
