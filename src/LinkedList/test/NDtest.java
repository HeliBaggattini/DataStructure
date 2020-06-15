/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList.test;

import LinkedList.Node;

/**
 *
 * @author 1511 FOX
 */
public class NDtest {
    
    public static void main(String[] args) {
        
        Node a = new Node(1, null);
        Node b = new Node(2, null);
        Node c = new Node(3, null);
        Node d = new Node(4, null);
        
        a.next = b;
        
        System.out.print(a);
        System.out.print(b);
        System.out.println();
        
        b.next = c;
        
        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
        System.out.println();
        
        c.next = d;
        
        
        //impressao com while
        Node n = a;
        
        while (n != null) {
            System.out.print(n);
            n = n.next;
        }
        System.out.println();
    }
    
}
