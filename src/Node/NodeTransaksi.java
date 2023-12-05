package Node;

public class NodeTransaksi {
    String id;
    String waktuTransaksi;
    String durasiSewa;
    int totalBiaya;

    NodeTransaksi(String id,String waktuTransaksi,String durasiSewa, int totalBiaya){
        this.id = id;
        this.waktuTransaksi = waktuTransaksi;
        this.durasiSewa = durasiSewa;
        this.totalBiaya = totalBiaya;
    }
    public void ViewTransaksi(){
        System.out.println("Id : "+this.id);
        System.out.println("Waktu Transaksi : "+this.waktuTransaksi);
        System.out.println("Durasi Sewa : "+this.durasiSewa);
        System.out.println("Total Biaya : "+this.totalBiaya);
    }
    public String getId() {
        return id;
    }
    public String getTglTransaksi() {
        return waktuTransaksi;
    }
    public String getDurasiSewa() {
        return durasiSewa;
    }
    public int getTotalBiaya() {
        return totalBiaya;
    }
}
