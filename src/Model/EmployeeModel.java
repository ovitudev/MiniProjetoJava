package Model;

public class EmployeeModel extends UserModel{
    public EmployeeModel(String name, String cpf, String email, int id, int accessLevel) {
        super(name,cpf, email, id , accessLevel);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
