package View;

import Controller.EmployeeController;
import Model.EmployeeModel;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    // Instância do leitor para entrada de dados do usuário
    Scanner sc = new Scanner(System.in);

    // Metódo responsável por realizar o cadastro de um usuário do tipo Funcionário, pedindo o parâmetro da classe
    // EmployeeController e da Listra do construtor dessa classe
    public void registrationEmployee(EmployeeController employeeController, List<EmployeeModel> employeeModelList) {
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        // Verificação responsável por analisar se há números na String digitada pelo usuário
        if (name.matches(".*\\d.*")) {
            System.out.println("Error: Your name has invalid characters!");
            return; // Se tiver, será apresentada essa mensagem de que há characters inválidos e retornara para o início
        } else if (name.length() < 3) {
            System.out.println("Error: Your name has invalid number of characters!");
            return; // Caso seja menor, apresentar mensagem de quantidade characters pequeno e retorna para o início
        }

        System.out.print("Enter the cpf: ");
        String cpf = sc.nextLine();
        // Verifica o tamanho mínimo e máximo do CPF, em casos de ser com ou sem máscara
        // Futuramente, poderemos incrementar com uma verificação mais real, validando o cálculo do CPF real
        if (cpf.length() < 11 || cpf.length() > 14) {
            System.out.println("Error: CPF is invalid!");
            return; // Caso não corresponda ao tamanho, irá retornar
        }
        // Verificação responsável por validar se há letras inclusas na String do CPF
        else if (cpf.matches(".*[a-zA-Z].*")) {
            System.out.println("Error: Your cpf has invalid characters!");
            return; // Caso tenha, irá retornar o erro e levar a pessoa para o início!
        }

        System.out.print("Enter a e-mail: ");
        String email = sc.nextLine();
        // Verificação responsável por validar se o e-mail contém o @ (para domínios) e o mínimo do tamanho de um e-mail
        if (!email.contains("@") || email.length() < 6) {
            System.out.println("Error: E-mail is invalid!");
            return; // Caso não, apresenta erro e retorna ao início
        }

        System.out.print("Enter the level access: ");
        int accessLevel = sc.nextInt();

        sc.nextLine();

        // Meio temporário de um id autoincrement, através do tamanho da lista
        int id = employeeModelList.size() + 1;

        // Passo as informações digitas pelo usuário para a lista de Employee
        employeeController.registrationEmployee(name, cpf, email, id, accessLevel);
    }

    // Metódo responsável por exibir a lista de Employee cadastrados
    // Como citei anteriormente, acredito que seria uma boa regra de negócio se os mesmos já fossem pré-cadastrados no
    // sistema, pois dessa forma iriamos garantir veracidade nas informações e diminuir brechas para golpes!
    // Mas de forma temporária, fizemos dessa maneira, como uma solução inicial da demanda!!!
    public void ShowEmployee(EmployeeController employeeController) {

        //Verifica se a lista está vazia, se sim apresenta uma mensagem, se não, apresenta a lista de Employee
        if (employeeController.showEmplooyes().isEmpty()) {
            System.out.println("Error: no registration found!");
        } else {
            System.out.println("List of employees: ");
            employeeController.showEmplooyes().forEach(employee ->
                    System.out.println(employee)
            );
        }
    }
}