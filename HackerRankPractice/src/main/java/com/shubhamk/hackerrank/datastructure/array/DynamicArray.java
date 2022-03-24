package com.shubhamk.hackerrank.datastructure.array;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DynamicArrayResult {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        int la =0;
        for (int i =0 ; i<n;i++){
            arr.add(new ArrayList<Integer>());
        }
        for(List<Integer> query : queries){
            int idx = (query.get(1)^la)%n;
            if(query.get(0)==1){
                arr.get(idx).add(query.get(2));
            }
            if(query.get(0)==2){
                la = arr.get(idx).get(query.get(2)%arr.get(idx).size());
                ans.add(la);
            }
        }
        return ans;
    }
}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\Practice\\HackerRank\\test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
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

        List<Integer> result = DynamicArrayResult.dynamicArray(n, queries);
        System.out.println(result);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

    }
}
