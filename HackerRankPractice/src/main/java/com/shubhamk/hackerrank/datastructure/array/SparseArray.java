package com.shubhamk.hackerrank.datastructure.array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SparseArrayResult {
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        for (String query : queries) {
            if (strings.contains(query)) {
                int cnt=0;
                for (String str : strings){
                    if (str.equals(query)) {
                        cnt++;
                    }
                }
                ans.add(cnt);
            }else
                ans.add(0);
        }
        return ans;
    }
}

public class SparseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\Practice\\HackerRank\\test.txt"));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());
        long start = System.currentTimeMillis();
        List<Integer> res = SparseArrayResult.matchingStrings(strings, queries);
        System.out.println(res);
        long end = System.currentTimeMillis();
        float duration = (end - start) / 1000F;
        System.out.println(duration + " seconds");
        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
