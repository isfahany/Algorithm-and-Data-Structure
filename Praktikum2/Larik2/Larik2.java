package Praktikum2.Larik2;

public class Larik2 {

    private int size;
    private double[] itemDt;

    public Larik2(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public double getItem(int i) {
        return this.itemDt[i];
    }

    public static Larik2 sambung(Larik2 l1, Larik2 l2) {
        double[] a = new double[l1.size + l2.size];
        Larik2 l3 = new Larik2(a);
        for (int i = 0; i < l3.size; i++) {
            if (i < l1.size) {
                l3.itemDt[i] = l1.itemDt[i];
            } else {
                l3.itemDt[i] = l2.itemDt[i - l1.size];
            }
        }
        return l3;
    }

    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }

    public double findBesar() {
        double besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    public int getPosisi(double dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public static Larik2 copyLarik(int k, int n, Larik2 l) {
        // lenkapi bagian ini
        double[] a = new double[n];
        Larik2 l2 = new Larik2(a);
        for (int i = 0; i < n; i++) {
            l2.itemDt[i] = l.itemDt[i];
        }
        return l2;
    }

    public int getPosBesar(int awal, int akhir) {
        int posBesar = -1;
        double itemBesar;
        if (awal <= akhir) {
            posBesar = awal;
            itemBesar = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemBesar < nilaiItem) {
                    itemBesar = nilaiItem;
                    posBesar = i;
                }
            }
        }
        return posBesar;
    }

    public int getPosKecil(int awal, int akhir) {
        int posKecil = -1;
        double itemKecil;
        if (awal <= akhir) {
            posKecil = awal;
            itemKecil = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemKecil > nilaiItem) {
                    itemKecil = nilaiItem;
                    posKecil = i;
                }
            }
        }
        return posKecil;
    }

    public static Larik2 SelectionSort(Larik2 lAsal, int status) {

        int n = lAsal.getSize();
        Larik2 lhasil = Larik2.copyLarik(0, n, lAsal);
        if (status == 0) {

            for (int i = 0; i < n; i++) {
                int posKecil = lhasil.getPosKecil(i,
                        n);

                double itemKecil
                        = lhasil.getItem(posKecil);

                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemKecil);
                lhasil.isiItem(posKecil, itemI);
            }
        } else {
            for (int i = 0; i < n; i++) {
                int posBesar = lhasil.getPosBesar(i,
                        n);

                double itemBesar
                        = lhasil.getItem(posBesar);

                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemBesar);
                lhasil.isiItem(posBesar, itemI);
            }
        }
        return lhasil;
    }

    public static double LarikKaliLarik(Larik2 l1, Larik2 l2) {
        double hasilKali = 0;
        if (l1.size == l2.size) {
            for (int i = 0; i < l1.size; i++) {
                hasilKali += l1.itemDt[i] * l2.itemDt[i];
            }
        }
        return hasilKali;
    }
}