package View;

import Controller.ControllerUser;
import Model.ModelAdmin;
import Model.ModelBarang;
import Model.ModelUser;
import ModelJSON.ModelJSONBarang;
import Node.NodeBarang;
import NodeJSON.NodeJSONSewa;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);
    static ModelUser modelUser = new ModelUser();
    static ModelAdmin modelAdmin = new ModelAdmin();
    ControllerUser controller;

    public MenuAdmin(ControllerUser controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        loginAdmin(); // Panggil metode login untuk memulai
    }

    public static void loginAdmin() {
        System.out.print("Masukkan Username Admin: ");
        String user = input.nextLine();
        System.out.print("Masukkan Password Admin: ");
        String pass1 = input.nextLine();

        if (modelAdmin.cekLogin(user, pass1)) {
            System.out.println("Anda Berhasil Login");
            listMenuAdmin(); // Panggil menu utama setelah login berhasil
        } else {
            System.out.println("Username atau password salah");
            loginAdmin(); // Ulangi login jika tidak berhasil
        }
    }

    public static void listMenuAdmin() {
        int plh;

        do {
            System.out.println("=====================================");
            System.out.println("            Menu Admin ");
            System.out.println("=====================================");
            System.out.println(" 1.View User\n 2.View Transaksi\n 3.Update User\n 4.Delete User \n 5.Kembali\n 6.Tambah Barang \n 7.View User Sewa");
            System.out.print(" Input Pilihan : ");
            plh = input.nextInt();

            switch (plh) {
                case 1:
                    modelUser.viewAllUsers();
                    break;
                case 2:
                    // modelUser.viewPembayaran(); // Hapus komentar pada baris ini jika metodenya ada
                    break;
                case 3:
                    input.nextLine(); // Membersihkan newline character
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
                    input.nextLine(); //
                    System.out.print("Masukkan username yang akan dihapus: ");
                    String unameToDelete = input.nextLine();
                    System.out.print("Masukkan password pengguna: ");
                    input.nextLine();
                    modelUser.deleteUser(unameToDelete);
                    break;
                case 5:
                    System.out.println(" Kembali Ke Menu Login ");
                    break;
                case 6:
                    tambahBarang();
                    break;
                case 7:
                    // Menampilkan data user yang sedang menyewa
                    viewUserSewa();
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (plh != 5);
    }

    // Metode untuk menambahkan barang
    public static void tambahBarang() {
        input.nextLine(); // Membersihkan newline character
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

        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
        modelJSONBarang.tambahDataJSON(new NodeBarang(kodeBarang, namaBarang, stokBarang));

        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void viewUserSewa() {
        ModelBarang modelBarang = new ModelBarang();
        List<NodeJSONSewa> dataSewa = modelBarang.getSewaList();

        if (dataSewa.isEmpty()) {
            System.out.println("Tidak ada data user yang sedang menyewa.");
        } else {
            System.out.println("=====================================");
            System.out.println("     Data User yang Sedang Menyewa");
            System.out.println("=====================================");
            for (NodeJSONSewa sewa : dataSewa) {
                System.out.println("Kode Barang: " + sewa.getNamaBarang());
                System.out.println("Nama Barang: " + sewa.getNamaBarang());
                System.out.println("Username User: " + sewa.getUsername());
                System.out.println("-------------------------------");
            }
        }
    }
}
