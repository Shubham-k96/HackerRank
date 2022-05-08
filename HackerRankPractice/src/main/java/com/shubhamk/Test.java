package com.shubhamk;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Test {
    public static void main (String[] args){
        UnaryOperator<Integer> sub = a -> a - 1;
        UnaryOperator<Integer> sum = a -> a + 5;
//        System.out.println(xor.apply(2));
//        System.out.println(and.apply(2));
        Function<Integer, Integer> compose = sum.andThen(sub);
        System.out.println(compose.apply(2));

        Function<Integer, Integer> compose1 = sum.compose(sub);
        System.out.println(compose1.apply(231));

        List<String> songTitles = Arrays.asList("humble", "element", "dna");
        Function<String, String> capitalize = (str) -> str.toUpperCase();
        songTitles.stream().map(capitalize).forEach(System.out::println);

    }

}
