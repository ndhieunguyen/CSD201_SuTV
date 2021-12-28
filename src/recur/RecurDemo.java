/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recur;

import java.util.Stack;

/**
 *
 * @author LENOVO
 */
public class RecurDemo {
    // Compute n!
    public static double factorial(int n) {
        if (n<2) return 1;
        return n*factorial(n-1);
    }
    
    // Calculate the nth Fibonacci number
    public static int fibo(int n){
        if (n<2) return 1;
        return fibo(n-1) + fibo(n-2);
    }
    
    // test if a number belongs to fibonacci set
    public static boolean testFibo(int x){
        if (x<1) return false;
        int n=1;
        while (fibo(n)<x) n++;
        return x==fibo(n);
    }
    
    // Compute the nth item of an arithmetic progression
    public static double ap(int n, double a, double d){
        if (n<2) return a;
        return ap(n-1, a, d) + d;
    }
    
    // Compute the nth item of a geometric progression
    public static double gp(int n, double a, double q){
        if (n<2) return a;
        return gp(n-1, a, q) * q;
    }
    
    // Calculate sum of integral array having n elements
    public static double sum(double[] a, int n){
        if (n<1) return 0;
        return sum(a, n-1) + a[n-1];
    }
    
    // Calculate the maximum value in an integral array
    public static int max(int[] a, int n){
        if (n==1) return a[0];
        int m = max(a, n-1);
        return m>a[n-1] ? m : a[n-1];
    }
    
    // Calculate the minimum value in an integral array
    public static int min(int[] a, int n){
        if (n==1) return a[0];
        int m = min(a, n-1);
        return m<a[n-1] ? m : a[n-1];
    }
    
    // Convert a decimal integer to a numeric string in specific base
    public static String convert(int n, int base){
        if (n==0) return "0";
        return convert(n/base, base) + Character.forDigit(n%base, base);
    }
    
    public static String convert2(int n, int base) {
        String result = "";
        do {
            result = Character.forDigit(n%base, base) + result;
            n/=base;
        } while (n>0);
        return result;
    }
    
    public static String convert3(int n, int base) {
        Stack<Character> stk = new Stack();
        do {
            stk.push(Character.forDigit(n%base, base));
            n/=base;
        } while (n>0);
        String result = "";
        while (!stk.empty()) result += stk.pop();
        return result;
    }
    
    public static void main(String[] args) {
//        System.out.println(factorial(5));

//        System.out.println(testFibo(89));

//        System.out.println(ap(6, 1.5, 2));

//        System.out.println(gp(6, 1.5, 2));

//        double a[] = {1.5, 2, 4, 5, 2, 6.5};
//        System.out.println(sum(a, 6));

//        int b[] = {1, 5, 9, 7, 2, 19, 10};
//        System.out.println(max(b, 7));
//        System.out.println(min(b,7));
        
        int n=266;
        long t1, t2;
        t1 = System.currentTimeMillis();
        System.out.println("Binary: " + convert(n,2));
        System.out.println("Decimal: " + convert(n, 10));
        System.out.println("Octal: " + convert(n, 8));
        System.out.println("Hexadecimal: " + convert(n, 16));
        t2 = System.currentTimeMillis();
        System.out.println("Recursion: " + (t2-t1) + "\n");
        
        t1 = System.currentTimeMillis();
        System.out.println("Binary: " + convert2(n,2));
        System.out.println("Decimal: " + convert2(n, 10));
        System.out.println("Octal: " + convert2(n, 8));
        System.out.println("Hexadecimal: " + convert2(n, 16));
        t2 = System.currentTimeMillis();
        System.out.println("Iteration: " + (t2-t1) + "\n");
        
        t1 = System.currentTimeMillis();
        System.out.println("Binary: " + convert3(n,2));
        System.out.println("Decimal: " + convert3(n, 10));
        System.out.println("Octal: " + convert3(n, 8));
        System.out.println("Hexadecimal: " + convert3(n, 16));
        t2 = System.currentTimeMillis();
        System.out.println("Stack: " + (t2-t1) + "\n");
    }
}
