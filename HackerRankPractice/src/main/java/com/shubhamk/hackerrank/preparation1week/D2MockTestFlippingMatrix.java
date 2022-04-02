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


/*
* 1
2
112 42 83 119
56 125 56 49
15 78 101 43
* 414
*
* 1
2
107 54 128 15
12 75 110 138
100 96 34 85
75 15 28 112
*
* 488
* */
class D2MockTestFlippingMatrixResult {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int sum = 0;
        int n = matrix.size()/2;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num1 = matrix.get(i).get((2*n) - j - 1);
                int num2 = matrix.get(i).get(j);
                int num3 = matrix.get((2*n) - i - 1).get(j);
                int num4 = matrix.get((2*n) - i - 1).get((2*n) - j - 1);

                sum += Math.max(num1, Math.max(num2, Math.max(num3, num4)));
            }
        }
        return sum;
    }

}
public class D2MockTestFlippingMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\Practice\\HackerRank\\test.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = D2MockTestFlippingMatrixResult.flippingMatrix(matrix);
                System.out.println(result);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
