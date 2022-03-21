package Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gilang Ramadhan
 */

public class Order extends Main {
    public void showMenu() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            System.out.println("==============================");
            System.out.println("          Menu Order          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Order");
            System.out.println("2. List Order");
            System.out.println("==============================");
            System.out.print("Pilih Menu: ");

            int menu = input.nextInt();

            switch(menu) {
                case 1:
                    tambahOrder();
                    
                    break;

                case 2:
                    listOrder();

                    break;

                default:
                    System.out.println("Pilihan Menu Order Tidak Tersedia");

                    break;
            }
            
            System.out.println("==============================");            
            System.out.print("Mulai Ulang Menu Order? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    protected void tambahOrder() {
        Scanner input = new Scanner(System.in);
        
        Mobil showMenu = new Mobil();
        
        showMenu.listMobil();
        
        System.out.println("==============================");
        System.out.println("         Tambah Order         ");
        System.out.println("==============================");
        
        System.out.print("Nomor Induk: ");
        
        String newNomorInduk = input.nextLine();
        
        System.out.print("Nama: ");
        
        String newNama = input.nextLine();
        
        System.out.print("Nomor HP: ");
        
        String newNomorHp = input.nextLine();
        
        System.out.print("Plat Nomor: ");

        int index = Arrays.asList(platNomor).indexOf(input.nextLine());
        
        System.out.print("Lama Sewa: ");
        
        int lama = input.nextInt();
        
        if(index != -1) {
            nomorInduk = addString(nomorInduk, newNomorInduk);
            nama = addString(nama, newNomorHp);
            nomorHp = addString(nomorHp, newNomorHp);
            lamaSewa = addInteger(lamaSewa, lama);

            int total = hargaSewa[index] * lama;

            totalBayar = addInteger(totalBayar, total);
            
            slipPembayaran(newNomorInduk, newNama, newNomorHp, merek[index], platNomor[index], hargaSewa[index], lama, total);            
        } else {
            System.out.println("==============================");
            System.out.println("Plat Nomor Tidak Ditemukan");
        }
        
        System.out.println("==============================");
    }
    
    protected void slipPembayaran(String nomorInduk, String nama, String nomorHp, String merek, String platNomor, int hargaSewa, int lamaSewa, int totalBayar) {
        System.out.println("==============================");
        System.out.println("        Slip Pembayaran       ");
        System.out.println("==============================");
        System.out.println("1. Nomor Induk: " + nomorInduk);
        System.out.println("2. Nama: " + nama);
        System.out.println(String.format("3. Mobil: %s - %s - %d", merek, platNomor, hargaSewa));
        System.out.println("4. Lama Sewa: " + lamaSewa);
        System.out.println("5. Total Bayar: " + totalBayar);
    }
    
    protected void listOrder() {
        System.out.println("==============================");
        System.out.println("          List Order          ");
        System.out.println("==============================");
        
        for (int i = 0; i < nomorInduk.length; i++) {
            System.out.println(String.format("%d. %s - %s - %s - %d Hari - Rp. %d", i + 1, nomorInduk[i], nomorHp[i], platNomor[i + 1], lamaSewa[i], totalBayar[i]));
        }
        
        System.out.println("==============================");
    }
}