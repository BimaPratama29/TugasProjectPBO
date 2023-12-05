package ModelJSON;

import Node.NodeUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class ModelJSONUser {
    public String fname = "src/Database/user.json";

    public ModelJSONUser() {
        // Konstruktor, jika diperlukan
    }

    public void tulisUserKeJSON(NodeUser penggunaBaru) {
        ArrayList<NodeUser> penggunaSudahAda = bacaDariJSON();

        if (penggunaSudahAda == null) {
            penggunaSudahAda = new ArrayList<>();
        }

        penggunaSudahAda.add(penggunaBaru);
        JSONArray arrayPengguna = konversiArrayListkeJSONArray(penggunaSudahAda);

        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayPengguna.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public NodeUser loginPenggunaDariJSON(String username, String password) {
        ArrayList<NodeUser> penggunaSudahAda = bacaDariJSON();

        if (penggunaSudahAda != null) {
            for (NodeUser pengguna : penggunaSudahAda) {
                if (pengguna.getUname().equals(username) && pengguna.getPass().equals(password)) {
                    return pengguna;
                }
            }
        }

        return null; // Pengguna tidak ditemukan
    }

    public ArrayList<NodeUser> bacaDariJSON() {
        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayUser = (JSONArray) parser.parse(reader);
            return convertJSONArraytoArrayList(arrayUser);
        } catch (FileNotFoundException e) {
            // File belum ada, atau belum pernah disimpan sebelumnya
            return null;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONArray konversiArrayListkeJSONArray(ArrayList<NodeUser> listUser) {
        JSONArray arrayUser = new JSONArray();
        for (NodeUser nUser : listUser) {
            JSONObject objUser = new JSONObject();
            objUser.put("username", nUser.getUname());
            objUser.put("password", nUser.getPass());
            arrayUser.add(objUser);
        }
        return arrayUser;
    }

    private ArrayList<NodeUser> convertJSONArraytoArrayList(JSONArray arrayUser) {
        ArrayList<NodeUser> listUser = new ArrayList<>();
        for (Object objUser : arrayUser) {
            JSONObject user = (JSONObject) objUser;
            String uname = (String) user.get("username");
            String pass = (String) user.get("password");
    
            // Pemeriksaan null sebelum menambahkan ke list
            if (uname != null && pass != null) {
                listUser.add(new NodeUser(uname, pass));
            }
        }
        return listUser;
    }
}
