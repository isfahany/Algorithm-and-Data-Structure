/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum3;

/**
 *
 * @author rockwell
 */
public class main2 {

    public static void main(String[] args) {
// implementasi untuk ADT_Matrik
        Matrik A, B, C;
        double[][] X = {{1, 2, 3}, {2, 14, 5}, {16, 8, 13}};
        double[][] Y = {{10, 12, 0}, {5, 1, 5}, {3, 1, 10}};
        A = new Matrik(X);
        B = new Matrik(Y);
        A.cetak("Matrik A");
        B.cetak("Matrik B");
        C = A.tambah(B);
        C.cetak("Matriks C = A - B");
        C.cetak("Matriks C = A + B");
        Larik2 lb, lk;
        lb = C.getBaris(1);
        lb.cetak("Larik baris ke-1");
        lk = C.getKolom(1);
        lk.cetak("Larik kolom ke-1");
    }
}
