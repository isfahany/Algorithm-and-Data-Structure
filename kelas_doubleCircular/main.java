/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas_doubleCircular;

/**
 *
 * @author rockwell
 */
public class main {

    public static void main(String[] args) {

        DoubleCircular list = new DoubleCircular();

        Mahasiswa a = new Mahasiswa(0, "satu");
        Mahasiswa b = new Mahasiswa(1, "dua");
        Mahasiswa c = new Mahasiswa(2, "tiga");
        Mahasiswa d = new Mahasiswa(3, "empat");
        Mahasiswa e = new Mahasiswa(4, "lima");
        Mahasiswa f = new Mahasiswa(5, "enam");
        list.addDNode(a);
        list.addDNode(b);
        list.addDNode(c);
        list.insertDNode(d, b);
        list.addDNode(d);
        list.addDNode(e);
        list.addDNode(f);
        list.deleteDNode(d);
        list.deleteDNode(f);

        list.cetak("HASIL DATA MAHASISWA");
        System.out.println();
        System.out.println("The number of DNodes in the Linked List is " + Node.noOfDLinkedList);
    }
}
