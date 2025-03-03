import Controller.MainController;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Instância do MainController, responsável pela visualização do sistema rodando
        MainController mainController = new MainController();

        mainController.mainController();
    }
}
