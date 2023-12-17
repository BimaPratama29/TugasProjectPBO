package Model;

import Node.NodeBarang; // Add this import
import View.warna;
import java.util.ArrayList;
import java.util.List;

import ModelJSON.ModelJSONBarang;

public class ModelBarang {
    private List<NodeBarang> stokBarang = new ArrayList<>();

    public ModelBarang() {
        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
        this.stokBarang = modelJSONBarang.readFromJSON();
    }

    public void ViewStok() {
        for (NodeBarang barang : stokBarang) {
            System.out.println(barang.getKodeBarang() + " - " + barang.getNamaBarang() +
                    warna.color_purple + " - Stok: " + warna.text_reset + barang.getStok());
        }
    }

    public void tambahStokBarang(String kodeBarang, String namaBarang, int stok) {
        stokBarang.add(new NodeBarang(kodeBarang, namaBarang, stok));
    }

    public void bookingSewa(String kodeBarang, int jumlah) {
        NodeBarang stok = cariBarang(kodeBarang);
        if (stok != null) {
            if (stok.getStok() >= jumlah) {
                stok.setStok(stok.getStok() - jumlah);
                System.out.println("Booking berhasil! Terima kasih.");

                // Tambahkan baris berikut untuk menyimpan data ke JSON
                ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
                modelJSONBarang.tambahDataJSON(stok);

                // Update stok yang telah berubah ke dalam file JSON
                modelJSONBarang.updateStokBarang(getStokBarang());
            } else {
                System.out.println("Stok tidak mencukupi untuk booking.");
            }
        } else {
            System.out.println("Barang tidak ditemukan dalam stok.");
        }
    }

    private NodeBarang cariBarang(String kodeBarang) {
        for (NodeBarang barang : stokBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }

    public List<NodeBarang> getStokBarang() {
        return stokBarang;
    }
}
