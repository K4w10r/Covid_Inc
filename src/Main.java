import Models.Country;
import Services.CountryService;
import View.GameFrame;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("pol", 15, 0.3, "flaga");
        Country country2 = new Country("ger", 15, 0.4,"flaga");
        Country country3 = new Country("esp", 12, 0.2,"flaga");
        for (Country cntr: Country.extent
             ) {
            System.out.println(cntr.getName());
        }

        CountryService cs = new CountryService();
        cs.addBorders(Country.extent);
        for(Country cntr : country.getBorders().keySet()){
            System.out.println(cntr.getName());
        }
        System.out.println(Country.extent.size());

        GameFrame gameFrame = new GameFrame();

    }
}
