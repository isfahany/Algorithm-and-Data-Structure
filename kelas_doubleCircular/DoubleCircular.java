package kelas_doubleCircular;

public class DoubleCircular {

    static Node root;
    static Node current;
    static Node temp;

    public void addDNode(Mahasiswa data) {

        Node dNode = new Node(data);

        if (root == null) {

            root = dNode;
            root.nextDNode = root;
            root.previousDNode = root;

        } else {

            current = root;

            while (current.nextDNode != root) {

                current = current.nextDNode;

            }
            current.nextDNode = dNode;
            dNode.nextDNode = root;
            dNode.previousDNode = current;
            root.previousDNode = dNode;

        }

    }

    public void insertDNode(Mahasiswa data, Mahasiswa after) {

        Node dNode = new Node(data);
        int ithDNode = 1;
        current = root;

        while (ithDNode != after.getNim()) {

            current = current.nextDNode;
            ithDNode++;

        }
        temp = current.nextDNode;
        current.nextDNode = dNode;
        dNode.nextDNode = temp;
        temp.previousDNode = dNode;
        dNode.previousDNode = current;
    }

    public void deleteDNode(Mahasiswa DNodeNumber) {

        int ithDNode = 1;
        current = root;

        if (DNodeNumber.getNim() == 1) {
            root.nextDNode.previousDNode = root.previousDNode;
            root.previousDNode.nextDNode = root.nextDNode;
            root = root.nextDNode;

        } else {

            while (ithDNode != DNodeNumber.getNim()) {
                current = current.nextDNode;
                ithDNode++;
            }
            current.nextDNode.previousDNode = current.previousDNode;
            current.previousDNode.nextDNode = current.nextDNode;
            current = current.nextDNode;

        }

        Node.noOfDLinkedList--;

    }

    public void cetak(String kom) {
        System.out.println(kom);
        Node n = root;
        while (n != root.previousDNode) {
            System.out.println("==================");
            System.out.println("NIM         :" + n.data.getNim());
            System.out.println("NAMA        :" + n.data.getNama());
            System.out.println("==================");
            n = n.nextDNode;
        }
        System.out.println("NULL");

    }

}
