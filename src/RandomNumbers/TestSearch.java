/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomNumbers;

import java.util.Random;

/**
 *
 * @author 1511 FOX
 */
public class TestSearch {

    public static int comp;

    public static void main(String[] args) {

        int seed = 1;
        Random rng = new Random(seed);

        for (int n = 10; n <= 200; n++) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }

            int trials = 10000;
            double bin_sum = 0.0, seq_sum = 0.0;

            for (int i = 0; i < trials; i++) {

                int r = rng.nextInt(array.length);

                comp = 0;
                sequential(array, r);
                seq_sum += comp;

                comp = 0;
//                binary(array, r);
//                bin_sum += comp;
                
                binarySearch(array, r, 0, array.length - 1);
                bin_sum += comp;
            }

//            System.out.println("mean seq: " + seq_sum / trials);
//            System.out.println("mean bin: " + bin_sum / trials);
            System.out.println(n + "; " + seq_sum / trials + "; " + bin_sum / trials);
        }
    }

    public static boolean sequential(int[] v, int a) {

        boolean r = false;

        for (int i = 0; i < v.length; i++) {
            comp++;
            if (v[i] == a) {
                r = true;
                break;
            }
        }

        return r;
    }

    public static boolean binary(int[] v, int a) {

        boolean r = false;

        int low = 0, high = v.length - 1;
        while (low <= high) {
            int mid = ((low + high) / 2);
            comp++;
            if (v[mid] == a) {
                r = true;
                break;
            }
            comp++;
            if (v[mid] > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return r;
    }

    public static boolean binarySearch(int sorted[], int n, int low, int high) {
        //stop case
        if(low > high){
            return false;
        }
        
        int mid = ((low + high) / 2);
        comp++;
        
        if(n == sorted[mid]){
            return true;
        }
        
        comp ++;
        
        //general case
        if (n < sorted[mid]) {//left
            high = mid - 1;
            return binarySearch(sorted, n, low, high);
        } else {//right
            low = mid + 1;
            return binarySearch(sorted, n, low, high);
        }
    }
}
