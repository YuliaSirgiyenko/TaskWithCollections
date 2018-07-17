package taskCollections_employees.views;

import taskCollections_employees.models.Employee;
import java.util.List;

public class CmdView {

    public void showAll(List<Employee> list){
        for (Employee i : list) {
            System.out.println(i);
        }
    }

    public void showFromTo(List<Employee> list, int firstNumber, int lastNumber){
        for(int i = firstNumber; i <= lastNumber; i++){
            System.out.println(list.get(i));
        }
    }

    public void showIdFromTo(List<Employee> list, int firstNumber, int lastNumber){
        for(int i = firstNumber; i <= lastNumber; i++){
            System.out.print(list.get(i).getId() + ", ");
        }
    }

}
