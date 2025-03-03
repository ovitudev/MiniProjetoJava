package Model;

// Classe mãe que será herdada pelas classes filhas
public class UserModel {

    // Declaração de atributos dos usuários
    private String name       ;
    private String cpf        ;
    private String email      ;
    private int    id         ;

    // O atributo accessLevel foi usado apenas para um meio de podermos visualizar qual o nível de acesso do usuário.
    // Mas futuramente esperamos não precisar definir essa variável dessa forma, e sim realizar como feito no programa.
    // No caso utilizando exatamente esse meio, mas já definindo o usuário Administrador para que apenas o mesmo realize
    // outros cadastros no sistema!
    private int    accessLevel;

    // Construtor, denominando seus atributos
    // Obs. Interna: Sempre vejo o construtor como um tipo de Struct que geralmente utilizamos em outras linguagens
    public UserModel(String name, String cpf, String email, int id, int accessLevel) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    // Abaixo temos os Getters e Setters, sendo os Setters responsáveis por atribuir valores aos atributos e os
    // Setters por apresentar esses valores
    public String getName() {
        return name;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Metódo do tipo toString responsável por apresentar os Getters definidos, porém por essa ser a classe mãe,
    // apenas definimos uma forma de como as informações seriam apresentadas.
    public String toString(){
        return "Name: " + getName() + ", CPF: " + getCpf() + ", E-mail: " + getEmail() + ", ID: " + getId();
    }
}
