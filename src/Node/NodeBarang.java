package Node;

public class NodeBarang {
  private String namaBarang;
  private int stokBarang;

    public NodeBarang(String namaBarang, int stokBarang) {
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }
}

