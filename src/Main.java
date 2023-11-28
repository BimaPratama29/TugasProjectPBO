import ModelJSON.ModelJSONAdmin;
import org.w3c.dom.Node;

import java.sql.SQLOutput;
import java.util.ArrayList;

import ModelJSON.ModelJSONAdmin;
import Node.NodeAdmin;
import java.util.Scanner;


//import static auth.MainMenu.input;
import static java.lang.System.exit;

public class Main {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main menuutama = new Main();
        menuutama.Menu();
//mvjdvjfvfjdb fb
        //cek file
        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        System.out.println(modelJSONAdmin.cekFile());

        //convert arraylist ke jsonarray
        ArrayList<NodeAdmin>list = null;
        //System.out.println(modelJSONAdmin.convertArrayListtoJSONArray(list));

        //ArrayList<NodeAdmin>listadmin1 = new ArrayList<>();
        //listadmin1.add(new NodeAdmin("admin1","polo"));
        //listadmin1.add(new NodeAdmin("admin2","polo2"));


    }

    public void Menu(){
        Scanner input = new Scanner(System.in);
        System.out.println(" ============================== ");
        System.out.println("      ! Selamat Datang di ! ");
        System.out.println("        Rental PS ITATS ");
        System.out.println(" ============================== ");
        System.out.println("\n 1. Penyewa \n 2. Admin \n 3. Exit");
        System.out.println(" Pilih Menu Login. ");
        int plh = input.nextInt();
        do {
            switch (plh){
                case 1:
                    //user
                    System.out.println("Masukkan Username : ");
                    String email = input.nextLine();
                    System.out.println("Masukkan Password : ");
                    String pass = input.nextLine();
                    //GotomenuUser
                    MenuLogin.menuUser();
                    break;
                case 2:
                    //admin
                    System.out.println("Masukkan Username Admin : ");
                    String email = input.nextLine();
                    System.out.println("Masukkan Password Admin : ");
                    String pass = input.nextLine();
                    //GotoMenuAdmin
                    MenuLogin.menuAdmin();
                    break;
                case 3:
                    exit(0);
                default :
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        }while(plh > 3);
    }

    public class MenuLogin{
        public void menuAdmin(){
            System.out.println(" ============================== ");
            System.out.println("           Menu Admin ");
            System.out.println(" ============================== ");
            System.out.println("\n 1. View User \n 2. Pembayaran \n 3. Kembali");
            System.out.println(" Pilih Opsi : ");
            int plh = input.nextInt();
            do {
                switch (plh){
                    case 1:
                        //viewUSer
                        break;
                    case 2:
                        //Pembayaran
                        break;
                    case 3:
                        exit(0);
                    default :
                        System.out.println(" Pilihan Tidak Tersedia.");
                }
            }while(plh > 3);
        }

        public void pesan(){
            //PilihBooking
            //GotoBayar
        }
        public void menuUser(){
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println("\n 1. View Stock \n 2. Kembali");
            System.out.println(" Pilih Opsi : ");
            int plh = input.nextInt();
            do {
                switch (plh){
                    case 1:
                        //GotoStock
                        pesan();
                        break;
                    case 2:
                        exit(0);
                    default :
                        System.out.println(" Pilihan Tidak Tersedia.");
                }
            }while(plh > 2);
        }
    }


}