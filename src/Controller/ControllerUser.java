package Controller;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

public class ControllerUser {
    private ModelUser model;

    public ControllerUser(ModelUser model) {
        this.model = model;
    }

    public void registerUser(String uname, String pass) {
        model.registerUser(uname, pass);
    }

    public void viewAllUsers() {
        model.viewAllUsers();
    }

    public void updateUser(String uname, String newPass) {
        model.updateUser(uname, newPass);
    }

    public void deleteUser(String uname) {
        model.deleteUser(uname);
    }
}

