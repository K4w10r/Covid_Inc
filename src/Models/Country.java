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
    private double criteria;
    private ConcurrentHashMap<Upgrade, Boolean> upgrades;
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

    // Block / unlock borders
    private void blockBordersWithCountry(Country country){
        borders.replace(country,true, false);
        airConnections.replace(country,true, false);
        marinePorts.replace(country,true, false);
    }
    private void unlockBordersWithCountry(Country country){
        borders.replace(country,false, true);
        airConnections.replace(country,false, true);
        marinePorts.replace(country,false, true);
    }

    public void checkIfShouldBlock(Country country){
        if(country.equals(this))return;
        if (country.getInfectionRatio() >= criteria) {
            System.out.println("blocked borders with: " + country.getName());
            blockBordersWithCountry(country);
        }
        if (country.getInfectionRatio() < criteria)unlockBordersWithCountry(country);
    }


    // Upgrades
    public void addUpgrade(Upgrade upgrade){
        if(upgrades.contains(upgrade))return;
        upgrades.put(upgrade, true);
    }

    public Country(String name, long population, double criteria){
        this.name = name;
        this.population = population;
        infected = 0;
        immune = 0;
        this.criteria = criteria;
        upgrades = new ConcurrentHashMap<>();
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

    public void setInfected(long infected) {
        if(infected > population)this.infected = population;
        else this.infected = infected;
    }

    public long getPopulation() {
        return population;
    }

    public double getInfectionRatio(){
        return (double) infected / population;
    }

    public ConcurrentHashMap<Country, Boolean> getAirConnections() {
        return airConnections;
    }

    public ConcurrentHashMap<Country, Boolean> getMarinePorts() {
        return marinePorts;
    }

    public void setCriteria(double criteria) {
        this.criteria = criteria;
    }

    public double getCriteria() {
        return criteria;
    }

    public long getImmune() {
        return immune;
    }

    public void setImmune(long immune) {
        this.immune = immune;
    }

    public ConcurrentHashMap<Upgrade, Boolean> getUpgrades() {
        return upgrades;
    }
}
