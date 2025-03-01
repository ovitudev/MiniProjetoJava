package View;

import Controller.AdminController;
import Model.AdminModel;

import java.util.List;
import java.util.Scanner;

public class AdminView {

    Scanner sc = new Scanner(System.in);
    public void registrationAdmin(AdminController adminController, List<AdminModel> adminModelList){
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

        int id = adminModelList.size() + 1;

        adminController.registrationAdmin(name, cpf, email, id, accessLevel);
    }

    public void showAdministrators(AdminController adminController){
        if (adminController.showAdministrators().isEmpty()){
            System.out.println("Error: no registration found!");
        } else {
            System.out.println("List of Admin:");
            adminController.showAdministrators().forEach(admin ->
                System.out.println(admin)
            );
        }
    }
}
