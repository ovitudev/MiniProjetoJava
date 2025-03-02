package View;

import Controller.AdminController;
import Controller.VisitorController;
import Model.VisitorModel;

import java.util.List;
import java.util.Scanner;

public class VisitorView {
    Scanner sc = new Scanner(System.in);

    public void registrationVisitors(VisitorController visitorController, List<VisitorModel> visitorModelList) {
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        if (name.matches(".*\\d.*")) {
            System.out.println("Error: Your name has invalid characters!");
            return;
        } else if (name.length() < 3) {
            System.out.println("Error: Your name has invalid number of characters!");
            return;
        }

        System.out.print("Enter the cpf: ");
        String cpf = sc.nextLine();
        if (cpf.length() < 11 || cpf.length() > 14) {
            System.out.println("Error: CPF is invalid!");
            return;
        } else if (cpf.matches(".*[a-zA-Z].*")) {
            System.out.println("Error: Your cpf has invalid characters!");
            return;
        }

        System.out.print("Enter a e-mail: ");
        String email = sc.nextLine();
        if (!email.contains("@") || email.length() < 6) {
            System.out.println("Error: E-mail is invalid!");
            return;
        }

        System.out.print("Enter the level access: ");
        int accessLevel = sc.nextInt();

        sc.nextLine();

        int id = visitorModelList.size() + 1;

        visitorController.registrationVisitor(name, cpf, email, id, accessLevel);
    }

    public void showVisitors(VisitorController visitorController) {
        if (visitorController.showVisitors().isEmpty()) {
            System.out.println("Error: no registration found!");
        } else {
            System.out.println("List of Admin:");
            visitorController.showVisitors().forEach(visitors ->
                    System.out.println(visitors)
            );
        }
    }

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
