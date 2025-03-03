package Model;

// Classe filha de administrador, nela declaramos o construtor e um metodo sobrescrito de suas características
public class AdminModel extends UserModel{
    public AdminModel(String name, String cpf, String email, int id, int accessLevel) {
        super(name, cpf, email, id, accessLevel);
    }

    // Metódo sobrescrito que irá apresentar as características do usuário de tipo Administrador
    @Override
    public String toString(){
        return super.toString();
    }
}
