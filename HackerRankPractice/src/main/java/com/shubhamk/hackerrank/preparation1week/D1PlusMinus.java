package com.shubhamk.hackerrank.preparation1week;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class D1PlusMinusResult {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double[] cnt = new double[3];
        for (Integer i:arr) {
            if (i<0)
                cnt[0]+= 1;
            else if (i==0)
                cnt[1]+= 1;
            else
                cnt[2]+= 1;
        }
        int n = arr.size();
        for (int i = 0; i < cnt.length; i++) {
            System.out.println(String.format("%.6f",cnt[i]/n));
        }
    }

}

public class D1PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        D1PlusMinusResult.plusMinus(arr);

        bufferedReader.close();
    }
}
