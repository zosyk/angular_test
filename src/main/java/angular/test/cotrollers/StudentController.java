package angular.test.cotrollers;

import angular.test.models.Student;
import angular.test.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by alex on 27.03.17.
 */
@Controller
public class StudentController {

    @Autowired
    StudentService studentService;


    @RequestMapping("/students")
    @ResponseBody
    public List<Student> getStudents() throws InterruptedException {

        Thread.sleep(2000);

        return studentService.getStudents();
    }

    @RequestMapping("/student/{id}")
    public @ResponseBody Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping("/students/{name}")
    public @ResponseBody List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

}
