package Node;

public class NodeUser {
    public String uname;
    public String pass;


    public NodeUser(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;

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
