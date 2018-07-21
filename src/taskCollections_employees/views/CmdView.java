package taskCollections_employees.views;

import taskCollections_employees.models.Employee;
import java.util.List;

public class CmdView {

    /*Console out for the whole collection*/
    public void showAll(List<Employee> list){
        for (Employee i : list) {
            System.out.println(i);
        }
    }

    /*Console out for definite numbers from beginning of collection*/
    public void showFirstNumbers(List<Employee> list, int numbFromBegin){
        for(int i = 0; i < numbFromBegin; i++){
            System.out.println(list.get(i));
        }
    }

    /*Console out for definite numbers from end of collection*/
    public void showIdLastNumbers(List<Employee> list, int numbFromEnd){
        for(int i = list.size()-numbFromEnd; i < list.size(); i++){
            System.out.print(list.get(i).getId() + ", ");
        }
    }

}
