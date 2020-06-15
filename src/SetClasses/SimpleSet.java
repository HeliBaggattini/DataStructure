package SetClasses;

import java.util.ArrayList;
import java.util.Collections;
public class SimpleSet {
    
    public ArrayList<String> array;
    
    public SimpleSet (){
        this.array = new ArrayList<String>();
    }
    
    public boolean equals(SimpleSet dataSet){
        return this.array.toString().equals(dataSet.toString());
    }
    
    @Override
    public String toString(){
        Collections.sort(this.array);
        return this.array.toString();
    }
    
    public int size(){
        return this.array.size();
    }
    
    public void add(String item){
        this.array.add(item);
    }
    
//    public void add(SimpleSet ss){
//        for(String s: ss.array){
//            this.array.add(s);
//        }
//    }
    
    public void remove(String item){
        this.array.remove(item);
    }
    
    public boolean contains(String item){
        return this.array.contains(item);
    }
}
