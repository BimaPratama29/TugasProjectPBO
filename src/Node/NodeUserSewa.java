package Node;

public class NodeUserSewa {
    public String kode_sewa;
    public String unitGame;
    public String nama_sewa;


    public NodeUserSewa(String nama_sewa, String kode_sewa, String unitGame) {
        this.kode_sewa = kode_sewa;
        this.unitGame = unitGame;
        this.nama_sewa = nama_sewa;
    }

    public String getNama_sewa() {
        return nama_sewa;
    }

    public void setNama_sewa(String nama_sewa) {
        this.nama_sewa = nama_sewa;
    }

    public String getKode_sewa() {
        return kode_sewa;
    }

    public void setKode_sewa(String kode_sewa) {
        this.kode_sewa = kode_sewa;
    }

    public String getUnitGame() {
        return unitGame;
    }

    public void setUnitGame(String unitGame) {
        this.unitGame = unitGame;
    }
}
