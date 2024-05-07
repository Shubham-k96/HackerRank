package com.zoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author sbk11
 *
 * Alternate sorting: Given an array of integers, rearrange the array in such a way that the first
 * element is first maximum and second element is first minimum.
 * Eg. Input : {1, 2, 3, 4, 5, 6, 7}
 * Output : {7, 1, 6, 2, 5, 3, 4}
 *
 */
public class S2Q1AlternateSorting {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(/*12, 22, 32, 14, 54, 16, 7*/1,2,3,44,5,6,7);
//        Collections.sort(arr);
        //bubble sort
        int n = arr.size();
        boolean swapped=false;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr.get(j) > arr.get(j+1)){
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println(i);
                break;
            }
        }
        System.out.println(arr);
        int sIdx = 0, eIdx = n-1;
        List<Integer> res = new ArrayList<>();
        while (eIdx >= sIdx){
            res.add(arr.get(eIdx));
            if(sIdx != eIdx) res.add(arr.get(sIdx));
            eIdx--; sIdx++;
        }
        System.out.println(res);
    }
}
