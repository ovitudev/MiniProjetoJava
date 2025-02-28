package Controller;

import Model.AdminModel;
import View.AdminView;

public class AdminController {
    private AdminModel adminModel;
    private AdminView  adminView ;

    public AdminController(AdminModel adminModel, AdminView adminView) {
        this.adminModel = adminModel;
        this.adminView = adminView;
    }

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

}
