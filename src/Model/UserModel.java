package Model;

public class UserModel {
    private String name       ;
    private String cpf        ;
    private String email      ;
    private int    id         ;
    private int    accessLevel;

    public UserModel(String name, String cpf, String email, int id, int accessLevel) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    public UserModel(String name, int accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public String toString(){
        return "Name: " + getName() + ", CPF: " + getCpf() + ", E-mail: " + getEmail() + ", ID: " + getId();
    }
}
