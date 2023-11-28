package View;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int plh;

        System.out.println(" ============================== ");
        System.out.println("      ! Selamat Datang di ! ");
        System.out.println("        Rental PS ITATS ");
        System.out.println(" ============================== ");

        do {
            System.out.println("\n 1. Penyewa \n 2. Admin \n 3. Exit");
            System.out.println(" Pilih Menu Login. ");
            plh = input.nextInt();
            input.nextLine();


            switch (plh) {
                case 1:
                    //user
                    System.out.println("Masukkan Username : ");
                    //String uname = input.nextLine();
                    System.out.println("Masukkan Password : ");
                    //String pass = input.nextLine();
                    MenuUser.ListMenuUser();
                    break;
                case 2:
                    //admin
                    System.out.println("Masukkan Username Admin : ");
                    //String uname = input.nextLine();
                    System.out.println("Masukkan Password Admin : ");
                    //String pass = input.nextLine();
                    //GotoMainMenuAdmin
                    MenuAdmin.ListMenuAdmin();
                    break;
                case 3:
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        }while (plh != 3);
    }
}



