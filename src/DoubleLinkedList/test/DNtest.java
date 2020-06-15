/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList.test;

import DoubleLinkedList.DoubleNode;

/**
 *
 * @author 1511 FOX
 */
public class DNtest {

    public static void main(String[] args) {
        DoubleNode a = new DoubleNode(null, 1, null);
        DoubleNode b = new DoubleNode(null, 2, null);
        DoubleNode c = new DoubleNode(null, 3, null);

        a.next = b;
        b.previous = a;
        
        b.next = c;
        c.previous = b;

        DoubleNode n = a;

        while (n != null) {
            System.out.print(n);
            n = n.next;
        }
        System.out.println();
    }

}
