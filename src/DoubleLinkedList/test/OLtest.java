/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList.test;

import DoubleLinkedList.OrderedList;

/**
 *
 * @author 1511 FOX
 */
public class OLtest {

    public static void main(String[] args) {

        OrderedList ol = new OrderedList();

        ol.insertInOrder(1);
        System.out.println(ol.toString());
        ol.insertInOrder(0);
        System.out.println(ol.toString());
        ol.insertInOrder(5);
        System.out.println(ol.toString());
        ol.insertInOrder(2);
        System.out.println(ol.toString());
        ol.insertInOrder(0);
        System.out.println(ol.toString());
        ol.insertInOrder(1);
        System.out.println(ol.toString());
        ol.insertInOrder(6);
        System.out.println(ol.toString());
        
        System.out.println("o resultado para a sequência (3, 8, 5, 4, 2, 7, 1, 9 e 6) deve ser naturalmente 1 2 3 4 5 6 7 8 9.");
        
        OrderedList ol1 = new OrderedList();
        
        ol1.insertInOrder(3);
        System.out.println(ol1.toString());
        ol1.insertInOrder(8);
        System.out.println(ol1.toString());
        ol1.insertInOrder(5);
        System.out.println(ol1.toString());
        ol1.insertInOrder(4);
        System.out.println(ol1.toString());
        ol1.insertInOrder(2);
        System.out.println(ol1.toString());
        ol1.insertInOrder(7);
        System.out.println(ol1.toString());
        ol1.insertInOrder(1);
        System.out.println(ol1.toString());
        ol1.insertInOrder(9);
        System.out.println(ol1.toString());
        ol1.insertInOrder(6);
        System.out.println(ol1.toString());

    }

}
