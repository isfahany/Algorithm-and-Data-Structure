package UAP;

//SOAL UAP ASD TIF-B
//1. Input Nim Anda
//2. Setiap karakter dimasukkan kedalam Node
//3. Buatlah Binary Tree dari Node node tersebut (Binary Search Tree)
//4. Lakukan traversal preOrder, inOrder dan postOrder
public class main {

    public static void main(String[] args) {
        String nim = "175150200111044";
        BinTree bin = new BinTree();
        bin.insertStr(nim);
        System.out.println("=========================");
        bin.preOrderRec();
        System.out.println("=========================");
        bin.postOrderRec();
        System.out.println("=========================");
        bin.inOrderRec();
        /*
        katanya binary search tree, jadi redundansi data saya hilangkan
        */
    }
}
