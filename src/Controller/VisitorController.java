package Controller;

import Model.VisitorModel;

import java.util.List;

public class VisitorController {
    List<VisitorModel> visitorModelList;

    public VisitorController(List<VisitorModel> visitorModelList) {
        this.visitorModelList = visitorModelList;
    }

    public void registrationVisitor(String name, String cpf, String email, int id, int accessLevel){
        VisitorModel visitorModel = new VisitorModel(name, cpf, email, id, accessLevel);
        visitorModelList.add(visitorModel);
    }

    public List<VisitorModel> showVisitors(){
        return visitorModelList;
    }
}
