package com.zoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sbk11
 *
 * Given a two dimensional array of string like
 * <”luke”, “shaw”>
 * <”wayne”, “rooney”>
 * <”rooney”, “ronaldo”>
 * <”shaw”, “rooney”>
 * Where the first string is “child”, second string is “Father”. And given “ronaldo” we have to find his
 * no of grandchildren Here “ronaldo” has 2 grandchildren. So our output should be 2.
 */
public class S1Q4GrandChildren {
    public static void main(String[] args) {
        List<List<String>> family = new ArrayList<>();
        family.add(new ArrayList<>(Arrays.asList("luke","shaw")));
        family.add(new ArrayList<>(Arrays.asList("wayne","rooney")));
        family.add(new ArrayList<>(Arrays.asList("rooney","ronaldo")));
        family.add(new ArrayList<>(Arrays.asList("shaw","rooney")));
        System.out.println(family);
        int resCnt = 0;
        String name = "rooney";
        String childName = null;
        for(List<String> singleRec : family)
            if(singleRec.contains(name) && singleRec.get(1).equalsIgnoreCase(name)) {
                childName = singleRec.get(0); break;
            }
        for(List<String> singleRec : family)
            if(singleRec.contains(childName) && singleRec.get(1).equalsIgnoreCase(childName))
                resCnt++;

        System.out.println(resCnt);

    }
}
