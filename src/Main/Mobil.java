package Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gilang Ramadhan
 */

public class Mobil extends Main {
    public void showMenu() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            System.out.println("==============================");
            System.out.println("          Menu Mobil          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. List Mobil");
            System.out.println("==============================");
            System.out.print("Pilih Menu: ");

            int menu = input.nextInt();

            switch(menu) {
                case 1:
                    tambahMobil();
                    
                    break;

                case 2:
                    listMobil();

                    break;

                default:
                    System.out.println("Pilihan Menu Mobil Tidak Tersedia");

                    break;
            }
            
            System.out.println("==============================");         
            System.out.print("Mulai Ulang Menu Mobil? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    protected void tambahMobil() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("==============================");
        System.out.println("         Tambah Mobil         ");
        System.out.println("==============================");
        
        System.out.print("Merek: ");
        
        String newMerek = input.nextLine();
        
        System.out.print("Plat Nomor: ");
        
        String newPlatNomor = input.nextLine();
        
        int index = Arrays.asList(platNomor).indexOf(newPlatNomor);
        
        System.out.print("Harga Sewa: ");
        
        int newhargaSewa = input.nextInt();
        
        if(index == -1) {
            merek = addString(merek, newMerek);
            platNomor = addString(platNomor, newPlatNomor);
            hargaSewa = addInteger(hargaSewa, newhargaSewa);
        } else {
            System.out.println("==============================");
            System.out.println("Plat Nomor Sudah Tersedia");
        }
    }
    
    protected void listMobil() {
        System.out.println("==============================");
        System.out.println("          List Mobil          ");
        System.out.println("==============================");
        
        for (int i = 0; i < merek.length; i++) {
            System.out.println(String.format("%d. %s - %s - %d", i + 1, merek[i], platNomor[i], hargaSewa[i]));
        }
    }
}
