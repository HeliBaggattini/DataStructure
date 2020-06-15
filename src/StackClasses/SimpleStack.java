/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1511 FOX
 */
public class SimpleStack {

    private ArrayList<Integer> array;

    public SimpleStack() {
        this.array = new ArrayList<Integer>();
    }

    //push()
    public void push(int i) {
        this.array.add(i);
    }

    //pop()
    public int pop() throws Exception {
        if (size() != 0) {
            return this.array.remove(size() - 1);
        } else {
            throw new Exception("empty stack");
        }
    }

    //peek()
    public int peek() throws Exception {
        if (size() != 0) {
            return this.array.get(size() - 1);
        } else {
            throw new Exception("empty stack");
        }
    }

    //size()
    public int size() {
        return this.array.size();
    }

    //toString()
    public String toString() {
        String s = "";
        
        for(int i = (size() - 1); i >= 0; i--){
            s+= " "+this.array.get(i)+"\n";
        }
        
        return s+="___\n";
    }

}
