package angular.test.service.student;

import angular.test.models.Student;

import java.util.List;

/**
 * Created by alex on 27.03.17.
 */
public interface StudentService {

    List<Student> getStudents();

    Student getStudentById(int id);

    List<Student> getStudentsByName(String name);
}
