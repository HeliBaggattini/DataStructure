/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueClasses.tests;

import QueueClasses.SimpleDeque;

/**
 *
 * @author 1511 FOX
 */
public class SDtest {
    
    public static void main(String[] args) {
        
        SimpleDeque sd = new SimpleDeque();
        
        sd.add(1);
        sd.add(2);
        sd.add(3);
        
        try {
            System.out.println(sd.first());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println(sd.last());
        System.out.println(sd);
        
        sd.addfirst(0);
        System.out.println(sd);
        
        sd.removeLast();
        System.out.println(sd);
    }
    
}
