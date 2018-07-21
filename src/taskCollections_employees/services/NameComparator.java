package taskCollections_employees.services;

import taskCollections_employees.models.Employee;

import java.util.Comparator;

/*Comparing of Employees list by name.*/
public class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        if (o1.getName().compareTo(o2.getName()) > 1){
            return 1;
        } else if (o1.getName().compareTo(o2.getName()) < 1) {
            return -1;
        } else {
            return 0;
        }
    }

}
