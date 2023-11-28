package Node;

public class NodeUser {
    public String uname;
    public String pass;


    public NodeUser(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;

    }

    public void ViewUserSewa(){
        System.out.println("Username : " + this.uname);
        System.out.println("Password : " + this.pass);
    }

    public String getUname() {
        return uname;
    }
    public String getPass() {
        return pass;
    }

    public class admin extends NodeUser {
        public admin(String uname, String pass) {
            super(uname, pass);
        }
    }


}
