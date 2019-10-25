
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class DoublyLinkedList
{
    Node head;
    static class Node{
        int data;
        Node prev;
        Node next;
        // node object for a DoublyLinkedList
        Node(int d){
            data =d;
            prev = null;
            next = null;
        }
    }
    
    public void insert(int d){
        Node newNode = new Node(d);
        
        if(head !=null){
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        }
        else{
            head = newNode;
        }
         System.out.println(newNode.data + " points to " + newNode.next+ " and had prev node " + newNode.prev);
        System.out.println(head.data + " is the head of the linked list" + " and has prev node "+ head.prev);
    }
    
    public void delete(int index){ // check this code
        int count = 0;
        Node temp = head;
        Node nextNode = temp.next;
        while(temp != null){
            temp = temp.next;
            nextNode = nextNode.next;
            count ++;
            if(count == index -1){
               temp.next = nextNode.next;
               nextNode.prev = temp;
            }
        }
        
    }
    
    public void printList(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " > ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		DoublyLinkedList myllist = new DoublyLinkedList();
		myllist.insert(2);  // 2 > null
		myllist.insert(5);  // 5 > 2 > null
		myllist.insert(9);  // 9 > 5 > 2 > null
		myllist.printList();
		myllist.insert(12);  // 12 > 9 > 5 > 2 > null
		myllist.printList();
		myllist.delete(2);
		myllist.printList();
		myllist.insert(99);  // 99> 12 > 9 > 5 > 2 > null
	}
}
