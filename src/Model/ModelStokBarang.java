package Model;

import Node.NodeStokBarang;
import View.warna;

import java.util.HashMap;
import java.util.Map;

public class ModelStokBarang {
    //NodeStokBarang nodeStokBarang = new NodeStokBarang(null,null,);

    private Map<String,NodeStokBarang> stokBarang = new HashMap<>();
    public ModelStokBarang(){
      tambahStokBarang("A001","Playstation 4" ,10);
      tambahStokBarang("A002","Playstation 5" ,5);

    }

    public void ViewStok(){
        for (Map.Entry<String,NodeStokBarang> entry : stokBarang.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNamaBarang() + warna.color_purple+" - Stok: "+warna.text_reset + entry.getValue().getStok());
        }
    }
    public void tambahStokBarang(String kodeBarang, String namaBarang, int stok) {
        stokBarang.put(kodeBarang, new NodeStokBarang(namaBarang, stok));
    }

    public void bookingSewa(String kodeBarang, int jumlah) {
        if (stokBarang.containsKey(kodeBarang)) {
            NodeStokBarang stok = stokBarang.get(kodeBarang);
            if (stok.getStok() >= jumlah) {
                stok.setStok(stok.getStok() - jumlah);
                System.out.println("Booking berhasil! Terima kasih.");
            } else {
                System.out.println("Stok tidak mencukupi untuk booking.");
            }
        } else {
            System.out.println("Barang tidak ditemukan dalam stok.");
        }
    }
    }




