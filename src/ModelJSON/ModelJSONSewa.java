package ModelJSON;

import NodeJSON.NodeJSONSewa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelJSONSewa {
    private String fname = "src/Database/sewabarang.json";
    List<NodeJSONSewa> dataSewa;

    public ModelJSONSewa() {
        this.dataSewa = readFromJSON();
    }

    public void writeToJSON(List<NodeJSONSewa> dataSewa) {
        try (FileWriter file = new FileWriter(fname)) {
            JSONArray arraySewa = convertListToJSONArray(dataSewa);
            file.write(arraySewa.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write to JSON file: " + e.getMessage());
        }
    }

    public List<NodeJSONSewa> readFromJSON() {
        // Implementasi pembacaan dari JSON
        // ...

        return new ArrayList<>();
    }

    private JSONArray convertListToJSONArray(List<NodeJSONSewa> dataSewa) {
        JSONArray arraySewa = new JSONArray();
        for (NodeJSONSewa sewa : dataSewa) {
            JSONObject objSewa = new JSONObject();
            objSewa.put("kodeBarang", sewa.kodeBarang);
            objSewa.put("namaBarang", sewa.namaBarang);
            objSewa.put("username", sewa.username);
            arraySewa.add(objSewa);
        }
        return arraySewa;
    }

    public void tambahDataJSON(NodeJSONSewa sewa) {
        try {
            // Read existing data
            List<NodeJSONSewa> dataSewa = readFromJSON();

            // Add new data
            dataSewa.add(sewa);

            // Write back to JSON file
            writeToJSON(dataSewa);
            System.out.println("Data sewa added successfully and written to the JSON file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
