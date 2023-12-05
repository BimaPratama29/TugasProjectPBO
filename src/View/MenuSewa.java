package View;

import java.util.Scanner;

public class MenuSewa {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int pilih;
        System.out.println(" ============================== ");
        System.out.println("           Menu Sewa ");
        System.out.println(" ============================== ");
        System.out.println(warna.color_green +"\n 1. Lihat Stok  \n 2. Booking Sewa \n 3. Kembali"+ warna.text_reset);
        System.out.print(" Pilih Opsi : ");

        pilih = input.nextInt();
        input.nextLine();

        while(true){
            if(pilih ==1){

            }
        }
    }
}
