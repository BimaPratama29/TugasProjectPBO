package View;
import java.util.Scanner;
public class MenuPembayaran {
    Scanner input = new Scanner(System.in);
    public void ViewBayar(){
        int pil;
        do {
            System.out.println(" ============================= ");
            System.out.println("        Menu Pembayaran ");
            System.out.println(" ============================= ");
            System.out.println(warna.color_green + " 1. Lihat Daftar Transaksi \n 2. Pembayaran 3. Kembali");
            System.out.println(" Masukan Opsi : ");
            pil = input.nextInt();

            switch (pil) {
                case 1:
                    System.out.println(" ========================= ");
                    System.out.println("     Daftar Transaksi ");
                    System.out.println(" ========================= ");
                    //DaftarTransaksi
                    break;
                case 2:
                    System.out.println(" ========================= ");
                    System.out.println("         Pembayaran ");
                    System.out.println(" ========================= ");
                    //MenuBayar
                case 3:
                    System.out.println(" Kembali ke Menu Admin....");
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");

            }
        }while (pil != 2);
        input.close();



    }
}