/* package codechef; // don't place package name! */


// newton school link : https://my.newtonschool.co/playground/code/aqbu2qx5gq/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class GoldbachConjecture
{
    
    public static void Goldbatch (int x){
        if( x%2 !=0){
            System.out.println("-1");
            return ; // odd number does not work with GoldbachConjecture
        }
        
        if(x<=2){
            return; // do not return anything if no is less than 2
        }
        
        for (int i =3; i*1 <=x; i++){
            if( isPrime(i) && isPrime(x-i)){
                System.out.println(i + " " + (x-i));
                return;
            }
        }
    }
    
    public static boolean isPrime(int x){
        for (int i =2 ; i*i <= x;i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Goldbatch(100);
	}
}
