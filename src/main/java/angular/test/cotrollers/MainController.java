package angular.test.cotrollers;

import angular.test.models.Country;
import angular.test.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 26.03.17.
 */
@Controller
public class MainController {

    @Autowired
    CountryService countryService;


    @RequestMapping("/")
    public String actionIndex() {
        return "index";
    }

    @RequestMapping("/test")
    public ModelAndView testView() {

        return new ModelAndView("index_work_example");
    }

    @RequestMapping("/countries")
    @ResponseBody
    public List<Country> getCountries(HttpServletResponse response) throws SQLException {

        response.addHeader("Access-Control-Allow-Origin", "*");

        return countryService.getCountries();


























//        List<Employee> employees = new ArrayList<>();
////        return "[\n" +
////                "                        {name: 'Ben', dataOfBirth : 2017, gender: 1, salary : 4000.340},\n" +
////                "                        {name: 'Sara', dataOfBirth : 2017, gender: 2, salary : 900},\n" +
////                "                        {name: 'Mark', dataOfBirth : 2017, gender: 1, salary : 54222.340},\n" +
////                "                        {name: 'Pam', dataOfBirth : 2017, gender: 3, salary : 800.340}\n" +
////                "                    ]";
//
//        Employee employee = new Employee();
//        employee.setName("Ben");
//        employee.setDataOfBirth(2017);
//        employee.setGender(1);
//        employee.setSalary(4000.34);
//        employees.add(employee);
//
//
//
//        return employees;


//        return "{\n" +
//                "    \"name\": \"Ben\",\n" +
//                "    \"dataOfBirth\": 2017,\n" +
//                "    \"gender\": 1,\n" +
//                "    \"salary\": 4000.34\n" +
//                "}";
    }

}
