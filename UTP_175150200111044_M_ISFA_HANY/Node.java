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
public class Node {
    int data;
    Node next;
    Node prev;
    
    public Node(){}
    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
