package taskCollections_employees.models;

import java.text.DecimalFormat;

public class EmployeeFixed extends Employee {

    private double fixedMonthlyPayment;

    public EmployeeFixed(int id, String name, double fixedMonthlyPayment){
        super(id, name);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
        setAvMonthlySalary();
    }

    @Override
    public void setAvMonthlySalary() {
        this.avMonthlySalary = fixedMonthlyPayment;
    }

    @Override
    public String toString() {
        String formattedAvSalary = new DecimalFormat("#0.00").format(getAvMonthlySalary());
        return "Employee{" +
                "id='" + getId()+ '\'' +
                ", name='" + getName() + '\'' +
                ", average monthly salary='" + formattedAvSalary + '\'' +
                "          fixed monthly payment='" + fixedMonthlyPayment + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
