import Models.*;
import Services.CountryService;
import Services.InfectionPipeline;
import Services.TransportCoordinator;
import View.GameFrame;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("pol", 150000, 0.3);
        Country country2 = new Country("ger", 150000, 0.4);
        Country country3 = new Country("esp", 120000, 0.2);
        for (Country cntr: Country.extent
             ) {
            System.out.println(cntr.getName());
        }

        CountryService cs = new CountryService();
        cs.addBorders(Country.extent);
        cs.addAirports();
        cs.addMarinePorts(Country.extent);
        cs.chooseStartingCountry(country2);

        for(Country cntr : country.getBorders().keySet()){
            System.out.println(cntr.getName());
        }
        System.out.println(Country.extent.size());

        Virus virus = new Virus(1);
        InfectionPipeline infectionPipeline = new InfectionPipeline(virus);
        virus.setInfectionPipeline(infectionPipeline);

        Plane plane = new Plane(country);
        Car car = new Car(country);
        Boat boat = new Boat(country);

        Plane plane2 = new Plane(country2);
        Car car2 = new Car(country2);
        Boat boat2 = new Boat(country2);

        Plane plane3 = new Plane(country3);
        Car car3 = new Car(country3);
        Boat boat3 = new Boat(country3);

        Plane plane4 = new Plane(country);
        Car car4 = new Car(country);
        Boat boat4 = new Boat(country);

        Plane plane5 = new Plane(country2);
        Car car5 = new Car(country2);
        Boat boat5 = new Boat(country2);

        Plane plane6 = new Plane(country3);
        Car car6 = new Car(country3);
        Boat boat6 = new Boat(country3);

        TransportCoordinator transportCoordinator = new TransportCoordinator();
        Thread transCoordinator = new Thread(transportCoordinator);
        Thread virusThread = new Thread(virus);

        try{
            System.out.println("starting virus");
            virusThread.start();
            transCoordinator.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //GameFrame gameFrame = new GameFrame();

    }
}
