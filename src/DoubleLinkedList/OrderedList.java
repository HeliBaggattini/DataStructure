/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author 1511 FOX
 */
public class OrderedList extends DoubleList {

    public void insertInOrder(int e) {
        if (size() == 0 || header.element >= e) {
            insertFirst(e);
        } else if (trailer.element <= e) {
            InsertLast(e);
        } else {
            DoubleNode n = first();

            while (n != null) {
                if (n.element <= e && n.next.element >= e) {
                    InsertAfter(n, e);
                    break;
                }
                n = n.next;
            }

        }

    }

}
