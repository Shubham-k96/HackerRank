package com.shubhamk.hackerrank.preparation1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D5QueueUsingTwoStacks {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void enqueue(Integer data){
        if (s1.isEmpty() && s2.isEmpty())
            s1.push(data);
        else
            s2.push(data);
    }

    static Integer dequeue(){
        if (s1.isEmpty())
           moveStack();
        return s1.pop();
    }

    static Integer peek(){
        if (s1.isEmpty())
            moveStack();
        return s1.peek();
    }

    static void moveStack(){
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Integer q = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(0, q).forEach(itr -> {
                try {
                    String inp = bufferedReader.readLine();
                    if (inp.startsWith("1")) {
                        List<Integer> a = Stream.of(inp.split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        enqueue(a.get(1));
                    } else if (inp.startsWith("2")) {
                       dequeue();
                    } else {
                       System.out.println(peek());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
