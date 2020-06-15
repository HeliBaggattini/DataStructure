/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList.test;

import LinkedList.Node;
import LinkedList.SimpleList;

/**
 *
 * @author 1511 FOX
 */
public class SLtest {
    
    public static void main(String[] args) {
        
        SimpleList sl = new SimpleList();
        
        sl.insertFirst(0);
        sl.insertFirst(1);
        sl.insertFirst(2);
        sl.insertFirst(3);
        sl.insertFirst(4);
    
        //ipressao com toString
        System.out.println(sl);
        
        Node a = sl.find(0);
        sl.insertAfter(a, 8);
        
        if(a.next.equals(8)){
            System.out.println("fail");
        }
        
        //fim do teste
        System.out.println(sl);
        System.out.println(sl.last());
    }
    
}
