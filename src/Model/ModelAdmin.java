package Model;

import Node.NodeAdmin;

public class ModelAdmin {
   NodeAdmin admin;

    public ModelAdmin() {
        this.admin = new NodeAdmin();
    }

    public Boolean cekLogin(String user, String pass1) {
        return admin.getAdmin().equals(user) && admin.getPass1().equals(pass1);
    } 
}
