package com.shubhamk.hackerrank.datastructure.array;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ArrayManipulationResult {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        //prefix sum algo
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i < n+1;i++){
            arr.add(0);
        }
        for (List<Integer> query:queries) {
            int a = query.get(0)-1;
            int b = query.get(1)-1;
            int k = query.get(2);
          // brute force : will fail for large data set
//            for (int i = a; i <= b; i++) {
//                int tmp = arr.get(i);
//                arr.set(i, tmp+k);
//            }

            // prefix sum algo
            arr.set(a, arr.get(a)+k);
            arr.set(b+1, arr.get(b)-k);
        }
        long max = 0l;
        long sum = 0l;
        for (int i = 0; i < n+1; i++) {
            sum += arr.get(i);
            max = Math.max(max,sum);
        }
        return max;
    }

}
public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\Practice\\HackerRank\\test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        long start = System.currentTimeMillis();
        long result = ArrayManipulationResult.arrayManipulation(n, queries);
        long end = System.currentTimeMillis();
        float duration = (end - start) / 1000F;
        System.out.println(duration + " seconds");
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
