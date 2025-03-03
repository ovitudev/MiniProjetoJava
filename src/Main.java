import Controller.AdminController;
import Controller.EmployeeController;
import Controller.MainController;
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

        MainController mainController = new MainController();
        mainController.mainController();
    }
}
