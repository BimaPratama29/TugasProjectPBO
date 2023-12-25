package ModelJSON;

import Node.NodeBarang;
import NodeJSON.NodeJSONSewa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelJSONBarang {
    private static final String FILE_PATH_BARANG = "src/Database/barang.json";

    @SuppressWarnings("unchecked")
    public List<NodeBarang> readFromJSON() {
        List<NodeBarang> stokBarang = new ArrayList<>();

        try (FileReader reader = new FileReader(FILE_PATH_BARANG)) {
            // Read JSON file
            JSONObject jsonObject = (JSONObject) new org.json.simple.parser.JSONParser().parse(reader);

            // Get stokbarang array from JSON
            JSONArray stokBarangArray = (JSONArray) jsonObject.get("stokbarang");

            // Iterate over stokbarang array and add each node to the list
            Iterator<JSONObject> iterator = stokBarangArray.iterator();
            while (iterator.hasNext()) {
                JSONObject nodeObject = iterator.next();
                NodeBarang nodeBarang = new NodeBarang(
                        (String) nodeObject.get("kodeBarang"),
                        (String) nodeObject.get("namaBarang"),
                        ((Long) nodeObject.get("stok")).intValue()
                );
                stokBarang.add(nodeBarang);
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return stokBarang;
    }

    @SuppressWarnings("unchecked")
    public void updateStokBarang(List<NodeBarang> stokBarang) {
        JSONObject jsonObject = new JSONObject();
        JSONArray stokBarangArray = new JSONArray();

        // Convert each node in stokBarang to JSON format and add to stokBarangArray
        for (NodeBarang nodeBarang : stokBarang) {
            JSONObject nodeObject = new JSONObject();
            nodeObject.put("kodeBarang", nodeBarang.getKodeBarang());
            nodeObject.put("namaBarang", nodeBarang.getNamaBarang());
            nodeObject.put("stok", nodeBarang.getStok());
            stokBarangArray.add(nodeObject);
        }

        jsonObject.put("stokbarang", stokBarangArray);

        try (FileWriter writer = new FileWriter(FILE_PATH_BARANG)) {
            // Write the updated JSON data back to the file
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void tambahDataJSON(NodeJSONSewa nodeJSONSewa) {
        
    }

    public void tambahDataJSON(NodeBarang nodeBarang) {
    }
}
