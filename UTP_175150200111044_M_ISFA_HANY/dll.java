/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTP_175150200111044_M_ISFA_HANY;

/**
 *
 * @author rockwell
 */
public class dll {

    private Node head, tail;
    private int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(int nilai) {
        Node baru = new Node(nilai);
        if (isEmpty()) {
            head = tail = baru;
            size++;
        } else {
            baru.next = head;
            head.prev = baru;
            tail.next = null;
            baru.prev = null;
            head = baru;
            size++;
        }
    }

    public void cetak() {
        Node temp = tail;
        do {
            System.out.print(temp.data + "->");
            temp = temp.prev;
        } while (temp != null);
        System.out.print("NULL");
    }

    public String checker() {
        String value = "";
        Node temp = tail;
        do {
            if (temp.data >= temp.prev.data) {
                value = "Data Terurut Descending";
                temp = temp.prev;
            } else {
                System.out.print("");
                break;
            }
        } while (temp.prev != null);

        temp = head;
        if (temp.data >= temp.next.data) {
            do {
                if (temp.data >= temp.next.data) {
                    value = "Data Terurut Ascending";
                    temp = temp.next;
                } else {
                    System.out.print("");
                    value = "Data tidak Terurut";
                    break;
                }
            } while (temp.next != null);
        }
        return value;
    }
}
