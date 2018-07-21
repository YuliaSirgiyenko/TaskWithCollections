package taskCollections_employees.services;

import taskCollections_employees.models.Employee;
import taskCollections_employees.models.EmployeeFixed;
import taskCollections_employees.models.EmployeeHourly;

public class LineParser {

    /*Line-by-line parsing of file's data to receive Employee's data with Employee's object creation.*/
    public Employee parseResult(String line){

        Employee employee = null;

        /*Id search.*/
        int startIndex = line.indexOf('\'', 0);
        int endIndex = line.indexOf('\'', startIndex+1);
        int id = Integer.parseInt(line.substring(startIndex+1, endIndex));

        /*Name search.*/
        startIndex = line.indexOf('\'', endIndex+1);
        endIndex = line.indexOf('\'', startIndex+1);
        String name = line.substring(startIndex+1, endIndex);

        /*Search of payment type and creation of respective Employee object.*/
        if (line.contains("fixed monthly payment")){
            startIndex = line.indexOf("t='", endIndex+1);
            endIndex = line.indexOf('\'', startIndex+3);
            double fixedMonthlyPayment = Double.parseDouble(line.substring(startIndex+3, endIndex));
            employee = new EmployeeFixed(id, name, fixedMonthlyPayment);
        } else if (line.contains("hourly rate")) {
            startIndex = line.indexOf("e='", endIndex+1);
            endIndex = line.indexOf('\'', startIndex+3);
            double hourlyRate = Double.parseDouble(line.substring(startIndex+3, endIndex));
            employee = new EmployeeHourly(id, name, hourlyRate);
        }

        return employee;
    }

}
