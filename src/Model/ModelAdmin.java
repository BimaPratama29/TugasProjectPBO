package Model;
import Node.NodeAdmin;
import Node.NodeUserSewa;

import java.util.ArrayList;

public class ModelAdmin {
    ArrayList<NodeAdmin> admins;
    ArrayList<NodeUserSewa> nsewa;
    public void ViewBarang(){
        System.out.println("");
    }

    public void ViewSewa(){
    for (NodeUserSewa sewa1 : nsewa ){
        System.out.println("Nama penyewa : " + sewa1.getNama_sewa());
        System.out.println("Jenis Unit    : " + sewa1.getUnitGame());
        System.out.println("Kode booking : " + sewa1.getKode_sewa());

    }
    }



}
