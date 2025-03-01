import Controller.AdminController;
import Model.AdminModel;
import View.AdminView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<AdminModel> adminModelList = new ArrayList<>();


        AdminController adminController = new AdminController(adminModelList);
        AdminView adminView = new AdminView();

        String choice;
        do {
            adminView.registrationAdmin(adminController, adminModelList);
            choice = sc.nextLine();
        } while (!choice.equals("0"));
        adminView.showAdministrators(adminController);
    }
}