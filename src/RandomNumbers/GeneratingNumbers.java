/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomNumbers;

import java.util.Random;

/**
 *
 * @author 1511 FOX
 */
public class GeneratingNumbers {
    
    public static void main(String[] args) {
        
        int min = 10, max = 20;
        int seed = 1;
        
        Random rng  = new Random(seed);
         
         for (int i = 0; i < 10; i++) {
            //int r = ((int) Math.random() * (max - min + 1) + min);
            int r = rng.nextInt(max - min + 1) + min;
            
            
             System.out.print(r + " ");
        }
         System.out.println();
    }
    
}
