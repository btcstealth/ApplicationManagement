package Model;

public class Employee {

    private int ID;
    private double salary;
    private String name;

    public Employee(int ID, double salary, String name) {
        this.ID = ID;
        this.salary = salary;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
