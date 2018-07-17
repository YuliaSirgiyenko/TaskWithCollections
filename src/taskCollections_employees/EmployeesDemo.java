package taskCollections_employees;

import taskCollections_employees.models.Employee;
import taskCollections_employees.models.EmployeeFixed;
import taskCollections_employees.models.EmployeeHourly;
import taskCollections_employees.services.NameComparator;
import taskCollections_employees.services.SalaryComparator;
import taskCollections_employees.views.CmdView;
import taskCollections_employees.views.FSView;

import java.util.*;

public class EmployeesDemo {

    public static void main (String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeHourly(9, "Yulia", 18));
        employeeList.add(new EmployeeHourly(1, "Bob0", 10));
        employeeList.add(new EmployeeHourly(2, "Bob1", 15));
        employeeList.add(new EmployeeHourly(3, "John", 18));
        employeeList.add(new EmployeeHourly(4, "Peter", 20));
        employeeList.add(new EmployeeFixed(5, "Terry", 2995.20));
        employeeList.add(new EmployeeFixed(6, "Den1", 2500));
        employeeList.add(new EmployeeFixed(7, "Den2", 3328));
        employeeList.add(new EmployeeFixed(8, "Anna", 2995.20));

        CmdView cmd = new CmdView();
        System.out.println("Initial list:");
        cmd.showAll(employeeList);

        System.out.println("\nTask a - sorted by average salary (descending) and by name (in case of equal salary):");
        Comparator<Employee> comp = new SalaryComparator().thenComparing(new NameComparator());
        Collections.sort(employeeList, comp);
        cmd.showAll(employeeList);

        System.out.println("\nTask b - write information about first five employees from collection (problem a):");
        cmd.showFromTo(employeeList, 0,4);

        System.out.print("\nTask C - write ID of three last employees from collection (problem b): ");
        cmd.showIdFromTo(employeeList, 2,4);

        System.out.println("\nTask D - Write code for reading and writing collection of these objects from (into) file).");
        FSView file = new FSView();
        file.writeAll(employeeList);
        cmd.showAll(file.readAll());

    }

}
