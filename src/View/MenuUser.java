package View;

import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.Scanner;

public class MenuUser {
    static ModelUser cUser = new ModelUser();
    static ModelJSONUser modelJSONUser = new ModelJSONUser();
    public static Scanner input = new Scanner(System.in);

    public static void ListMenuUser() {
        int plh;
        do {
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println(warna.color_green + "\n 1. Buat Akun  \n 2. Login \n 3. Kembali" + warna.text_reset);
            System.out.print(" Pilih Opsi : ");

            plh = input.nextInt();
            input.nextLine();

            if (plh == 1) {
                System.out.println(warna.color_purple + "--- Registrasi Akun ---" + warna.text_reset);
                System.out.print(warna.color_blue + "Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                cUser.RegisterUser(username, password);
                modelJSONUser.tulisUserKeJSON(new NodeUser(username, password));
                System.out.println(warna.color_green + "Akun berhasil didaftarkan" + warna.text_reset);
                ListMenuUser();
            } else if (plh == 2) {
                System.out.print(warna.color_blue + "Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                
                NodeUser penggunaMasuk = modelJSONUser.loginPenggunaDariJSON(username, password);
                
                if (penggunaMasuk != null) {
                    System.out.println("Anda berhasil login sebagai pengguna");
                    MenuUser.ListMenuUser();
                } else {
                    System.out.println("Username atau password salah");
                }
            } else {
                Main.main(null);
                break;
            }
        } while (plh != 3);
    }
}
