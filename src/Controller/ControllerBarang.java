package Controller;

import Model.ModelBarang;
import Node.NodeBarang;

import java.util.List;

public class ControllerBarang {
    private ModelBarang model;

    public ControllerBarang(ModelBarang model) {
        this.model = model;
    }

    public void viewStokBarang() {
        model.ViewStok();
    }

    public void tambahStokBarang(String kodeBarang, String namaBarang, int stok) {
        model.tambahStokBarang(kodeBarang, namaBarang, stok);
    }

    public void bookingSewa(String kodeBarang, int jumlah) {
        model.bookingSewa(kodeBarang, jumlah, kodeBarang);
    }

    public List<NodeBarang> getStokBarang() {
        return model.getStokBarang();
    }
}
