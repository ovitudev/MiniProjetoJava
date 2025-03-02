import Controller.AdminController;
import Controller.EmployeeController;
import Controller.VisitorController;
import Model.AdminModel;
import Model.EmployeeModel;
import Model.VisitorModel;
import View.AdminView;
import View.EmployeeView;
import View.VisitorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<AdminModel> adminModelList = new ArrayList<>();
        List<VisitorModel> visitorModelList = new ArrayList<>();
        List<EmployeeModel> employeeModelList = new ArrayList<>();


        AdminController adminController = new AdminController(adminModelList);
        AdminView adminView = new AdminView();
        VisitorController visitorController = new VisitorController(visitorModelList);
        VisitorView visitorView = new VisitorView();
        EmployeeController employeeController = new EmployeeController(employeeModelList);
        EmployeeView employeeView = new EmployeeView();

        boolean set = true;
        while (set) {
            System.out.print("""
                    1 - Sign up
                    2 - Login
                    0 - Exit
                    """);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Which do you want to register? Administrator or Employee");
                    String desire = sc.nextLine().toLowerCase();
                    if (desire.equals("administrator")) {
                        adminView.registrationAdmin(adminController, adminModelList);
                    } else if (desire.equals("employee")) {
                        employeeView.registrationEmployee(employeeController, employeeModelList);
                    } else {
                        System.out.println("There is no such record!");
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
                        if (adminModel.getCpf().equals(cpf) && adminModel.getId() == id) {
                            isAdmin = true;
                            System.out.println("Admin login successful!\n\n");

                            boolean set2 = true;
                            while (set2) {
                                System.out.print("""
                                        1 - Registration Employee
                                        2 - Show Employees
                                        3 - Registration Visitors
                                        4 - Show Visitors
                                        0 - Exit
                                        Choose an option:
                                        """);
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
                                        break;
                                }
                            }
                            break;
                        }
                    }

                    boolean isEmployee = false;
                    if (!isAdmin) {
                        for (EmployeeModel employeeModel : employeeModelList) {
                            if (employeeModel.getCpf().equals(cpf) && employeeModel.getId() == id) {
                                isEmployee = true;
                                System.out.println("Employee login successful!\n\n");

                                boolean set3 = true;
                                while (set3) {
                                    System.out.print("""
                                            --------------- Employee Menu ---------------
                                            1 - Register Visitors
                                            2 - Show Visitors
                                            0 - Exit
                                            Choose an option:
                                            """);
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
                            if (visitorModel.getCpf().equals(cpf) && visitorModel.getId() == id) {
                                isVisitor = true;
                                System.out.println("Visitor login successful!\n\n");

                                boolean set4 = true;
                                while (set4) {
                                    System.out.print("""
                                            --------------- Welcome to Eagle Museum ---------------
                                            1 - About the museum
                                            2 - Rooms
                                            0 - Exit
                                            Choose an option:
                                            """);
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
        adminView.showAdministrators(adminController);
    }
}