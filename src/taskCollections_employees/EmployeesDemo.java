package taskCollections_employees;

import taskCollections_employees.models.Employee;
import taskCollections_employees.models.EmployeeList;
import taskCollections_employees.services.NameComparator;
import taskCollections_employees.services.SalaryComparator;
import taskCollections_employees.views.CmdView;
import taskCollections_employees.views.FSView;

import java.util.*;

public class EmployeesDemo {

    public static void main (String[] args) {

        /*Creation of collection for demo with out to console.*/
        EmployeeList list = new EmployeeList();
        list.addEmployeeHourly("Yulia", 18);
        list.addEmployeeHourly("Bob0", 10);
        list.addEmployeeHourly("Bob1", 15);
        list.addEmployeeHourly("John", 18);
        list.addEmployeeHourly("Peter", 20);
        list.addEmployeeFixed("Terry", 2995.20);
        list.addEmployeeFixed("Den1", 2500);
        list.addEmployeeFixed("Den2", 3328);
        list.addEmployeeFixed("Anna", 2995.20);

        CmdView cmd = new CmdView();
        System.out.println("Initial list:");
        cmd.showAll(list.employeeList);

        /*Sorting of collection.*/
        System.out.println("\nTask a - sorted by average salary (descending) and by name (in case of equal salary):");
        Comparator<Employee> comp = new SalaryComparator().thenComparing(new NameComparator());
        Collections.sort(list.employeeList, comp);
        cmd.showAll(list.employeeList);

        /*Console out of definite parts of collection.*/
        System.out.println("\nTask b - write information about first five employees from sorted collection:");
        cmd.showFirstNumbers(list.employeeList, 5);
        System.out.print("\nTask C - write ID of three last employees from sorted collection: ");
        cmd.showIdLastNumbers(list.employeeList, 3);

        /*Demo of writing into file / reading from file..*/
        System.out.println("\nTask D - Write code for reading and writing collection of these objects from (into) file).");
        FSView file = new FSView();
        file.writeAll(list.employeeList);
        cmd.showAll(file.readAll());

    }

}
