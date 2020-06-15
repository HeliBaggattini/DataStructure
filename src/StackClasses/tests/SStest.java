/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackClasses.tests;

import StackClasses.SimpleStack;

/**
 *
 * @author 1511 FOX
 */
public class SStest {
    public static void main(String[] args) {
        SimpleStack ss = new SimpleStack();
        
        ss.push(1);
        ss.push(2);
        ss.push(3);
        
        System.out.println(ss.toString());
        
        try {
            if(ss.peek()!= 3){
                System.out.println("fail 1");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        try{
            ss.pop();
        }catch (Exception e){
            System.err.println(e);
        }
        
        try {
            if(ss.peek()!= 2){
                System.out.println("fail 2");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        if(ss.size() != 2){
            System.out.println("fail 3");
        }
        
        System.out.println(ss.toString());
    }
   
}
