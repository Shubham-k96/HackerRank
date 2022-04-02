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

class D1TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
            Date date = sdf.parse(s);
            SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            return sdf1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

}

public class D1TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\Practice\\HackerRank\\test.txt"));

        String s = bufferedReader.readLine();

        String result = D1TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
