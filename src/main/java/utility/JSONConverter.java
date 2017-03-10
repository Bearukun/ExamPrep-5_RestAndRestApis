package utility;

import com.google.gson.Gson;
import entity.City;
import entity.Country;

import java.util.List;

/**
 *
 * @author bearu
 */
public class JSONConverter {

    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    public Country getCountryFromJson(String js) {
        
        return gson.fromJson(js, Country.class);

    }

    public String getJSONFromCountry(Country c) {

        return gson.toJson(c);
        
    }

    public String getJSONFromCountries(List<Country> countries) {
        
        return gson.toJson(countries);
        
    }
    
    public City getCityFromJson(String js) {
        
        return gson.fromJson(js, City.class);

    }

    public String getJSONFromCity(City c) {

        return gson.toJson(c);
        
    }

    public String getJSONFromCities(List<City> city) {
        
        return gson.toJson(city);
        
    }

}
