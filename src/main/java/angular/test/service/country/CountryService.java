package angular.test.service.country;


import angular.test.models.City;
import angular.test.models.Country;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 26.03.17.
 */
public interface CountryService {

    List<Country> getCountries() throws SQLException;
    List<City> getCities();
}
