package ModelJSON;

import Node.NodeUser;
import NodeJSON.NodeJSONUser;
import NodeJSON.NodeJSONSewa;
import NodeJSON.NodeJSONUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModelJSONUser {
    NodeJSONUser nodeJSONUser = new NodeJSONUser();
    static Scanner input = new Scanner(System.in);
    public String fname = "src/Database/user.json";

    public boolean cekFile() {
        boolean cek = false;
        File file = new File(this.fname);
        if (file.exists()){
            cek = true;
        }else{

        }
        return  cek;
    }

    public JSONArray convertArrayListtoJSONArray(ArrayList<NodeUser> listUser){
        if(listUser == null){
            return null;
        }else{
         JSONArray arrayUser = new JSONArray();
         for(NodeUser nUser : listUser){
             JSONObject objUser = new JSONObject();
             objUser.put(nodeJSONUser.getUname(),nUser.getUname());
             objUser.put(nodeJSONUser.getPass(),nUser.getPass());
             arrayUser.add(objUser);
         }
         return arrayUser;
        }
    }

    public void writeFileJSON(ArrayList <NodeUser> listuser){
        JSONArray arrayUser = convertArrayListtoJSONArray(listuser);
        try{
            FileWriter file = new FileWriter(fname);
            file.write(arrayUser.toJSONString());
            file.flush();
            file.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList <NodeUser> convertJSONArraytoArrayList (JSONArray arrayUser){
        if (arrayUser == null){
            return  null;
        }
        else{
            ArrayList <NodeUser> listUser = new ArrayList<>();
            for (Object objUser : arrayUser){
                JSONObject User = (JSONObject) objUser;
                String uname = User.get("username").toString();
                String pass = User.get("password").toString();
                listUser.add(new NodeUser(uname,pass));
            }
            return listUser;
        }
    }

    public ArrayList <NodeUser> readFromJSON(){
        if(cekFile() == false){
            return null;
        }
        ArrayList listUser = null;
        JSONParser parser = new JSONParser();

        try{
            Reader reader = new FileReader(fname);
            JSONArray arrayUser = (JSONArray) parser.parse(reader);
            listUser = convertJSONArraytoArrayList(arrayUser);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }
        catch (ParseException e){
            throw  new RuntimeException(e);
        }
        return listUser;
    }

}
