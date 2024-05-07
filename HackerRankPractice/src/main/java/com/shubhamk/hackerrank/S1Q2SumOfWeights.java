package com.zoho;

import java.util.*;

/**
 * @author shubhamk
 *
 * Given a set of numbers like <10, 36, 54,89,12> we want to find sum of weights based on the following conditions
 * 1. 5 if a perfect square
 * 2. 4 if multiple of 4 and divisible by 6
 * 3. 3 if even number
 * And sort the numbers based on the weight and print it as follows
 * <10,its_weight>,<36,its weight><89,its weight> Should display the numbers based on increasing order.
 *
 */

public class S1Q2SumOfWeights {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 36, 54,89,12);
        Map<Integer, Integer> numWithWeight = new HashMap<>();
        for (Integer i: nums) {
            numWithWeight.put(i, condition1(i)+condition2(i)+condition3(i));
        }

        numWithWeight.entrySet().stream()
                .sorted((k1, k2) -> -k2.getValue().compareTo(k1.getValue()))
                .forEach(k-> System.out.println("<"+k.getKey()+","+k.getValue()+">"));
    }

    static int condition1(int a){
        double sqrt = Math.sqrt(a);
        return (sqrt == (int)sqrt) ? 5 : 0;
    }
    static int condition2(int a){
        return ((a / 4 == 0) && (a / 6 == 0)) ? 4 : 0;
    }
    static int condition3(int a){
        return (a%2 ==0) ? 3 : 0;
    }
}
