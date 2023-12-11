package Model;

import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.ArrayList;
import Node.NodeUser;

public class ModelUser {
    private ArrayList<NodeUser> datausers;
    private ModelJSONUser modelJSONUser;

    public ModelUser() {
        datausers = new ArrayList<>();
        modelJSONUser = new ModelJSONUser();
        loadUsers();
    }

    private void loadUsers() {
        datausers = modelJSONUser.readFromJSON();
    }

    public void registerUser(String uname, String pass) {
        datausers.add(new NodeUser(uname, pass));
        modelJSONUser.writeToJSON(datausers);
    }

    public void viewAllUsers() {
        for (NodeUser user : datausers) {
            user.viewUser();
            System.out.println("===================");
        }
    }

    public void updateUser(String uname, String newPass) {
        for (NodeUser user : datausers) {
            if (user.getUname().equals(uname)) {
                user.setPass(newPass);
                modelJSONUser.writeToJSON(datausers);
                System.out.println("User berhasil diupdate.");
                return;
            }
        }
        System.out.println("User tidak ditemukan.");
    }

    public void deleteUser(String uname) {
        NodeUser userToRemove = null;
        for (NodeUser user : datausers) {
            if (user.getUname().equals(uname)) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            datausers.remove(userToRemove);
            modelJSONUser.writeToJSON(datausers);
            System.out.println("User berhasil dihapus.");
        } else {
            System.out.println("User tidak ditemukan.");
        }
    }
}
