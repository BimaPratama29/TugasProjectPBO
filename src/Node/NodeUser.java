package Node;

public class NodeUser {
    public String uname;
    public String pass;


    public NodeUser(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;

    }
    public NodeUser(){

    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void ViewUserSewa(){
        System.out.println("Username : " + this.uname);
        System.out.println("Password : " + this.pass);
    }

    public String getUname() {
        return this.uname;
    }
    public String getPass() {
        return this.pass;
    }
    public void viewUser() {
    }
}
