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

class D1MinMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter
     *  Input (stdin)
        793810624 895642170 685903712 623789054 468592370
        Expected Output
        2572095760 2999145560.
        *
        * 426980153 354802167 142980735 968217435 734892650
        * 1659655705 2484892405
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min=0;
        long max=0;
        for (int i = 0; i < arr.size(); i++) {
            long tmp=0;
            for (int j = 0; j < arr.size(); j++) {
                if (i!=j)
                    tmp += arr.get(j);
                if (i==0)
                    max=min=tmp;
            }
            if (tmp>max)
                max=tmp;
            else if (tmp<min)
                min=tmp;
        }
        System.out.println(min+" "+max);
    }

}

public class D1MinMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        D1MinMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
