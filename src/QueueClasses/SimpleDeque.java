/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueClasses;

/**
 *
 * @author 1511 FOX
 */
public class SimpleDeque extends SimpleQueue{

    public SimpleDeque() {
    }
    
    //addFirst
    public void addfirst(int i){
        this.array.add(0, i);
    }
    
    //remove last
    public int removeLast(){
        
        return this.array.remove(size() - 1);
    }
    
    //Last
    public int last(){
        
        return this.array.get(size() - 1);
    }
    
    //toString
    public String toString(){
        return this.array.toString();
    }
    
}
