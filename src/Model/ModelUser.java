package Model;

import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.ArrayList;

public class ModelUser {
    private ArrayList<NodeUser> datausers = new ArrayList<>();
    private ModelJSONUser modelJSONUser = new ModelJSONUser();

    public ModelUser() {
        datausers = new ArrayList<>();
    }

    public void RegisterUser(String uname, String pass) {
        datausers.add(new NodeUser(uname, pass));
        modelJSONUser.tulisUserKeJSON(new NodeUser(uname, pass));
    }

    public void ViewAllUserSewa() {
        ArrayList<NodeUser> listuser = modelJSONUser.readFromJSON{}
        if (listuser != null) {
            for (NodeUser user : listuser) {
                user.ViewUserSewa();
                System.out.println("===================");
            }
        }
    }

    public ArrayList<NodeUser> getListDatausers() {
        return this.datausers;
    }
}
