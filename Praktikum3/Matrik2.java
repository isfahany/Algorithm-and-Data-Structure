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
public class Matrik2 {
// Data

    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik2(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik2(double[][] dt) {
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.setItem(i, j, dt[i][j]);
            }
        }
    }

    public static Matrik2 tranpos(Matrik2 A) {
        double[][] data = new double[A.nKolom][A.nBaris];
        Matrik2 B = new Matrik2(data);
        for (int i = 0; i < A.nBaris; i++) {
            for (int j = 0; j < A.nKolom; j++) {
                B.itemDt[j][i] = A.itemDt[i][j];
            }
        }
        return B;
    }

    /**
     * Fungsi untuk mendapatakan jumlah baris
     *
     * @return jumlah baris
     */
    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    public Matrik tambah(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris())
                && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j,
                            this.itemDt[i][j] + x.getItem(i, j));
                }
            }
        }
        return y;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
        }
        for (int j = 0; j < this.nKolom; j++) {
            System.out.print(this.itemDt[i][j] + "");
        }
        System.out.println();
    }
}
