package taskCollections_employees.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    /*General list of employees with auto-incremented id.*/
    public List<Employee> employeeList = new ArrayList<>();
    private int id = 0;

    public void addEmployeeHourly (String name, double hourlyRate){
        incrementId();
        employeeList.add(new EmployeeHourly(this.id, name, hourlyRate));
    }

    public void addEmployeeFixed (String name, double fixedMonthlyPayment){
        incrementId();
        employeeList.add(new EmployeeFixed(this.id, name, fixedMonthlyPayment));
    }

    private int incrementId(){
        return id++;
    }

}
