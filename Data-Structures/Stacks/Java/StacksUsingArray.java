/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Stacks
{   // stack inplementation using array
    static class Stack{
        int top =-1;
        int max_size = 5;
        char a[] = new char[max_size];
        
        void push(char x){
            if(top >= max_size -1){
                // stack is full
                System.out.println("stack is overflowed");
            }
            else {
                a[++top]=x;
                System.out.println(x + "    pushed to stack");
            }
        }
        
        char pop(){
            if(top<0){
                System.out.println(" stack is empty");
                return ' ';
            }
            else{
                System.out.println( a[top] + "  popped from stack");
                return a[top--];
            }
        }
        
        char peek(){
            if(top<0){
                System.out.println(" stack is empty");
                return ' ';
            }
            else{
                System.out.println("top element is " + a[top]);
                return a[top];
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Stack myStack = new Stack();
		myStack.push('a');
		myStack.push('b');
		myStack.push('c');
		myStack.push('d');
		myStack.peek();
		myStack.pop();
		myStack.pop();
		myStack.peek();
		
	}
}
