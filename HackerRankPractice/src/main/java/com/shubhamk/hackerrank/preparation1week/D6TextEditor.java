package com.shubhamk.hackerrank.preparation1week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class D6TextEditor {

    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbOutput = new StringBuilder();
            Stack<String> undo = new Stack<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int Q = Integer.parseInt(br.readLine());
            IntStream.range(0, Q).forEach(itr -> {
                try {
                    String[] op = br.readLine().split(" ");
                    switch (op[0]){
                        case "1":
                            undo.push(sb.toString());
                            sb.append(op[1]);
                            break;
                        case "2":
                            undo.push(sb.toString());
                            sb.delete(sb.length()-Integer.parseInt(op[1]), sb.length());
                            break;
                        case "3":
                            int a = Integer.parseInt(op[1]) - 1;
                            sbOutput.append(sb.charAt(a)+"\n");
                            break;
                        case "4":
                            sb.setLength(0);
                            sb.append(undo.pop());
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            System.out.println(sbOutput.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
