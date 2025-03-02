package View;

import Controller.EmployeeController;
import Model.EmployeeModel;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {

    public void registrationEmployee(EmployeeController employeeController, List<EmployeeModel> employeeModelList){
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        if(name.matches(".*\\d.*")){
            System.out.println("Error: Your name has invalid characters!");
            return;
        } else if (name.length() < 3) {
            System.out.println("Error: Your name has invalid number of characters!");
            return;
        }

        System.out.print("Enter the cpf: ");
        String cpf = sc.nextLine();
        if(cpf.length() < 11 || cpf.length() > 14){
            System.out.println("Error: CPF is invalid!");
            return;
        } else if(cpf.matches(".*[a-zA-Z].*")){
            System.out.println("Error: Your cpf has invalid characters!");
            return;
        }

        System.out.print("Enter a e-mail: ");
        String email = sc.nextLine();
        if(!email.contains("@") || email.length() < 6){
            System.out.println("Error: E-mail is invalid!");
            return;
        }

        System.out.print("Enter the level access: ");
        int accessLevel = sc.nextInt();

        sc.nextLine();

        int id = employeeModelList.size() + 1 ;

        employeeController.registrationEmployee(name,cpf,email,id,accessLevel);

    }

    public void ShowEmployee(EmployeeController employeeController){
        if(employeeController.showEmplooyes().isEmpty()){
            System.out.println("Error: no registration found!");
        }else{
            System.out.println("List of employees: ");
            employeeController.showEmplooyes().forEach(employee ->
                    System.out.println(employee)
            );
        }
    }
}