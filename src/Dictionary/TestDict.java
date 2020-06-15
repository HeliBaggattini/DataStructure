/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

/**
 *
 * @author 1511 FOX
 */
public class TestDict {
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        
        //print
        System.out.println("List: " + d);

        d.put(1, "um");
        d.put(2, "dois");
        
        System.out.println("contains key 1: " + d.contains(1));
        System.out.println("contains key 100: " + d.contains(100));
        System.out.println("get key 2: " + d.get(2));
        System.out.println("get key 100: " + d.get(100));
        
        //print
        System.out.println("List: " + d);
        
        System.out.println("change value of key 2...");
        d.put(2, "teste");
        System.out.println("add a new item(key 3)...");
        d.put(3, "tres");
        
        //print
        System.out.println("List: " + d);
        
        System.out.println("remove Item from key 2...");
        d.remove(2);
        
        //print
        System.out.println("List: " + d);
        
        System.out.println("remove Item from key 100...");
        d.remove(100);
    }
}
