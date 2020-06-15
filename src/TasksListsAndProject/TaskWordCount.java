/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import regEx.SimpleReader;

/**
 *
 * @author 1511 FOX
 */
public class TaskWordCount {
    
    //class pair
    public static class Pair implements Comparable<Pair>{
        String s;
        int i;
        
        public Pair(String s, int i){
            this.s = s;
            this.i = i;
        }
        
        @Override
        public String toString(){
            return (this.i + ": " + this.s);
        }

        @Override
        public int compareTo(Pair p) {
            return this.i - p.i;
        }
    }
    
    //class sort by count
    public static class SortByCount implements Comparator<Pair>{

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.i - p2.i;
        }
        
    }
    
    //class sort by cout reverse
    public static class SortByCountReverse implements Comparator<Pair>{

        @Override
        public int compare(Pair p1, Pair p2) {
            return -(p1.i - p2.i);
        }
        
    }

    public static void main(String[] args) {
        exec();
    }

    public static void exec() {
        Map<String, Integer> map = new TreeMap<String, Integer>();

        SimpleReader file = new SimpleReader("pg50133.txt");

        String s = file.readLine();
        while (s != null) {
            String[] line = s.split("\\W");
            for (String word : line) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            }
            s = file.readLine();
        }
        file.close();
        
        
        ArrayList<Pair> array = new ArrayList<Pair>();
        
        for (String w : map.keySet()) {
            //System.out.println(w + ":" + map.get(w));
            array.add(new Pair(w, map.get(w)));
        }
        
        Collections.sort(array);
        
        for (Pair p: array){
            System.out.println(p);
        }

    }

}
