import ModelJSON.ModelJSONAdmin;
import org.w3c.dom.Node;

import java.sql.SQLOutput;
import java.util.ArrayList;

import ModelJSON.ModelJSONAdmin;
import Node.NodeAdmin;

public class Main {
    public static void main(String[] args) {
        //cek file
        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        System.out.println(modelJSONAdmin.cekFile());

        //convert arraylist ke jsonarray
        ArrayList<NodeUserSewa>list = null;
        //System.out.println(modelJSONAdmin.convertArrayListtoJSONArray(list));

        ArrayList<NodeUserSewa>listuser1 = new ArrayList<>();
        listuser1.add(new NodeUserSewa("admin1","polo"));
        listuser1.add(new NodeUserSewa("admin2","polo2"));
        modelJSONAdmin.writeJSON(listuser1);
    }
}