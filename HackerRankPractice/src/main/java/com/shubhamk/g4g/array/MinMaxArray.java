package com.shubhamk.g4g.array;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxArray {
    static class Pair {
        int max;
        int min;

        Pair() {
            max = 0;
            min = 0;
        }

        @Override
        public String toString() {
            return "Pair{ max=" + max + ", min=" + min + '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array");
        String arrayStr = sc.nextLine();
        int[] arr = Arrays.stream(arrayStr.split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        Pair pair = getMinMaxPair(arr);
        System.out.println(pair);
    }

    private static Pair getMinMaxPair(int[] arr) {
        Pair pair = new Pair();
        int n = arr.length;
        int i=0;
        if(n==1){
            pair.max=arr[0];
            pair.min=arr[0];
        }
        else if(n==2){
            if(arr[0]>arr[1]){
                pair.max=arr[0];
                pair.min=arr[1];
            }else{
                pair.max=arr[1];
                pair.min=arr[0];
            }
        }else {

        }
        return pair;
    }
}
