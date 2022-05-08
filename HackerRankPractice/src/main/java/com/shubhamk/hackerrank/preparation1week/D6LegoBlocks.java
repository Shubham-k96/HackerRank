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

class D6LegoBlocksResult {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n    height   .
     *  2. INTEGER m    width
     */
    int md=1000000007;
    int[][] ways = null;
    int[][] waysRestrict = null;
    public void init(int n, int m){
        ways = new int[n+1][m+1];
        waysRestrict = new int[n+1][m+1];
        for(int[] w : ways) Arrays.fill(w, -1);
        for(int[] w : waysRestrict) Arrays.fill(w, -1);
    }
    public int solve(int n, int m){
        if (ways[n][m] != -1) return ways[n][m];
        long ans;
        if (m==1) ans = 1;
        else if (n==1){
            if (m<=4) {
                ans = 2*solve(1,m-1);
            }
            else {
                ans = solve(1,m-1);
                ans = (ans + solve(1,m-2))%md;
                ans = (ans + solve(1,m-3))%md;
                ans = (ans + solve(1,m-4))%md;
            }
        }
        else{
            ans = 1; int one = solve(1,m);
            for (int i=0; i<n; i++) ans = (ans * one)%md;
        }
        ways[n][m] = (int)ans;
        return ways[n][m];
    }
    public int solveRestrict(int n, int m){
        if (waysRestrict[n][m] != -1) return waysRestrict[n][m];
        long ans;
        if (m==1) ans = 1;

        else {
            ans = solve(n,m);
            for (int i=1; i<m; i++) {
                long a = solve(n,i);
                a = (a*solveRestrict(n,m-i))%md;
                ans -= a;
                if (ans<0) ans+=md;
            }
        }
        waysRestrict[n][m] = (int)ans;
        return waysRestrict[n][m];
    }

    public static int legoBlocks(int n, int m) {
        D6LegoBlocksResult result = new D6LegoBlocksResult();
        result.init(n, m);
        return result.solveRestrict(n,m);
    }

}
public class D6LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = D6LegoBlocksResult.legoBlocks(n, m);
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
