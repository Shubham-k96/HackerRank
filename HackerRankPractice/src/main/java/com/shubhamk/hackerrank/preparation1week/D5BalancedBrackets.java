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

class D5BalancedBracketsResult {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        if (s.length() % 2 != 0 )
            return "NO";
        Stack<Character> stack =  new Stack<>();
        int n = s.length();
        String open = "{[(";
        String close = "}])";
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (open.indexOf(c) >= 0)
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return "NO";
                Character peeked = stack.peek();
                if (open.indexOf(peeked) == close.indexOf(c))
                    stack.pop();
                else return "NO";

            }
        }
        return (stack.isEmpty()) ? "YES" : "NO";
    }

}

public class D5BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = D5BalancedBracketsResult.isBalanced(s);
                System.out.println(result);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
