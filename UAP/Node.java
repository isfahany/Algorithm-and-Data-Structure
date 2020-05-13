package UAP;

public class Node {

    char data;
    Node nodeKiri;
    Node nodeKanan;

    public Node(char dt) {
        data = dt;
        nodeKiri = nodeKanan = null;
    }
    public void insert(char ins){
        if (ins < data) {
            if (nodeKiri == null) {
                nodeKiri = new Node(ins);
            } else {
                nodeKiri.insert(ins);
            }
        } else if (ins > data) {
            if (nodeKanan == null) {
                nodeKanan = new Node(ins);
            } else {
                nodeKanan.insert(ins);
            }
        }else{
            System.out.println("data "+ ins +" sudah ada" );
        }
    }
}
