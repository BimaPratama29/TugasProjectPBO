package ModelJSON;

import Node.NodePembayaran;
import NodeJSON.NodeJSONPembayaran;
import NodeJSON.NodeJSONSewa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ModelJSONPembayaran {
    private String fname = "src/Database/transaksi.json";
    ArrayList <NodePembayaran> transaksiList ;

    public ModelJSONPembayaran() {
        this.transaksiList = readFromJSON();
    }

    public void writeToJSON(ArrayList<NodePembayaran> transaksiList) {
        JSONArray arrayTransaksi = convertListToJSONArray(transaksiList);
        try {
            // Use try-with-resources to automatically close the file
            try (FileWriter file = new FileWriter(fname)) {
                file.write(arrayTransaksi.toJSONString());
            }
            System.out.println("Data transaksi berhasil ditambahkan dan ditulis ke file JSON.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<NodePembayaran> readFromJSON() {
        JSONParser parser = new JSONParser();
        ArrayList<NodePembayaran> transaksiList = new ArrayList<>();

        try {
            // Menggunakan try-with-resources untuk secara otomatis menutup file
            try (Reader reader = new FileReader(fname)) {
                JSONArray arrayTransaksi = (JSONArray) parser.parse(reader);

                for (Object obj : arrayTransaksi) {
                    JSONObject jsonTransaksi = (JSONObject) obj;
                    String uname = (String) jsonTransaksi.get("uname");
                    float hargabarang = Float.parseFloat(jsonTransaksi.get("hargabarang").toString());
                    float totalpembayaran = Float.parseFloat(jsonTransaksi.get("totalpembayaran").toString());
                    float kembalian = Float.parseFloat(jsonTransaksi.get("kembalian").toString());

                    NodePembayaran transaksi = new NodePembayaran(uname, totalpembayaran, hargabarang, kembalian);
                    transaksiList.add(transaksi);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return transaksiList;
    }

    private JSONArray convertListToJSONArray(List<NodePembayaran> transaksiList) {
        JSONArray arrayTransaksi = new JSONArray();
        for (NodePembayaran transaksi : transaksiList) {
            JSONObject objTransaksi = new JSONObject();
            objTransaksi.put("uname", transaksi.getUname());
            objTransaksi.put("hargabarang", transaksi.getHargabarang());
            objTransaksi.put("totalpembayaran", transaksi.getTotalpembayaran());
            objTransaksi.put("kembalian", transaksi.getKembalian());
            arrayTransaksi.add(objTransaksi);
        }
        return arrayTransaksi;
    }

    public void tambahBayarJSON(NodePembayaran transaksi) {
        try {
            // Membaca data yang sudah ada
            ArrayList<NodePembayaran> transaksiList = readFromJSON();

            // Menambahkan data baru
            transaksiList.add(transaksi);

            // Menulis kembali ke file JSON
            writeToJSON(transaksiList);
            System.out.println("Data pembayaran berhasil ditambahkan dan ditulis ke file JSON.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

