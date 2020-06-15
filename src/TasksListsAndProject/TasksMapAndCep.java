/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import regEx.SimpleReader;

/**
 *
 * @author 1511 FOX
 */
public class TasksMapAndCep {

    public static void main(String[] args) {
        System.out.println("1.\n");
        first("this is a test");
        System.out.println("----------------------------------------------------- \n");
        System.out.println("2.\n");
        second(new String[][]{{"eu", "tu", "ele"}, {"nos", "vos", "eles"}});
        System.out.println("----------------------------------------------------- \n");
        System.out.println("3.\n");
        third();
        System.out.println("----------------------------------------------------- \n");
        System.out.println("4.\n");
        fourth();
        System.out.println("----------------------------------------------------- \n");
    }

    public static void first(String s) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char k : map.keySet()) {
            System.out.println(k + ": " + map.get(k));
        }

    }

    public static void second(String[][] s) {

        ArrayList<Map<Integer, String>> list
                = new ArrayList<Map<Integer, String>>();

        for (int i = 0; i < s.length; i++) {
            Map<Integer, String> map = new HashMap<Integer, String>();
            for (int j = 0; j < s[0].length; j++) {
                if (!map.containsKey(s[i][j].length())) {
                    map.put(s[i][j].length(), s[i][j]);
                }
            }
            list.add(map);
        }

        for (Map<Integer, String> map : list) {
            System.out.print("-");
            for (String w : map.values()) {
                System.out.print("   " + w);
            }
            System.out.println("");
        }

    }

    public static void third() {
//        String line = "95700-000 4.68";
//        String cep = line.substring(0, 9);
//        double val = Double.parseDouble(line.substring(10, 14));
        Map<String, Integer> map = new TreeMap<String, Integer>();

        SimpleReader f = new SimpleReader("packages.txt");

        String s = f.readLine();

        while (s != null) {
            String cep = s.substring(0, 9);

            if (!map.containsKey(cep)) {
                map.put(cep, 1);
            } else {
                map.put(cep, map.get(cep) + 1);
            }

            s = f.readLine();

        }
        f.close();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void fourth() {
//        String line = "95700-000 4.68";
//        String cep = line.substring(0, 9);
//        double val = Double.parseDouble(line.substring(10, 14));

        Map<String, Double> map = new TreeMap<String, Double>();

        SimpleReader f = new SimpleReader("packages.txt");

        String s = f.readLine();

        while (s != null) {
            String cep = s.substring(0, 9);
            double val = Double.parseDouble(s.substring(10, 14));

            if (!map.containsKey(cep)) {
                map.put(cep, val);
            } else {
                map.put(cep, (map.get(cep) + val));
            }
            s = f.readLine();

        }
        f.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
