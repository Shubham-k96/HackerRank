package com.shubhamk.g4g.array;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array");
        String arrayStr = sc.nextLine();
        int[] arr = Arrays.stream(arrayStr.split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        int[] ans = reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println("\n====");
        int[] ans1 = reverseArray1(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ans1[i]+" ");
        }
        System.out.println("\n====");
    }

    private static int[] reverseArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            int j = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = j;
        }
        return array;
    }

    private static int[]  reverseArray1(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
