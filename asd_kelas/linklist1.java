package asd_kelas;

public class linklist1 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(new Node(100));
        list.addLast(new Node(200));
        list.addLast(new Node(300));
        list.addLast(new Node(400));
        list.addLast(new Node(500));
        list.addFirst(new Node(50));
        list.insertAfter(200, new Node(250));
        list.removeFirst();
        list.removeLast();
        list.remove(3);
        list.insertBefore(200, new Node(150));
        list.contains(350);
        list.cetakLinkedlist();
        list.printReverse(list.getHead());
        System.out.println(15000000/1500);
    }
}
