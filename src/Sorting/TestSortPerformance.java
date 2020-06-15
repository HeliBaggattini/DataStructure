package Sorting;

import java.util.*;

public class TestSortPerformance {

    public static void insertion_sort(ArrayList<Integer> a) {
        for (int j = 1; j < a.size(); j++) {
            int tmp = a.get(j);
            int i = j - 1;
            while (i >= 0 && a.get(i) > tmp) {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, tmp);
        }
    }
    
    public static void main(String[] args) {
        int n = 1000;
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int v = (int) (Math.random() * n);
            array1.add(v);
            array2.add(v);
        }

        // measure time
        long begin, end;
        System.out.println("Time sorting " + n + " integers (in seconds)");

        begin = System.currentTimeMillis();
        Collections.sort(array2);        
        end = System.currentTimeMillis();
        System.out.println("  mergesort:      " + (end - begin) / 1000.0);

        begin = System.currentTimeMillis();
        insertion_sort(array1);        
        end = System.currentTimeMillis();
        System.out.println("  insertion sort: " + (end - begin) / 1000.0);
 
        // check that arrays match
        for (int i = 0; i < n; i++) {
            int v1 = array1.get(i);
            int v2 = array2.get(i);
            if (v1 != v2) {
                System.out.println("error: arrays do not match!");
                break;
            }
        }
    }
}
