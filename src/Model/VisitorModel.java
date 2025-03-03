package Model;

// Classe filha de visitantes, nela declaramos o construtor e um metodo sobrescrito de suas características
public class VisitorModel extends UserModel{
    public VisitorModel(String name, String cpf,String email, int id, int accessLevel) {
        super(name, cpf, email, id, accessLevel);
    }

    // Metódo sobrescrito que irá apresentar as características do usuário de tipo Visitante
    @Override
    public String toString(){
        return super.toString();
    }
}
