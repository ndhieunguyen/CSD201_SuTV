/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

/**
 *
 * @author LENOVO
 */
public class BinarySearch {
    public static boolean binarySearchRecur(int[] data, int target, int low, int high) {
        if (low>high) return false;
        else {
            int mid = (low+high)/2;
            if (target == data[mid]) return true;
            else if (target<data[mid])
                return binarySearchRecur(data, target, low, mid-1);
            else return binarySearchRecur(data, target, mid+1, high);
        }
    }
    
    public static boolean binarySearchIterative(int[] data, int target) {
        int low=0;
        int high=data.length - 1;
        while (low<=high){
            int mid= (low+high)/2;
            if (target==data[mid]) return true;
            else if (target < data[mid]) high = mid-1;
            else low = mid + 1;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] a = new int[100000000];
        long t1, t2;
        for (int i = 0; i < 100000000; i++) {
            a[i] = i;
        }
        t1 = System.currentTimeMillis();
        System.out.println(binarySearchRecur(a, 50, 0, 99999999));
        t2 = System.currentTimeMillis();
        System.out.println("Recursion: " + (t2-t1) + " milisec");
        
        t1 = System.currentTimeMillis();
        System.out.println(binarySearchIterative(a, 50));
        t2 = System.currentTimeMillis();
        System.out.println("Iterative: " + (t2-t1) + " milisec");
    }
}
