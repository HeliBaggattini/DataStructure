/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursiveFunction;

/**
 *
 * @author 1511 FOX
 */
public class RecursiveFunc {
    
    public static int fatorial(int n) {
        
        if(n == 0){
            return 1;
        }else{
            return (n + fatorial(n - 1));
        }
    }
    
     public static int fibonacci(int n) {
        
        if(n == 0){ //stop case
            return 0;
        }
        if(n == 1){ //stop case
            return 1;
        }else{ //general case
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
     
    public static void binary(int n, String s){
        if (n == 0){//stop case
            System.out.println(s);
        }else{
            binary(n - 1,  s + 0);
            binary(n - 1,  s + 1);
        }
    }
    
    public static void main(String[] args) {
        //System.out.println(fatorial(5));
        //System.out.println(fibonacci(12));
        binary(3, "");
    }
}
