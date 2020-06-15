/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import java.util.ArrayList;

/**
 *
 * @author 1511 FOX
 */
public class Dictionary {
    
    private static class Item{
        public int key;
        public String value;

        public Item(int k, String v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public String toString() {
            return "[" + this.key + "," + this.value + "]";
        }
    }
    
    private ArrayList<Item> array;
    
    public Dictionary(){
        this.array = new ArrayList<Item>();
    }
    
    //return an item if on the list
    private Item search(int k){
        for (Item i : this.array){
            if(i.key == k){
                return i;
            }
        } 
        return null;
    }
    
    //put int k, String v  //d[k] = v
    public void put(int k, String v){
        if(!contains(k)){
            this.array.add(new Item(k, v));
        }else{
            search(k).value = v;
        }
    }
    
    //get int k   // x = d[k]
    public String get(int k){
        if(!contains(k)){
            return null;
        }else{
            return search(k).value;
        }
    }
    
    //contains int k   // k in d
    public boolean contains(int k){
        if(search(k) != null){
            return true;
        }
        return false;
    }

    //remove
    public void remove(int k){
        if(contains(k)){
            this.array.remove(search(k));
        }
    }

    @Override
    public String toString() {
        return this.array.toString();
    }
    
    
}
