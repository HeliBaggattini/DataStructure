/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueClasses;

import java.util.ArrayList;

/**
 *
 * @author 1511 FOX
 */
public class SimpleQueue {

    protected ArrayList<Integer> array;

    public SimpleQueue() {
        this.array = new ArrayList<Integer>();
    }

    //add()
    public void add(int i) {
        this.array.add(i);
    }

    //remove()
    public int remove() throws Exception {
        if (size() != 0) {
            return this.array.remove(0);
        } else {
            throw new Exception("empty queue");
        }
    }

    //first()
    public int first() throws Exception {
        if (size() != 0) {
            return this.array.get(0);
        } else {
            throw new Exception("empty queue");
        }
    }

    //size()
    public int size() {
        return this.array.size();
    }

    //toString()
    public String toString() {
        return this.array.toString();
    }

}
