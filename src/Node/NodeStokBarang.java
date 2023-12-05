package Node;

public class NodeStokBarang {private String namaBarang;
    private int stok;

    public NodeStokBarang(String namaBarang, int stok) {
        this.namaBarang = namaBarang;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

}

