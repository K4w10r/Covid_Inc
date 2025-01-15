package Services;

import Models.Country;
import Models.Transport;
import Models.Upgrade;
import Models.Virus;

import java.util.List;

public class InfectionPipeline {
    private Virus virus;
    private List<Country> countries = Country.extent;
    private List<Transport> transports = Transport.extent;

    public InfectionPipeline(Virus virus){
        this.virus = virus;
    }

    public void infect(){
        for (Country country : countries){
            long transportsInfect = transportsInfections(country);
            System.out.println(transportsInfect);
            long infected = (long) (infectionModifiers(country) * virus.infect(country.getInfected()))
                    +  transportModifier() * transportsInfect;
            country.setInfected(infected);
            for(Country c : countries){
                country.checkIfShouldBlock(c);
            }
            System.out.println("Country: " + country.getName() + ":");
            System.out.println("Infected: " + country.getInfected());
            System.out.println("Immune: " + country.getImmune());
        }
    }

    //will get the number of people to infect and then either call or not on methods that will alter the number of infections
    public double infectionModifiers(Country country){
        double summedMultiplier = 1;

        for(Upgrade upgrade : country.getUpgrades().keySet()){
            if(country.getUpgrades().get(upgrade)){
                switch(upgrade){
                    case Borders1 -> borders1(country);
                    case Borders2 -> borders2(country);
                    case BordersFinal -> bordersFinal(country);
                    case Vaccine1 -> vaccine1(country);
                    case Vaccine2 -> vaccine2(country);
                    case VaccineFinal -> vaccineFinal(country);
                    case WashingHands1 -> summedMultiplier *= washingHands1();
                    case WashingHands2 -> summedMultiplier *= washingHands2();
                    case WashingHandsFinal -> summedMultiplier *= washingHandsFinal();
                }
            }
        }

        return summedMultiplier;
    }

    public long transportsInfections(Country country){
        long infections = 0;
        for(Transport transport : transports){
            //if(!transport.isMoving())return 0;  previous
            if(transport.isMoving())return 0;
            if(transport.getCurrentCountry().equals(country)) {
                infections += transport.getInfections();
                transport.setMoving(true);
            }
        }
        System.out.println(country.getName() + " transports infections: " + infections + '\n');
        return infections;
    }

    public long transportModifier(){
        return 1;
    }

    /*public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }*/

    private static void borders1(Country country){
        country.setCriteria(country.getCriteria() / 2);
        country.getUpgrades().replace(Upgrade.Borders1, true, false);
    }

    private static void borders2(Country country){
        country.setCriteria(country.getCriteria() / 3);
        country.getUpgrades().replace(Upgrade.Borders2, true, false);
    }

    private static void bordersFinal(Country country){
        double finalCriteria = 0.1;
        if(country.getCriteria() > finalCriteria)country.setCriteria(finalCriteria);
        country.getUpgrades().replace(Upgrade.BordersFinal, true, false);
    }

    private static void vaccine1(Country country){
        long newImmune = (long)(country.getPopulation() * 0.1) + country.getImmune();
        if(country.getPopulation() < newImmune)country.setImmune(newImmune);
        else country.setImmune(country.getPopulation());
        country.getUpgrades().replace(Upgrade.Vaccine1, true, false);
    }

    private static void vaccine2(Country country){
        long newImmune = (long)(country.getPopulation() * 0.15) + country.getImmune();
        if(country.getPopulation() < newImmune)country.setImmune(newImmune);
        else country.setImmune(country.getPopulation());
        country.getUpgrades().replace(Upgrade.Vaccine2, true, false);
    }

    private static void vaccineFinal(Country country){
        long newImmune = (long)(country.getPopulation() * 0.2) + country.getImmune();
        if(country.getPopulation() < newImmune)country.setImmune(newImmune);
        else country.setImmune(country.getPopulation());
        country.getUpgrades().replace(Upgrade.VaccineFinal, true, false);
    }
    private static double washingHands1(){
        return 0.9;
    }

    private static double washingHands2(){
        return 0.85;
    }

    private static double washingHandsFinal(){
        return 0.8;
    }
}
