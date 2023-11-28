package ModelJSON;

import Node.NodeAdmin;
import Node.NodeUserSewa;
import NodeJSON.NodeJSONSewa;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelJSONAdmin {
    public String userf;
    NodeJSONSewa nodeJSONSewa = new NodeJSONSewa();

    public ModelJSONAdmin() {
        this.userf = "src/Database/admin.json";
    }

    public boolean cekFile() {
        boolean cek = false;
        File file = new File(this.userf);
        if (file.exists()){
            cek = true;
        }else{

        }
        return  cek;
    }

    public JsonArray convertArrayListtoJSONArray(ArrayList<NodeUserSewa> listuser) {
        if (listuser == null) {
            return null;
        } else {
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < listuser.size(); i++) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.put(nodeJSONSewa.nama_sewa, listuser.get(i).nama_sewa);
                jsonObject.put(nodeJSONSewa.kode_sewa, listuser.get(i).kode_sewa);
                jsonObject.put(nodeJSONSewa.unitGame, listuser.get(i).unitGame);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }
    }
    public
}

