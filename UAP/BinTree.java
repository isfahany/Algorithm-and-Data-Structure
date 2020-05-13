package UAP;

public class BinTree {

    private Node root;

    public BinTree() {
        root = null;
    }

    public void preOrderRec() {
        preOrder(root);
    }

    public void insert(char ins) {
        if (root == null) {
            root = new Node(ins);
        } else {
            root.insert(ins);
        }
    }

    public void insertStr(String ins) {
        for (int i = 0; i < ins.length(); i++) {
            char x = ins.charAt(i);
            insert(x);
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.nodeKiri);
        preOrder(node.nodeKanan);
    }

    public void inOrderRec() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.nodeKiri);
        System.out.println(node.data);
        inOrder(node.nodeKanan);
    }

    public void postOrderRec() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.nodeKiri);
        postOrder(node.nodeKanan);
        System.out.println(node.data);
    }
}
