package Controller;
import java.util.ArrayList;

import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;
import View.MenuSewa;
import View.warna;

public class ControllerUser {
    private ModelUser model;

    public ControllerUser(ModelUser model) {
        this.model = model;
    }

    public void registerUser(String uname, String pass) {
        model.registerUser(uname, pass);
    }

    public void loginUser(String uname, String pass){
        boolean cekLogin = model.loginUser(uname, pass);
        if(cekLogin){
            System.out.println(warna.color_green+ "Anda berhasil login sebagai user"+warna.text_reset);
            MenuSewa.main(null);
        }else{
            System.out.println("Gagal Login");
        }
    }

    public void viewAllUsers() {
        model.viewAllUsers();
    }

    public void updateUser(String unameLama, String passLama, String uname, String newPass) {
        model.updateUser(unameLama, passLama, uname, newPass);
    }

    public void deleteUser(String uname) {
        model.deleteUser(uname);
    }
}

