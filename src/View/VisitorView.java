package View;

import Controller.AdminController;
import Controller.VisitorController;
import Model.VisitorModel;

import java.util.List;
import java.util.Scanner;

public class VisitorView {
    // Instância do leitor para entrada de dados do usuário
    Scanner sc = new Scanner(System.in);

    // Metódo responsável por realizar o cadastro de um usuário do tipo Visitante, pedindo o parâmetro da classe
    // VisitorController e da Listra do construtor dessa classe
    public void registrationVisitors(VisitorController visitorController, List<VisitorModel> visitorModelList) {
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
        int id = visitorModelList.size() + 1;

        // Passo as informações digitas pelo usuário para a lista de Visitantes
        visitorController.registrationVisitor(name, cpf, email, id, accessLevel);
    }

    // Metódo responsável por exibir a lista de Visitantes cadastrados
    // Como citei anteriormente, acredito que seria uma boa regra de negócio se os mesmos já fossem pré-cadastrados no
    // sistema, pois dessa forma iriamos garantir veracidade nas informações e diminuir brechas para golpes!
    // Mas de forma temporária, fizemos dessa maneira, como uma solução inicial da demanda!!!
    public void showVisitors(VisitorController visitorController) {

        //Verifica se a lista está vazia, se sim apresenta uma mensagem, se não, apresenta a lista de Visitantes
        if (visitorController.showVisitors().isEmpty()) {
            System.out.println("Error: no registration found!");
        } else {
            System.out.println(" list of  Visitors:");
            visitorController.showVisitors().forEach(visitors ->
                    System.out.println(visitors)
            );
        }
    }

    // Apenas um exemplo do que o Visitante irá conseguir visualizar
    public void aboutMuseum() {
        System.out.println("""
                No coração da serra, entre montanhas imponentes e vales profundos, ergue-se o Museu das Águias, \
                um santuário dedicado à majestade e ao simbolismo dessas aves magníficas. Fundado em 1923 pelo ornitólogo e \
                explorador Sir Edmund Hawkley, o museu é um tesouro escondido para amantes da natureza, história e mitologia.
                O museu também abriga um laboratório de pesquisa, onde biólogos e conservacionistas trabalham para proteger \
                essas aves e seus habitats. A loja do museu oferece lembranças únicas, como penas artificiais, réplicas de \
                esculturas e livros sobre a vida desses predadores alados.
               \s
                O Museu das Águias não é apenas um local de exposição, mas um tributo à força, liberdade e beleza das águias,
                inspirando todos que passam por suas portas a olhar para o céu com admiração e respeito.""");
    }

    // Apenas um exemplo do que o Visitante irá conseguir visualizar
    public void roomsVisitors(){
        System.out.println("""
                A Sala das Espécies: Uma coleção de esculturas e dioramas que representam as mais de 60 espécies de águias
                do mundo, desde a imponente Águia-dourada até a rara Águia-filipina.
                
                O Núcleo Histórico: Artefatos antigos, como moedas, brasões e armaduras, que mostram como as águias foram
                símbolos de poder e proteção ao longo da história.
                
                As Asas da Mitologia: Uma exposição interativa que explora o papel das águias em mitologias grega, romana,
                nórdica e indígena, com destaque para o mito de Zeus e sua águia mensageira.
                
                O Mirante do Voo: Um espaço ao ar livre, no topo do museu, onde os visitantes podem observar águias reais
                em voo livre, graças a um programa de conservação e reintrodução da espécie na região.
                """);
    }
}
