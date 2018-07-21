package taskCollections_employees.models;

public abstract class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    double avMonthlySalary;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract void setAvMonthlySalary();

    public double getAvMonthlySalary() {
        return avMonthlySalary;
    }
}
