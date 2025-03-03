package Model;

// Classe filha de funcionários, nela declaramos o construtor e um metodo sobrescrito de suas características
public class EmployeeModel extends UserModel{
    public EmployeeModel(String name, String cpf, String email, int id, int accessLevel) {
        super(name,cpf, email, id , accessLevel);
    }

    // Metódo sobrescrito que irá apresentar as características do usuário de tipo Funcionário
    @Override
    public String toString(){
        return super.toString();
    }
}
