/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author 1511 FOX
 */
public class TestHashMap {
    public static void main(String[] args) {
        
        HashMap<Integer, String> map  = new HashMap<Integer, String>();
        //Map<Integer, String> map  = new HashMap<Integer, String>();
        //Map<Integer, String> map  = new TreeMap<Integer, String>();
        
        map.put(112, "um");
        map.put(276, "dois");
        map.put(393, "tres");
        map.put(465, "quatro");
        map.put(571, "cinco");
        
        System.out.println(map);
        
        for (int k : map.keySet()){
            System.out.println(k + ": " +map.get(k));
        }
    }
}
