
// makes a link list ; insert new node ; tell the length of linked list and delete nth element also find nth element

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LinkedList
{
    Node head; // head of linkedlist of type node [ unique to a linked list]
    
    // a new node object
    static class Node{
        int data;   // data associated with a node
        Node next;  // reference to the next node object of type node
        
        Node(int d){    // node constructor function which will create a new node with data d and pointing to null(individual node not connected to anything)
            data= d;
            next = null;
        }
    }
        
    // insert function of my linked list
    // inserts every new element to the head of linked list
    public void insert(int d){
        Node new_node = new Node(d); // created a new node with data d
        new_node.next = head;   // points to the prev head node
        head = new_node; // makes the new node head node
        // System.out.println(new_node.data + " points to " + new_node.next);
        // System.out.println(head.data + " is the head of the linked list");
    }
    
    public int length(){
        int len =0;
        Node temp = head;
        while(temp != null){
            len ++;
            temp = temp.next;
        }
        System.out.println("Length of linked list is : " + len);
        return len;
    }
    
    public void findN(int pos){
        Node temp = head;
        int count = 1 ; // taking it zero will lead to an extra iteration
        // ask how to check if the number is less than length of list
        while ( temp !=null ){ 
            if( count == pos){
                System.out.println(pos + " element from the start is "+ temp.data);
            }
            count ++;
            temp = temp.next;
        }
        
    }
    
    public void delete(int pos){
    
    Node temp=head;
    Node nextTemp = temp.next;
    
    if(head == null){
        System.out.println("Empty Linked list");
    }
    else if (pos == 1){
        // head.next = null; // why is this not needed and why perfoming this makes list length 0
        head = temp.next;
    }
    else{
        int count =0;
        while(temp !=null){
            if(count == pos-1){
                temp.next = nextTemp.next;
            }
            temp = temp.next;
            nextTemp = nextTemp.next;
            count ++;
        }
    }
    System.out.println( pos + "node is deleted");
    }
    
    public void insertAtN(int index, int d){
        if(index == 1|| index == 0){
            insert(d);
        }
        else{
            Node newNode = new Node(d);
            int count =1;
            Node temp = head;
            while(temp != null){
                if(count== index-1){
                    newNode.next= temp.next;
                    temp.next = newNode;
                }
                temp = temp.next;
                count ++;
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
    
    public void reverse(){
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList myllist = new LinkedList();
		myllist.insert(2);  // 2 > null
		myllist.insert(5);  // 5 > 2 > null
		myllist.insert(9);  // 9 > 5 > 2 > null
		myllist.printList();
		myllist.insertAtN(2,4);
		myllist.printList();
		myllist.insert(12);
		myllist.insert(99);  
		myllist.printList();
		myllist.length();
		myllist.findN(2);
		myllist.delete(3);
		myllist.printList();
		myllist.length();
	}
}
