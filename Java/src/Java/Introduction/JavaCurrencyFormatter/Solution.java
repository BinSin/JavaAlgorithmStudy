package Java.Introduction.JavaCurrencyFormatter;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String us = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String india = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = nf.format(payment);
        
        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = nf.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

