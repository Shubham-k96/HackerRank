package com.shubhamk.hackerrank.datastructure.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

///https://www.hackerrank.com/challenges/2d-array/problem?isFullScreen=true
public class DS2dArray {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                List<Integer> str;
                arr.add(
                        str = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())

                );
                if(str.size() != 6)
                    throw new Exception("Invalid arr");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DS2dArray.hourglassSum(arr);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int hourglassSum(List<List<Integer>> arr) {
        //List sumArr= new ArrayList<>();
        int max =0;
        int clmSize = arr.size();
        int rowSize=0;
        for(int i=0;i< clmSize;i++){
            rowSize = arr.get(i).size();
            for(int j=0;j<rowSize;j++){
                int sum=0;
                if(i+2 < arr.size() && j+2 < arr.get(i).size()){
                    sum=arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                                            arr.get(i+1).get(j+1)+
                            arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                }else
                    break;
                if(i==0 && j == 0 || sum > max)
                    max=sum;
//                if(sum>0)
//                    sumArr.add(sum);
            }
        }
//        System.out.println(sumArr.size());
//        System.out.println(sumArr);
        return max;
    }
}
