package Model;

import java.util.Scanner;
import auth.MenuLogin;

public class MainMenuAdmin {
    public static void menu(){
        System.out.println("--- Menu Admin ---");
        System.out.println("1.View User\n2.ViewPembayaran\n3.Kembali");
        System.out.println("---            ---");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih_menu;
        do{
            menu();
            System.out.println("Pilih opsi : ");
            pilih_menu = input.nextInt();
            switch (pilih_menu){
                case 1:
                    //ViewUserSewa.main();
                break;
                case 2:
                    //ViewPembayaran.main();
                break;
                case 3:
                    MenuLogin.menu();
                    break;
            }
        }while (pilih_menu > 4);
    }
}
