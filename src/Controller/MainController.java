package Controller;

import Model.AdminModel;
import Model.EmployeeModel;
import Model.VisitorModel;
import View.AdminView;
import View.EmployeeView;
import View.MainMenu;
import View.VisitorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner sc = new Scanner(System.in);

    public void mainController() {
        // Declaração de Listas
        List<AdminModel> adminModelList = new ArrayList<>();
        List<VisitorModel> visitorModelList = new ArrayList<>();
        List<EmployeeModel> employeeModelList = new ArrayList<>();

        // Instância das classes
        AdminController adminController = new AdminController(adminModelList);
        AdminView adminView = new AdminView();
        VisitorController visitorController = new VisitorController(visitorModelList);
        VisitorView visitorView = new VisitorView();
        EmployeeController employeeController = new EmployeeController(employeeModelList);
        EmployeeView employeeView = new EmployeeView();
        MainMenu mainMenu = new MainMenu();

        boolean set = true;
        while (set) {
            mainMenu.menuLogin();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    boolean setRegistration = true;
                    while (setRegistration) {
                        mainMenu.menuRegistration();
                        String choiceRegistration = sc.nextLine();
                        switch (choiceRegistration) {
                            case "1":
                                adminView.registrationAdmin(adminController, adminModelList);
                                break;
                            case "2":
                                employeeView.registrationEmployee(employeeController, employeeModelList);
                                break;
                            case "0":
                                setRegistration = false;
                                break;
                            default:
                                break; // Uma simples verificação de case, caso não seja não irá interferir ou quebrar o código
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter your CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Enter your ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    boolean isAdmin = false;
                    for (AdminModel adminModel : adminModelList) {
                        if (adminModel.getCpf().equals(cpf) && adminModel.getId() == id) { // Verifico se os dados preenchidos são referentes a lista do Admin
                            isAdmin = true; // Caso seja, irá retornar TRUE e prosseguir com esse if
                            System.out.println("Admin login successful!\n\n");

                            boolean set2 = true;
                            while (set2) {
                                mainMenu.menuAdmin();

                                String choice2 = sc.nextLine();
                                switch (choice2) {
                                    case "1":
                                        employeeView.registrationEmployee(employeeController, employeeModelList);
                                        break;
                                    case "2":
                                        employeeView.ShowEmployee(employeeController);
                                        break;
                                    case "3":
                                        visitorView.registrationVisitors(visitorController, visitorModelList);
                                        break;
                                    case "4":
                                        visitorView.showVisitors(visitorController);
                                        break;
                                    case "0":
                                        set2 = false;
                                        break;
                                    default:
                                        break; // Uma simples verificação de case, caso não seja não irá interferir ou quebrar o código
                                }
                            }
                            break;
                        }

                    }

                    boolean isEmployee = false;
                    if (!isAdmin) {
                        for (EmployeeModel employeeModel : employeeModelList) {
                            if (employeeModel.getCpf().equals(cpf) && employeeModel.getId() == id) { // Verifico se os dados preenchidos são referentes a lista do Employee
                                isEmployee = true; // Caso seja, irá retornar TRUE e prosseguir com esse if
                                System.out.println("Employee login successful!\n\n");

                                boolean set3 = true;
                                while (set3) {
                                    mainMenu.menuEmployee();

                                    String choice3 = sc.nextLine();
                                    switch (choice3) {
                                        case "1":
                                            visitorView.registrationVisitors(visitorController, visitorModelList);
                                            break;
                                        case "2":
                                            visitorView.showVisitors(visitorController);
                                            break;
                                        case "0":
                                            set3 = false;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            }
                        }
                    }

                    boolean isVisitor = false;
                    if (!isAdmin && !isEmployee) {
                        for (VisitorModel visitorModel : visitorModelList) {
                            if (visitorModel.getCpf().equals(cpf) && visitorModel.getId() == id) { // Verifico se os dados preenchidos são referentes a lista do Visitor
                                isVisitor = true; // Caso seja, irá retornar TRUE e prosseguir com esse if
                                System.out.println("Visitor login successful!\n\n");

                                boolean set4 = true;
                                while (set4) {

                                    mainMenu.menuVisitor();
                                    String choice4 = sc.nextLine();
                                    switch (choice4) {
                                        case "1":
                                            visitorView.aboutMuseum();
                                            System.out.println("\nPress enter for back ...");
                                            sc.nextLine();
                                            break;
                                        case "2":
                                            visitorView.roomsVisitors();
                                            System.out.println("\nPress enter for back ...");
                                            sc.nextLine();
                                            break;
                                        case "0":
                                            set4 = false;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if (!isAdmin && !isEmployee && !isVisitor) {
                        System.out.println("Invalid login credentials!");
                    }
                    break;
                case "0":
                    System.out.println("Exiting ...");
                    set = false;
                    break;
                default:
                    break;
            }
        }
    }
}