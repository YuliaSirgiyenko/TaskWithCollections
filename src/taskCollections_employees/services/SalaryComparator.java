package taskCollections_employees.services;

import taskCollections_employees.models.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAvMonthlySalary() < o2.getAvMonthlySalary()){
            return 1;
        } else if (o1.getAvMonthlySalary() > o2.getAvMonthlySalary()) {
            return -1;
        } else {
            return 0;
        }
    }

}
