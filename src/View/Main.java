package View;

import Model.ModelAdmin;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.*;
public class Main {
    ModelJSONUser modelJSONUser = new ModelJSONUser();
    ArrayList <NodeUser> listUser1 = new ArrayList<>();
    public static void main(String[] args) {
        ModelAdmin admin = new ModelAdmin();
        Scanner input = new Scanner(System.in);
        ModelUser modelUser = new ModelUser();


        int plh;

        System.out.println(" ============================== ");
        System.out.println("      ! Selamat Datang di ! ");
        System.out.println("        Rental PS ITATS ");
        System.out.println(" ============================== ");

        do {
            System.out.println("\n 1. Penyewa \n 2. Admin \n 3. Exit");
            System.out.println("=====================================");
            System.out.print(" Pilih Menu Login. ");
            plh = input.nextInt();
            input.nextLine();


            switch (plh) {
                case 1:
                    //user
                    ModelJSONUser modelJSONUser = new ModelJSONUser();
                    ArrayList <NodeUser> listUser1 = new ArrayList<>();
                    MenuUser.ListMenuUser();

                case 2:
                    //admin
                    System.out.println("Masukkan Username Admin : ");
                    String user = input.nextLine();
                    System.out.println("Masukkan Password Admin : ");
                    String pass1 = input.nextLine();
                    if(admin.cekLogin(user, pass1)){
                        System.out.println("Anda Berhasil Login");
                        MenuAdmin.ListMenuAdmin();
                        break;
                    }else{
                        System.out.println("user dan pass salah");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        }while (plh != 3);
    }
}



// afnjksfbhdsfbsdhfbsdhfb