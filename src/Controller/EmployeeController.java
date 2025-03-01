package Controller;

import Model.EmployeeModel;

import java.util.List;

public class EmployeeController {
    private EmployeeModel employeeModel;
    List<EmployeeModel> employeeModelList;

    public EmployeeController(List<EmployeeModel> employeeModelList){
        this.employeeModelList = employeeModelList;
    }

    public void registrationEmployee(String name, String cpf, String email, int id, int accessLevel){
        EmployeeModel employeeModel = new EmployeeModel(name, cpf, email, id, accessLevel);
        employeeModelList.add(employeeModel);
    }
    public List<EmployeeModel> showEmplooyes(){
        return  employeeModelList;
    }
}
