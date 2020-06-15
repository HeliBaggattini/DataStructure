/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

import java.util.ArrayList;
import utilities.SimpleReader;
import utilities.SimpleWriter;

/**
 *
 * @author 1511 FOX
 */
public class BatchSort {

    public static void main(String[] args) {

        //auxiliar class
        QuickSort sort = new QuickSort();

        //io objects
        SimpleReader sr;
        SimpleWriter sw;

        //arrays
        ArrayList<Integer> array = new ArrayList<>();
        int[] n;

        for (int j = 1; j <= 2; j++) {
            //io objects
            sr = new SimpleReader("numbers-" + j + ".txt");
            sw = new SimpleWriter("parcial-" + j + ".txt");

            //reading number-"j".txt
            String s = sr.readLine();
            while (s != null) {
                array.add(Integer.parseInt(s));
                s = sr.readLine();
            }
            sr.close();

            //converting to int array
            n = array.stream().mapToInt(i -> i).toArray();
            //sorting
            sort.sort(n, 0, array.size() - 1);

            //writing parcial-"j".txt
            for (int i : n) {
                sw.write(i + "");
            }
            sw.close();
        }
        
        
        //problematic -->
        //readers for sorted.txt
        SimpleReader imp1 = new SimpleReader("numbers-1.txt");
        SimpleReader imp2 = new SimpleReader("numbers-2.txt");
        sw = new SimpleWriter("sorted.txt");
        
        //lines from .txt
        String line1 = imp1.readLine();
        String line2 = imp2.readLine();
        //cont
        int c = 0;
        while(line1 != null && line2 != null){
            int i1 = Integer.parseInt(line1);
            int i2 = Integer.parseInt(line2);
            if(i1 < i2){
                sw.write("" + i1);
                line1 = imp1.readLine();
            }else{
                sw.write("" + i2);
                line2 = imp1.readLine();
            }
            c++;
        }
        
        if(line1 == null){
            while(line2 != null){
                sw.write(line2);
                line2 = imp2.readLine();
                c++;
            }
        }else{
            while(line1 != null){
                sw.write(line1);
                line1 = imp2.readLine();
                c++;
            }
        }
        System.out.println("count: " + c);
        imp1.close();
        imp2.close();
        sw.close();

    }

    public static class QuickSort {
        // Java program for implementation of QuickSort
        //from https://www.geeksforgeeks.org/java-program-for-quicksort/

        /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
        public int partition(int arr[], int low, int high) {
            int pivot = arr[high];
            int i = (low - 1); // index of smaller element 
            for (int j = low; j < high; j++) {
                // If current element is smaller than or 
                // equal to pivot 
                if (arr[j] <= pivot) {
                    i++;

                    // swap arr[i] and arr[j] 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot) 
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

        /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
        public void sort(int arr[], int low, int high) {
            if (low < high) {
                /* pi is partitioning index, arr[pi] is  
              now at right place */
                int pi = partition(arr, low, high);

                // Recursively sort elements before 
                // partition and after partition 
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
        }
    }
}
