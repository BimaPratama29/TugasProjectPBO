package View;

import java.util.Scanner;

public class MenuUser {
    public static Scanner input = new Scanner(System.in);
    public static void ListMenuUser() {
        int plh;
        do {System.out.println("\n\n");
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println("\n 1. View Stock \n 2. Kembali");
            System.out.println(" Pilih Opsi : ");

            plh = input.nextInt();
            switch (plh) {
                case 1:
                    // GotoStock
                    continue;
                case 2:
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (plh > 2);
    }

    private static void pesan() {
        // Implementasi logika untuk menu "View Stock"
    }
}
