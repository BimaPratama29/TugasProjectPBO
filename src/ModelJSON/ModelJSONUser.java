package ModelJSON;

import Node.NodeUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class ModelJSONUser {
    private String fname = "src/Database/user.json";

    public ModelJSONUser() {
        // Konstruktor, jika diperlukan 
    }

    public void writeToJSON(ArrayList<NodeUser> listUser) {
        JSONArray arrayUser = convertArrayListToJSONArray(listUser);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayUser.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<NodeUser> readFromJSON() {
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayUser = (JSONArray) parser.parse(reader);
            return convertJSONArrayToArrayList(arrayUser);
        } catch (FileNotFoundException e) {
            // File belum ada, atau belum pernah disimpan sebelumnya
            return new ArrayList<>();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONArray convertArrayListToJSONArray(ArrayList<NodeUser> listUser) {
        JSONArray arrayUser = new JSONArray();
        for (NodeUser nUser : listUser) {
            JSONObject objUser = new JSONObject();
            objUser.put("username", nUser.getUname());
            objUser.put("password", nUser.getPass());
            arrayUser.add(objUser);
        }
        return arrayUser;
    }

    private ArrayList<NodeUser> convertJSONArrayToArrayList(JSONArray arrayUser) {
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