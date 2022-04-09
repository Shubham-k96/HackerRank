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

class D3CaeserCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        char[] cArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c:cArr) {
            if(Character.isAlphabetic(c)) {
                int tmp = c-0; // convert char to int (ASCII value)
                int factor = Character.isUpperCase(c) ? 65 : 97;
                tmp = ( tmp + k - factor ) % 26 + factor;
                sb.append(Character.toChars(tmp));
            }else
                sb.append(c);
        }
        return sb.toString();
    }

}

public class D3CaeserCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = D3CaeserCipherResult.caesarCipher(s, k);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
