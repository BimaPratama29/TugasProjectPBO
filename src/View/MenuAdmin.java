package View;

import Controller.ControllerUser;
import Model.ModelAdmin;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;
import ModelJSON.ModelJSONAdmin;
import Model.ModelBarang;
import ModelJSON.ModelJSONBarang;
import Node.NodeBarang;

import java.util.Scanner;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);
    static ModelUser modelUser = new ModelUser();
    static ModelAdmin modelAdmin = new ModelAdmin();
    private ControllerUser controller;

    public MenuAdmin(ControllerUser controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        loginAdmin(); // Call the login method to start
    }

    public static void loginAdmin() {
        System.out.print("Masukkan Username Admin: ");
        String user = input.nextLine();
        System.out.print("Masukkan Password Admin: ");
        String pass1 = input.nextLine();

        if (modelAdmin.cekLogin(user, pass1)) {
            System.out.println("Anda Berhasil Login");
            listMenuAdmin(); // Call the main menu after successful login
        } else {
            System.out.println("Username atau password salah");
            loginAdmin(); // Retry login if unsuccessful
        }
    }

    public static void listMenuAdmin() {
        int plh;

        do {
            System.out.println("=====================================");
            System.out.println("            Menu Admin ");
            System.out.println("=====================================");
            System.out.println(warna.color_green + " 1.View User\n 2.View Transaksi\n 3.Update User\n 4.Delete User \n 5.Kembali\n 6.Tambah Barang");
            System.out.print(" Input Pilihan : ");
            plh = input.nextInt();

            switch (plh) {
                case 1:
                    modelUser.viewAllUsers();
                    break;
                case 2:
                    // modelUser.viewPembayaran(); // Uncomment this line if the method exists
                    break;
                case 3:
                    input.nextLine(); // Consume the newline character
                    System.out.print("Masukkan username lama: ");
                    String oldUname = input.nextLine();
                    System.out.print("Masukkan password lama: ");
                    String oldPass = input.nextLine();
                    System.out.print("Masukkan username baru: ");
                    String newUname = input.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String newPass = input.nextLine();
                    modelUser.updateUser(oldUname, oldPass, newUname, newPass);
                    break;
                case 4:
                    input.nextLine(); // Consume the newline character
                    System.out.print("Masukkan username yang akan dihapus: ");
                    String unameToDelete = input.nextLine();
                    System.out.print("Masukkan password pengguna: ");
                    String passToDelete = input.nextLine();
                    modelUser.deleteUser(unameToDelete);
                    break;
                case 5:
                    System.out.println(" Kembali Ke Menu Login ");
                    break;
                case 6:
                    tambahBarang();
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (plh != 5);
    }

    // Metode untuk menambahkan barang
    public static void tambahBarang() {
        input.nextLine(); // Consume the newline character
        System.out.print("Masukkan kode barang: ");
        String kodeBarang = input.nextLine();
        System.out.print("Masukkan nama barang: ");
        String namaBarang = input.nextLine();
        System.out.print("Masukkan jumlah stok barang: ");

        int stokBarang;
        while (true) {
            try {
                stokBarang = Integer.parseInt(input.nextLine());
                if (stokBarang >= 0) {
                    break;
                } else {
                    System.out.println("Jumlah stok barang harus lebih besar atau sama dengan 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }

        ModelBarang modelBarang = new ModelBarang();
        modelBarang.tambahStokBarang(kodeBarang, namaBarang, stokBarang);

        // Tambahkan baris berikut untuk menyimpan data ke JSON
        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
        modelJSONBarang.tambahDataJSON(new NodeBarang(kodeBarang, namaBarang, stokBarang));

        System.out.println("Barang berhasil ditambahkan.");
    }
}
