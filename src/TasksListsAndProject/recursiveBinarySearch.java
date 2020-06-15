/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

/**
 *
 * @author 1511 FOX
 */
public class recursiveBinarySearch {
    public static int comp = 0;
    
    //used at /randonNumbers/TestSearch.java
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
