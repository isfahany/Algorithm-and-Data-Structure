package Praktikum3;

public class Matrik {

    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] A) {
        this(A.length, A[0].length);
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

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

    public static Matrik tambah(Matrik A, Matrik B) {
        double[][] data = new double[A.nBaris][A.nKolom];
        Matrik C = new Matrik(data);
        if ((A.nBaris == B.nBaris) && (A.nKolom == B.nKolom)) {
            for (int i = 0; i < A.nBaris; i++) {
                for (int j = 0; j < A.nKolom; j++) {
                    C.itemDt[i][j] = A.itemDt[i][j] + B.itemDt[i][j];
                }
            }
        }
        return C;
    }

    public static Larik2 VektorKaliMatrik(Larik2 L, Matrik M) {
        double[] A = new double[M.getNKolom()];
        Larik2 lHasil = null;
        Larik2 lKolom = null;
        double nKolom;
        if (L.getSize() == M.getNBaris()) {
            lHasil = new Larik2(A);
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik2.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }

    public double determinan() {
        int i, j, k, det = 1;
        if (itemDt.length != itemDt[0].length) {
            throw new ArithmeticException("Bukan matriks persegi");
        } else {
            for (i = 0; i < itemDt.length; i++) {
                for (j = 0; j < itemDt[i].length; j++) {
                    if (i < j) {
                        if (itemDt[i][j] == 0) {
                            det *= itemDt[i][i];
                        }
                    }
                    if (i > j) {
                        if (itemDt[i][j] == 0) {
                            det *= itemDt[i][i];
                        }
                    }
                }
            }
            return det;
        }
    }

    public static Matrik tranpos(Matrik A) {
        double[][] data = new double[A.nKolom][A.nBaris];
        Matrik B = new Matrik(data);
        for (int i = 0; i < A.nBaris; i++) {
            for (int j = 0; j < A.nKolom; j++) {
                B.itemDt[j][i] = A.itemDt[i][j];
            }
        }
        return B;
    }

    public Larik2 getBaris(int idBaris) {
        double[] A = new double[this.nKolom];
        Larik2 l = new Larik2(A);
        for (int i = 0; i < this.nKolom; i++) {
            double itemBaris = this.getItem(idBaris, i);
            l.isiItem(i, itemBaris);
        }
        return l;
    }

    public Larik2 getKolom(int idKolom) {
        double[] A = new double[this.nBaris];
        Larik2 l = new Larik2(A);
        for (int i = 0; i < this.nBaris; i++) {
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }
        return l;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDt[i][j]);
            }
            System.out.println();
        }
    }

    Matrik tambah(Matrik B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
