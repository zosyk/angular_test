package angular.test.service.student;

import angular.test.models.City;
import angular.test.models.Country;
import angular.test.models.Student;
import angular.test.models.StudentsTotals;
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
 * Created by alex on 27.03.17.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    Connection connection;

    @Override
    public List<Student> getStudents() {
        PreparedStatement ps = null;
        List<Student> studentList = new ArrayList<>();

        try {
            ps = connection.prepareStatement("Select * from tblStudents");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        PreparedStatement ps = null;
        Student student = new Student();

        try {
            ps = connection.prepareStatement("Select * from tblStudents WHERE id= ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return student;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        PreparedStatement ps = null;
        List<Student> studentList = new ArrayList<>();

        try {
            ps = connection.prepareStatement("Select * from tblStudents WHERE name LIKE ?");
            ps.setString(1, name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return studentList;
    }

    @Override
    public StudentsTotals getStudentsTotals() {
        final StudentsTotals studentsTotals= new StudentsTotals();

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("SELECT COALESCE(Gender) as Gender, COUNT(*) AS Total FROM tblStudents GROUP BY Gender");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String sex = rs.getString("Gender");

                if(sex.equals("Female")) {
                    studentsTotals.setFemales(rs.getInt("Total"));
                } else {
                    studentsTotals.setMales(rs.getInt("Total"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        studentsTotals.setTotal(studentsTotals.getFemales() + studentsTotals.getMales());

        return studentsTotals;
    }
}
