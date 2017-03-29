package angular.test.models;

/**
 * Created by alex on 26.03.17.
 */
public class Employee {

    private String name;
    private int gender;
    private int dataOfBirth;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(int dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
