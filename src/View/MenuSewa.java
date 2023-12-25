package View;

import Model.ModelBarang;
import Node.NodeBarang;
import ModelJSON.ModelJSONBarang;
import NodeJSON.NodeJSONSewa;

import java.util.Scanner;
// ...

public class MenuSewa {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ModelBarang modelBarang = new ModelBarang();
        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();

        int pilih;
        do {
            System.out.println(" ============================== ");
            System.out.println("           Menu Sewa ");
            System.out.println(" ============================== ");
            System.out.println(" 1. Lihat Stok  \n 2. Booking Sewa \n 3. Pembayaran \n 4. Kembali");
            System.out.print(" Pilih Opsi : ");

            pilih = input.nextInt();
            input.nextLine(); // Membersihkan buffer setelah nextInt()

            switch (pilih) {
                case 1:
                    System.out.println(" ============================== ");
                    System.out.println("           List Barang ");
                    System.out.println(" ============================== ");
                    modelBarang.ViewStok();
                    break;

                case 2:
                    System.out.println(" ============================== ");
                    System.out.println("           Booking Sewa ");
                    System.out.println(" ============================== ");

                    System.out.print("Masukkan kode barang yang akan disewa: ");
                    String kodeBarang = input.nextLine();

                    System.out.print("Masukkan jumlah barang yang akan disewa: ");
                    int jumlahBarang = input.nextInt();

                    input.nextLine(); // Membersihkan buffer setelah nextInt()

                    System.out.print("Masukkan username Anda: ");
                    String username = input.nextLine();

                    // Tambahkan baris berikut untuk menyimpan booking ke ModelBarang
                    modelBarang.bookingSewa(kodeBarang, jumlahBarang, username);

                    // Tambahkan baris berikut untuk menyimpan data booking ke JSON
                    modelJSONBarang.tambahDataJSON(new NodeJSONSewa(kodeBarang, "", username, jumlahBarang, ""));

                    break;
                case 3:
                    System.out.println(" ============================== ");
                    System.out.println("           Pembayaran ");
                    System.out.println(" ============================== ");
                    MenuPembayaran menuBayar = new MenuPembayaran(Main.controllerUser, Main.modelPembayaran);
                    menuBayar.viewBayar(null);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilih != 4);
    }
}
