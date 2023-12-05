package Model;

import Node.NodeStokBarang;
import View.warna;

import java.util.HashMap;
import java.util.Map;

public class ModelStokBarang {
    //NodeStokBarang nodeStokBarang = new NodeStokBarang(null,null,);

    private Map<String,NodeStokBarang> stokBarang = new HashMap<>();
    public ModelStokBarang(){
      tambahStokBarang(warna.color_blue+"A001",warna.color_green+"Playstation 4" ,10);
      tambahStokBarang(warna.color_blue+"A002",warna.color_green+"Playstation 5" ,5);

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




