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

class D4NewYearChaosResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        boolean isChaotic=false;
        int last = q.get(q.size()-1);
        int b=0;
        for (int i = q.size()-2; i >= 0; i--) {
            if(q.get(i) > i+3){
                isChaotic=true;
                break;
            }else if (q.get(i) == i+3){
                b+=2;
            }else if(q.get(i) > last)
                ++b;
            else
                last = q.get(i);

        }
        System.out.println(isChaotic ? "Too chaotic" : b);
    }

}

public class D4NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                D4NewYearChaosResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
