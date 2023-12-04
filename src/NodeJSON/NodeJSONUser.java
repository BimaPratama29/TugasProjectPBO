package NodeJSON;
import NodeJSON.NodeJSONUser;
public class NodeJSONUser {
    public String uname;
    public String pass;

    public NodeJSONUser(String uname ,String pass) {
        this.pass = pass;
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }

    public NodeJSONUser(){

    }



}
