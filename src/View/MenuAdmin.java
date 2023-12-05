package View;

import java.util.Scanner;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);

    public static void ListMenuAdmin(){
        int plh;
        do{ System.out.println("\n\n");
            System.out.println("--- Menu Admin ---");
            System.out.println("1.View Stock\n2.View Penyewa\n3.View Transaksi Penyewa\n4.Kembali");
            System.out.println("---            ---");

            plh = input.nextInt();
            switch (plh){
                case 1:
                    //ViewUserSewa.main();
                    continue;
                case 2:
                    //ViewPembayaran.main();
                    continue;
                case 3:
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        }while (plh > 4);
    }
}

