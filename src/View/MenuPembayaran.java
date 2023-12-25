package View;

import Controller.ControllerUser;
import Model.ModelPembayaran;
import Node.NodePembayaran;
import Node.NodeUser;

import java.util.Scanner;

public class MenuPembayaran {
    static Scanner input = new Scanner(System.in);
    private ControllerUser controllerUser;
    private static ModelPembayaran modelPembayaran;

    public MenuPembayaran(ControllerUser controllerUser, ModelPembayaran modelPembayaran) {
        this.controllerUser = controllerUser;
        this.modelPembayaran = modelPembayaran;
    }


    public void viewBayar(String[] args) {

        int pil;
        do {
            System.out.println(" ============================= ");
            System.out.println("        Menu Pembayaran ");
            System.out.println(" ============================= ");
            System.out.println(warna.color_green + " 1. Lihat Transaksi \n 2. Proses Pembayaran \n 3. Kembali" + warna.text_reset);
            System.out.print(" Masukan Opsi : ");
            pil = input.nextInt();

            switch (pil) {
                case 1:
                    System.out.println(" ========================= ");
                    System.out.println("     Lihat Transaksi ");
                    System.out.println(" ========================= ");
                    modelPembayaran.viewTransaksi();
                    // Panggil method untuk menampilkan transaksi
                    break;
                case 2:
                    System.out.println(" ========================= ");
                    System.out.println("        Pembayaran ");
                    System.out.println(" ========================= ");
                    System.out.print(" Harga barang : ");
                    float hargabarang = input.nextFloat();
                    System.out.print(" Masukkan uang yang dibayarkan: ");
                    float totalPembayaran = input.nextFloat();
                    float kembalian = modelPembayaran.prosesPembayaran(MenuUser.username,totalPembayaran, hargabarang);
                    if(kembalian > 0){
                        System.out.print("kembalian : "+kembalian);
                    }
                    break;
                case 3:
                    System.out.println(" Kembali ke Menu User....");
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (pil != 3);
    }

}
