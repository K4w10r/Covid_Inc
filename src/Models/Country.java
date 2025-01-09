package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Country {
    public static List<Country> extent = new ArrayList<>();
    private String name;
    private long population;
    private long infected;
    private long immune;
    private String flag;
    private ConcurrentHashMap<String, Boolean> upgrades;
    private ConcurrentHashMap<Country, Boolean> boarders;
    private ConcurrentHashMap<Country, Boolean> airConnections;

    public Country(String name, long population, String flag){
        this.name = name;
        this.population = population;
        infected = 0;
        immune = 0;
        this.flag = flag;
        upgrades = new ConcurrentHashMap<String, Boolean>();
        boarders = new ConcurrentHashMap<Country, Boolean>();
        airConnections = new ConcurrentHashMap<Country, Boolean>();
        extent.add(this);
    }

    public String getName() {
        return name;
    }
}
