package View;

import java.util.Scanner;

import Model.ModelStokBarang;
import View.MenuSewa;

public class MenuSewa {
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        ModelStokBarang modelStokBarang = new ModelStokBarang();
        int pilih;
        do {
            System.out.println(" ============================== ");
            System.out.println("           Menu Sewa ");
            System.out.println(" ============================== ");
            System.out.println(warna.color_green + "\n 1. Lihat Stok  \n 2. Booking Sewa \n 3. Kembali" + warna.text_reset);
            System.out.print(" Pilih Opsi : ");


            pilih = input.nextInt();
            input.nextLine();
            switch (pilih) {
                case 1:
                    System.out.println(" ============================== ");
                    System.out.println("           List Barang ");
                    System.out.println(" ============================== ");
                    modelStokBarang.ViewStok();
                    break;

                case 2:
                    System.out.println(" ============================== ");
                    System.out.println("           Booking Sewa ");
                    System.out.println(" ============================== ");

                    System.out.print("Masukkan kode barang yang akan disewa: ");
                    String kodeBarang = input.nextLine();

                    System.out.print("Masukkan jumlah barang yang akan disewa: ");
                    int jumlahBarang = input.nextInt();

                    input.nextLine();
                    
                    modelStokBarang.bookingSewa(kodeBarang, jumlahBarang);
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilih !=3 );
    }
}

