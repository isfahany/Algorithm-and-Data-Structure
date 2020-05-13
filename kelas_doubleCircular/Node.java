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
public class Node {

	static int noOfDLinkedList = 0;
	Mahasiswa data;
	Node nextDNode;
	Node previousDNode;
	
	Node(Mahasiswa data){
		
		this.data = data;
		noOfDLinkedList++;
		
	}
	
}
