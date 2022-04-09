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



class D3MockTestPalindromeIndexResult {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
//        char[] cArr = s.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int idx = -1;
//        for (int i = 0; i < cArr.length; i++) {
//            sb.append(cArr[i]);
//            if(sb.reverse().equals(sb)){
//                idx = -1;
//                continue;
//            }
//            else
//                idx = i;
//        }
//        return idx;

        int n = s.length();
        int i,j,a,b;
        for (i=0, j=n-1; i<n; i++,j--){
            if (s.charAt(i)!=s.charAt(j))
                break;
        }
        if (i>j) return -1;

        for (a = i+1, b = j;a<j && b>i+1; a++,b--){
            if (s.charAt(a)!=s.charAt(b))
                return j;
        }
        return i;
    }

}

public class D3MockTestPalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = D3MockTestPalindromeIndexResult.palindromeIndex(s);
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
