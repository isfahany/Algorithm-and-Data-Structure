/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTP_175150200111044_M_ISFA_HANY;

import java.util.Scanner;

/**
 *
 * @author rockwell
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Data : ");
        int rentang = in.nextInt();
        dll list = new dll();
        for (int i = 0; i < rentang; i++) {
            int masukan = in.nextInt();
            list.addFirst(masukan);
        }
        System.out.println("isi data = ");
        list.cetak();
        System.out.println();
        System.out.println(list.checker());
    }
}
