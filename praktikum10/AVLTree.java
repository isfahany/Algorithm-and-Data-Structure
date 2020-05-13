package praktikum10;

public class AVLTree {

    Node akar;

    int getTinggi(Node N) {
        return (N != null) ? N.tinggi : 0;
    }

    Node putarKanan(Node y) {
        Node x = y.nodeKiri;
        Node T2 = x.nodeKanan;
        x.nodeKanan = y;
        y.nodeKiri = T2;
        y.tinggi = Math.max(getTinggi(y.nodeKiri),
                getTinggi(y.nodeKanan)) + 1;

        x.tinggi = Math.max(getTinggi(x.nodeKiri),
                getTinggi(x.nodeKanan)) + 1;
        return x;
    }
    Node putarKiri(Node x) {
        Node y = x.nodeKanan;
        Node T2 = y.nodeKiri;

        y.nodeKiri = x;
        x.nodeKanan = T2;

        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;

        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;

        return y;
    }

    int getBalance(Node N) {
        return (N != null) ? getTinggi(N.nodeKiri)
                - getTinggi(N.nodeKanan) : 0;
    }

    Node insert(Node node, int data) {

        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.nodeKiri = insert(node.nodeKiri, data);
        } else if (data > node.data) {
            node.nodeKanan = insert(node.nodeKanan, data);
        } else
        {
            return node;
        }

        node.tinggi = 1 + Math.max(getTinggi(node.nodeKiri),
                getTinggi(node.nodeKanan));
        Node result = balance(node, data);

        return result;
    }

    Node balance(Node node, int data) {
        int balance = getBalance(node);

        if (balance > 1 && data < node.nodeKiri.data) {
            return putarKanan(node);
        } 
        else if (balance < -1 && data > node.nodeKanan.data) {
            return putarKiri(node);
        } 
        else if (balance > 1 && data > node.nodeKiri.data) {
            node.nodeKiri = putarKiri(node.nodeKiri);
            return putarKanan(node);
        } 
        else if (balance < -1 && data < node.nodeKanan.data) {
            node.nodeKanan = putarKanan(node.nodeKanan);
            return putarKiri(node);
        } 
        else {
            return node;
        }
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node minValueNode(Node node) {
        Node current = node;

        while (current.nodeKiri != null) {
            current = current.nodeKiri;
        }

        return current;
    }

    Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.nodeKiri = deleteNode(root.nodeKiri, key);
        }  
        else if (key > root.data) {
            root.nodeKanan = deleteNode(root.nodeKanan, key);
        }  
        else {
            if ((root.nodeKiri == null) || (root.nodeKanan == null)) {
                Node temp = null;
                if (temp == root.nodeKiri) {
                    temp = root.nodeKanan;
                } else {
                    temp = root.nodeKiri;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else   
                {
                    root = temp;  
                }                      
            } else {
                Node temp = minValueNode(root.nodeKanan);
                root.data = temp.data;
                root.nodeKanan = deleteNode(root.nodeKanan, temp.data);
            }
        }
        if (root == null) {
            return root;
        }
        root.tinggi = max(getTinggi(root.nodeKiri), getTinggi(root.nodeKanan)) + 1;
        return balance(root, key);
    }

    boolean Search(int key) {
        Node temp = akar;
        while (temp != null) {
            if (key > temp.data) {
                temp = temp.nodeKanan;
            } else if (key < temp.data) {
                temp = temp.nodeKiri;
            } else {
                return true;
            }
        }
        return false;
    }

    static int miniNode(int tinggi) {
        return (int) (Math.round(((Math.sqrt(5) + 2) / Math.sqrt(5)) * Math.pow((1 + Math.sqrt(5)) / 2, tinggi) - 1));
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.nodeKiri);
            System.out.print(node.data + " ");
            inOrder(node.nodeKanan);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.nodeKiri);
            preOrder(node.nodeKanan);
        }
    }
}