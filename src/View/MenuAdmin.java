package View;

import java.util.Scanner;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);

    public static void ListMenuAdmin(){
        int plh;
        do{
            System.out.println("--- Menu Admin ---");
            System.out.println("1.View User\n2.ViewPembayaran\n3.Kembali");
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

