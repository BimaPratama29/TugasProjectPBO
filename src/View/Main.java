package View;

import Model.ModelAdmin;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.*;
public class Main {
    ModelJSONUser modelJSONUser = new ModelJSONUser();
    ArrayList <NodeUser> listUser1 = new ArrayList<>();
    public static void main(String[] args) {
        ModelAdmin admin = new ModelAdmin();
        Scanner input = new Scanner(System.in);

        int plh;

        System.out.println(" ============================== ");
        System.out.println("      ! Selamat Datang di ! ");
        System.out.println("        Rental PS ITATS ");
        System.out.println(" ============================== ");

        do {
            System.out.println("\n 1. Penyewa \n 2. Admin \n 3. Exit");
            System.out.println(" Pilih Menu Login. ");
            plh = input.nextInt();
            input.nextLine();


            switch (plh) {
                case 1:
                    //user
                    ModelJSONUser modelJSONUser = new ModelJSONUser();
                    ArrayList <NodeUser> listUser1 = new ArrayList<>();
                    listUser1.add(new NodeUser("bima29" , "ingatskripsi"));
                    listUser1.add(new NodeUser("yoga21","skripibisa"));
                    listUser1.add(new NodeUser("koga21","1234567"));
                    listUser1.add(new NodeUser("Saya","000000000000"));
                    modelJSONUser.writeFileJSON(listUser1);
                    //for(NodeUser user : listUser1){
                    //  System.out.println("Username : " +user.uname);
                    //System.out.println("Password : " +user.pass);
                    //}
                    System.out.println("Masukkan Username : ");
                    String uname = input.nextLine();
                    System.out.println("Masukkan Password : ");
                    String pass = input.nextLine();

                    //NodeUser nodeUser = new NodeUser();
                    if(uname.equals(uname)){
                        if(pass.equals(pass)){
                            System.out.println("anda berhasil login");
                            MenuUser.ListMenuUser();

                        }
                    }
                    else{
                        System.out.println("Username || password anda salah");
                    }
                    break;
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



