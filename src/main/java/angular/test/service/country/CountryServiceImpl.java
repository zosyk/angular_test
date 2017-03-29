package angular.test.service.country;

import angular.test.models.City;
import angular.test.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alex on 26.03.17.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    Connection connection;


    @Override
    public List<Country> getCountries() {

        PreparedStatement ps = null;
        List<Country> countryList = new ArrayList<>();
        List<City> citiesList = null;


        try {
            ps = connection.prepareStatement("Select * from tblCountry");
            ResultSet countrySet = ps.executeQuery();

            while (countrySet.next()) {
                Country country = new Country();
                country.setName(countrySet.getString("Name"));
                country.setId(countrySet.getInt("Id"));

                countryList.add(country);
            }

            citiesList = getCities();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps!=null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        if(citiesList!=null) {
            for (Country country : countryList) {
                country.setCities(citiesList.stream().filter(city -> city.getCountryId() == country.getId()).collect(Collectors.toList()));
            }
        }

        return countryList;
    }

    @Override
    public List<City> getCities() {
        PreparedStatement ps = null;
        List<City> citiesList = new ArrayList<>();


        try {
            ps = connection.prepareStatement("Select * from tblCity");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                City city = new City();
                city.setName(rs.getString("Name"));
                city.setId(rs.getInt("Id"));
                city.setCountryId(rs.getInt("CountryId"));

                citiesList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps!=null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return citiesList;
    }
}
