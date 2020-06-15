/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList.test;

import DoubleLinkedList.DoubleList;
import DoubleLinkedList.DoubleNode;

/**
 *
 * @author 1511 FOX
 */
public class DLtest {
    
    public static void main(String[] args) {
        
        DoubleList list = new DoubleList();
        
        list.insertFirst(0);
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
    
        //ipressao com toString
        System.out.println(list);
        
        list.InsertLast(9);
        list.InsertLast(8);
        list.InsertLast(7);
        
        System.out.println(list);
        
        System.out.println(list.find(8));
        
        DoubleNode n2 = list.find(2);
        DoubleNode n3 = list.find(3);
        
        list.InsertAfter(n2, 0);
        list.InsertAfter(n3, 0);
        
        System.out.println(list);
        
        DoubleNode n4 = list.find(2);
        DoubleNode n5 = list.find(3);
        
        list.InsertBefore(n4, 0);
        list.InsertBefore(n5, 0);
        
        System.out.println(list);
       
    }
    
}
