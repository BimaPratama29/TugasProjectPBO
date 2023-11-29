package Model;

import Node.NodeLoginAdmin;

public class ModelLoginAdmin {
    NodeLoginAdmin admin;

    public ModelLoginAdmin() {
        this.admin = new NodeLoginAdmin();
    }

    public Boolean cekLogin(String user, String pass1) {
        return admin.getAdmin().equals(user) && admin.getPass1().equals(pass1);
    }
}
