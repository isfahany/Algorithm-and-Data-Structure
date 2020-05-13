package asd_kelas;

public class LinkedList {

    Object data;
    Node pointer;
    Node head, tail;

    public Node getHead() {
        return head;
    }
    int size = 0;

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input; 
            tail = input;
        } else {
            input.pointer = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.pointer = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(Object key, Node input) {
        Node temp = head;
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.pointer;
        }
        if (temp != null) {
            input.pointer = temp.pointer;
            temp.pointer = input;
            size++;
        }
    }

    void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.pointer;
                head = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.pointer != tail) {
                    temp = temp.pointer;
                }
                temp.pointer = null;
                tail = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(Object key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.pointer.data == key) {
                    temp.pointer = temp.pointer.pointer;
                    if (temp.pointer == null) {
                        tail = temp;
                    }
                    break;
                } else if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                }
                temp = temp.pointer;
            }
        } else {
            System.out.println("Data is empty!");
        }
        size--;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    public Object get(int index) {
        checkIndex(index);
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }
        return currentNode.data;
    }

    public int indexOf(Object theElement) {
        Node currentNode = head;
        int index = 0; // index of currentNode
        while (currentNode != null && !currentNode.data.equals(theElement)) {
            currentNode = currentNode.pointer;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removedElement;
        if (index == 0) {
            removedElement = head.data;
            head = head.pointer;
        } else {
            Node q = head;
            for (int i = 0; i < index - 1; i++) {
                q = q.pointer;
            }
            removedElement = q.pointer.data;
            q.pointer = q.pointer.pointer;
            tail = q;
        }
        size--;
        return removedElement;
    }

    public void cetakLinkedlist() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.pointer;
        }
    }

    public void printReverse(Node head) {
        if (head == null) {
            System.out.println("PRINT REVERSE");
            return;
        }
        printReverse(head.pointer);

        System.out.println(head.data);
    }

    public void insertBefore(Object key, Node toInsert) {
        if (head == null) {
            return;
        } else if (head.data.equals(key)) {
            addFirst(toInsert);
            return;
        } else {
            Node prev = null;
            Node cur = head;

            while (cur != null && !cur.data.equals(key)) {
                prev = cur;
                cur = cur.pointer;
            }
            if (cur != null) {
                size++;
                toInsert.pointer = prev.pointer;
                prev.pointer = toInsert;
            }
        }
    }

    public void contains(Object input) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == input) {
                System.out.println(temp.data);
                return;
            }
            temp = temp.pointer;
        }
        System.out.println("Data tidak ditemukan");
    }
}
