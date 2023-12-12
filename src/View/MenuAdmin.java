package View;

import java.util.Scanner;
import Model.ModelUser;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);
    static ModelUser modelUser = new ModelUser();

    public static void ListMenuAdmin(){
        int plh;
        do{
            System.out.println("=====================================");
            System.out.println("            Menu Admin ");
            System.out.println("=====================================");
            System.out.println(warna.color_green + " 1.View User\n 2.View Transaksi\n 3.Update User\n 4.Delete User \n 5.Kembali");
            System.out.print(" Input Pilihan : ");
            plh = input.nextInt();
            switch (plh){
                case 1:
                    modelUser.viewAllUsers();
                    continue;
                case 2:
                   // modelUser.ViewPembayaran();
                    continue;
                case 3:
                    input.nextLine();  
                    System.out.print("Masukkan username lama: ");
                    String oldUname = input.nextLine();
                    System.out.print("Masukkan password lama: ");
                    String oldPass = input.nextLine();
                    System.out.print("Masukkan username baru: ");
                    String newUname = input.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String newPass = input.nextLine();
                    modelUser.updateUser(oldUname, oldPass, newUname, newPass);
                    continue;
                case 4:
                input.nextLine();
                System.out.print("Masukkan username yang akan dihapus: ");
                String unameToDelete = input.nextLine();
                System.out.print("Masukkan password pengguna: ");
                String passToDelete = input.nextLine();
                modelUser.deleteUser(unameToDelete);
                case 5:
                    System.out.println(" Kembali Ke Menu Login ");
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        }while (plh != 3);
    }
}