package Model;

public class VisitorModel extends UserModel{
    public VisitorModel(String name, String cpf,String email, int id, int accessLevel) {
        super(name, cpf, email, id, accessLevel);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
