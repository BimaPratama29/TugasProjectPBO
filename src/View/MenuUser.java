package View;

import Controller.ControllerUser;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.ArrayList;
import java.util.Scanner;
import View.warna;

import javax.swing.*;

public class MenuUser {
    private ControllerUser controller;
    public MenuUser(ControllerUser controller){
        this.controller = controller;
    }
    static ModelUser cUser = new ModelUser();
    static ModelJSONUser cUserJSON = new ModelJSONUser();
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
                System.out.println(warna.color_blue+"--- Registrasi Akun ---"+warna.text_reset);
                System.out.print(warna.color_purple+"Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                cUser.registerUser(username, password);
                System.out.println(warna.color_green+"Akun berhasil didaftarkan"+warna.text_reset);
                ListMenuUser();
            } else if (plh == 2) {
                System.out.print(warna.color_purple+"Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                ArrayList<NodeUser> userList = cUserJSON.readFromJSON();
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).uname.equals(username)) {
                        if (userList.get(i).pass.equals(password)) {
                            System.out.println(warna.color_green+ "Anda berhasil login sebagai user"+warna.text_reset);
                            MenuSewa.main(null);
                        }
                    }
                }

            } else {
                Main.main(null);
                break;
            }
        }while (plh != 3);
    }
}
