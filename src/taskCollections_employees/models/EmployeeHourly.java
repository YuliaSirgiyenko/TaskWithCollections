package taskCollections_employees.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class EmployeeHourly extends Employee {

    private double hourlyRate;

    public EmployeeHourly(int id, String name, double hourlyRate){
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.avMonthlySalary = setAvMonthlySalary();
    }

    @Override
    public double setAvMonthlySalary() {
        double avMonthlySalary = new BigDecimal(20.8 * 8 * hourlyRate).
                setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        return avMonthlySalary;
    }

    @Override
    public String toString() {
        String formattedAvSalary = new DecimalFormat("#0.00").format(getAvMonthlySalary());
        return "Employee{" +
                "id='" + getId()+ '\'' +
                ", name='" + getName() + '\'' +
                ", average monthly salary='" + formattedAvSalary + '\'' +
                "          hourly rate='" + hourlyRate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
