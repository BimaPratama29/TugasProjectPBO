package View;

import Model.ModelUser;

import java.util.Scanner;
import View.warna;

import javax.swing.*;

public class MenuUser {
    static ModelUser cUser = new ModelUser();
    public static Scanner input = new Scanner(System.in);
    public static void ListMenuUser() {
        int plh;
        do {
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println(warna.color_green +"\n 1. Buat Akun  \n 2. Login \n 3. Kembali"+ warna.text_reset);
            System.out.print(" Pilih Opsi : ");

            plh = input.nextInt();
            input.nextLine();



            if (plh == 1) {
                System.out.println(warna.color_purple+"--- Registrasi Akun ---"+warna.text_reset);
                System.out.print(warna.color_blue+"Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                cUser.RegisterUser(username, password);
                System.out.println(warna.color_green+"Akun berhasil didaftarkan"+warna.text_reset);
                ListMenuUser();
            } else if (plh == 2) {
                System.out.print(warna.color_blue+"Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                for (int i = 0; i < cUser.getListDatausers().size(); i++) {
                    if (cUser.getListDatausers().get(i).uname.equals(username)) {
                        if (cUser.getListDatausers().get(i).pass.equals(password)) {
                            System.out.println("Anda berhasil login sebagai user");
                            MenuUser.ListMenuUser();
                        }
                    }
                }

            } else {
                Main.main(null);
                break;
            }
        }
    }
}
