package Model;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.ArrayList;

public class ModelUser {
   // public static NodeAdmin admin = new NodeAdmin();
    private ArrayList<NodeUser> datausers = new ArrayList<>();


    public ModelUser() {
        datausers = new ArrayList<>();
    }

    public void RegisterUser(String uname , String pass){
        datausers.add(new NodeUser(uname , pass));
    }

    public void ViewAllUserSewa(){
        ArrayList <NodeUser> listuser = new ModelJSONUser().readFromJSON();
        if (listuser != null){
            for (NodeUser user : listuser){
                user.ViewUserSewa();
                System.out.println("===================");
            }
        }
    }
    public ArrayList<NodeUser>getListDatausers(){
        return this.datausers;
    }
}


