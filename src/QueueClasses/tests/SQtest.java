/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueClasses.tests;

import QueueClasses.SimpleQueue;

/**
 *
 * @author 1511 FOX
 */
public class SQtest {
    public static void main(String[] args) {
        SimpleQueue sq = new SimpleQueue();
        
        sq.add(1);
        sq.add(2);
        sq.add(3);
        
        System.out.println(sq.toString());
        
        try {
            if(sq.first()!= 1){
                System.out.println("fail 1");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        try{
            sq.remove();
        }catch (Exception e){
            System.err.println(e);
        }
        
        try {
            if(sq.first()!= 2){
                System.out.println("fail 2");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        if(sq.size() != 2){
            System.out.println("fail 3");
        }
        
        System.out.println(sq.toString());
    }
   
}
