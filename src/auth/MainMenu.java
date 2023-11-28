package auth;

import java.util.Scanner;

public class MainMenu {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public void menu(){
        System.out.println("============");
        System.out.println("1.Login sebagai Admin");
        System.out.println("2.Login sebagai User");
        System.out.println("============");

        while (true){
            System.out.println("Pilihan Menu : ");
            int pilih;
            pilih = input.nextInt();

            if(pilih == 1){
                System.out.println("Masukkan Username : ");
                String email = input.nextLine();
                System.out.println("Masukkan Password : ");
                String pass = input.nextLine();

            }
            if(pilih == 2){
                System.out.println("Masukkan Username : ");
                String email = input.nextLine();
                System.out.println("Masukkan Password : ");
                String pass = input.nextLine();
            }
        }

    }
}
