package taskCollections_employees.views;

import taskCollections_employees.businessExceptions.RecordFormatException;
import taskCollections_employees.models.Employee;
import taskCollections_employees.services.LineParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FSView {

    private static final File FILE = new File("EmployeesList");

    public FSView(){
        if (!FILE.exists()){
            try {
                FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void writeAll(List<Employee> list){
        try (FileWriter writer = new FileWriter(FILE, true)){
            for (Employee i : list) {
                writer.write(i.toString()+ "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> readAll(){
        List<Employee> readedList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))){

            LineParser lp = new LineParser();
            Employee employee;
            String line;
            while ((line = reader.readLine()) != null) {
                employee = lp.parseResult(line);
                if (employee == null) {
                    throw new RecordFormatException();
                } else {
                    readedList.add(employee);
                }
            }

        } catch (RecordFormatException | NumberFormatException e) {
            System.out.println("Incorrect format of incoming file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readedList;
    }

}
