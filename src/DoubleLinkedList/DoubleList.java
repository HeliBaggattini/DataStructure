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
public class DoubleList {

    protected DoubleNode header, trailer;
    protected int size;

    public DoubleList() {
        this.header = this.trailer = null;
        this.size = 0;
    }

    public DoubleNode first() {
        return this.header;
    }

    public DoubleNode last() {
        return this.trailer;
    }

    public int size() {
        return size;
    }

    public void insertFirst(int e) {
        if (this.size == 0) {
            DoubleNode n = new DoubleNode(null, e, null);
            this.header = this.trailer = n;
        } else {
            DoubleNode old = this.header;
            DoubleNode n = new DoubleNode(null, e, old);
            old.previous = n;
            this.header = n;
        }
        this.size++;
    }

    public void InsertAfter(DoubleNode ref, int e) {
        if (ref.next == null) {
            InsertLast(e);
        } else {
            DoubleNode old = ref.next;
            DoubleNode n = new DoubleNode(ref, e, old);
            old.previous = n;
            ref.next = n;
            this.size++;
        }

    }
    
    public void InsertBefore(DoubleNode ref, int e) {
        if (ref.previous == null) {
            insertFirst(e);
        } else {
            DoubleNode old = ref.previous;
            DoubleNode n = new DoubleNode(old, e, ref);
            old.next = n;
            ref.previous = n;
            this.size++;
        }

    }

    public void InsertLast(int e) {
        if (this.size == 0) {
            DoubleNode n = new DoubleNode(null, e, null);
            this.header = this.trailer = n;
        } else {
            DoubleNode old = this.trailer;
            DoubleNode n = new DoubleNode(old, e, null);
            old.next = n;
            this.trailer = n;
        }

        this.size++;

    }

    public DoubleNode find(int e) {
        DoubleNode n = first();

        while (n != null) {
            if (n.element == e) {
                break;
            } else {
                n = n.next;
            }
        }

        return n;

    }

    @Override
    public String toString() {
        String s = "";
        DoubleNode n = first();

        while (n != null) {
            s += n.toString();
            n = n.next;
        }

        return s;

    }
}
