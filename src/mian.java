import Models.Country;
import Services.CountryService;

public class mian {
    public static void main(String[] args) {
        Country country = new Country("pol", 15, "flaga");
        Country country2 = new Country("ger", 15, "flaga");
        Country country3 = new Country("esp", 12, "flaga");
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
    }
}
