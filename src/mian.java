import Models.Country;

public class mian {
    public static void main(String[] args) {
        Country country = new Country("pol", 15, "flaga");
        Country country2 = new Country("ger", 15, "flaga");
        for (Country cntr: Country.extent
             ) {
            System.out.println(cntr.getName());

        }
    }
}
