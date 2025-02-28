package Model;

public class UserModel {
    private String name;
    private int accessLevel;

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

    public int getAccessLevel() {
        return accessLevel;
    }
}
