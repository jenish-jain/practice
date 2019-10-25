/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Balance
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
    
    static boolean match ( char a, char b){
        if(a == '(' && b ==')'){
            return true;
        }
        if(a == '[' && b ==']'){
            return true;
        }
        if(a == '{' && b =='}'){
            return true;
        }
        else{
            return false;
        }
    }
    
    static boolean areBalanced (char a[]){
        Stack stack = new Stack();
        for (int i = 0; i<a.length; i++){
            if(a[i]=='{' || a[i]=='(' || a[i]=='['){
                stack.push(a[i]);
            }
           
           if(a[i]=='}' || a[i]==')' || a[i]==']'){
                if(stack.top <0){
                    return false;
                }
                char temp = stack.pop();
                if(!match(temp,a[i])){
                    return false;
                }
            }
        }
        if(stack.top >=0){
            return false;
        }
        return true;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		char a[] ={ '(', '{', ']', ')' };
        Balance obj = new Balance();
        
        System.out.println("is the expression balanced :  " +  obj.areBalanced(a));
		
	}
}
