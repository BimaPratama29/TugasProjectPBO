package View;

import Model.ModelUser;

import java.util.Scanner;

public class MenuUser {
    static ModelUser cUser = new ModelUser();
    public static Scanner input = new Scanner(System.in);
    public static void ListMenuUser() {
        int plh;

        while (true) {
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println("\n 1. Buat Akun  \n 2.Login \n 3. Kembali");
            System.out.println(" Pilih Opsi : ");

            plh = input.nextInt();

            if (plh == 1) {
                System.out.println("--- Registrasi Akun ---");
                System.out.println("Masukkan username : ");
                String username = input.nextLine();
                System.out.println("Masukkan password : ");
                String password = input.nextLine();
                cUser.RegisterUser(username, password);
                System.out.println("Akun berhasil didaftarkan");
                ListMenuUser();
            } else if (plh == 2) {
                System.out.println("Masukkan username : ");
                String username = input.nextLine();
                System.out.println("Masukkan password : ");
                String password = input.nextLine();
                for (int i = 0; i < cUser.getListDatausers().size(); i++) {
                    if (cUser.getListDatausers().get(i).uname.equals(username)) {
                        if (cUser.getListDatausers().get(i).pass.equals(password)) {
                            System.out.println("Anda berhasil login sebagai user");

                        }
                    }
                }

            } else {
                break;
            }

        }
    }
}
