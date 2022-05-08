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

class D6JesseAndCookieResult {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        /*Collections.sort(A);
        if (A.get(0) >= k)
            return cnt;
        else {
            int s = A.get(0)+ (2*A.get(1));
            A.remove(0);
            A.remove(0);
            A.add(s);
            cnt++;
            return cookies(k, A);
        }*/
       // int cnt=0;
        Queue<Integer> B = new PriorityQueue<>(A);
        int i = 0;
        while (true) {
            if (B.peek() >= k)
                return i;
            try {
                B.add(B.remove() + 2 * B.remove());
            } catch (Exception e) {
                return -1;
            }
            i++;
        }
        /*while(q.peek() < k && q.size() > 1){
            int ne = q.poll() + 2*q.poll();
            q.add(ne);
            cnt++;
        }
        return (q.peek() >= k) ? (cnt) : -1;*/
    }
}

public class D6JesseAndCookie {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = D6JesseAndCookieResult.cookies(k, A);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

