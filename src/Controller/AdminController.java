package Controller;

import Model.AdminModel;

import java.util.List;

public class AdminController {
    private AdminModel adminModel;

    List<AdminModel> adminModelList;

    public AdminController(List<AdminModel> adminModelList) {
        this.adminModelList = adminModelList;
    }

    public void registrationAdmin(String name, String cpf, String email, int id, int accessLevel){
        AdminModel adminModel = new AdminModel(name, cpf, email, id, accessLevel);
        adminModelList.add(adminModel);
    }

    public List<AdminModel> showAdministrators(){
        return adminModelList;
    }
}
