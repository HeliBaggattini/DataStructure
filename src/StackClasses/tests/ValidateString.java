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
public class ValidateString {

    public static void main(String[] args) {
        SimpleStack ss = new SimpleStack();

        String st1 = "()(())";

        try {
            for (char c : st1.toCharArray()) {
                if (c == '(') {
                    ss.push(c);
                }
                if (c == ')') {
                    ss.pop();
                }
            }
        } catch (Exception e) {
            System.out.println("Bad String");
        }
        
        if(ss.size() != 0){
            System.out.println("Bad String");
        }
    }
}
