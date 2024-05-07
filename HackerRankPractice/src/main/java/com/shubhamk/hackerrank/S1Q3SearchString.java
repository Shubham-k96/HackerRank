package com.zoho;

import java.util.*;

/**
 * @author sbk11
 *
 * Save the string “WELCOMETOZOHOCORPORATION” in a two dimensional array and search for substring like “too” in the two dimensional string both from left to right and from top to bottom.
 * w e L C O
 * M E T O Z
 * O H O C O
 * R P O R A
 * T I O n
 * And print the start and ending index as
 * Start index : <1,2>
 * End index: <3, 2>
 */
public class S1Q3SearchString {
    public static void main(String[] args) {
        String str= "WELCOMETOZOHOCORPORATION";
        String toSearch= "CRN";
        searchString(str, toSearch);

    }

    public static void searchString(String str, String toSearch){
//        Map<String, String> res = new HashMap<>();
        boolean res = false;
        List<List<Character>> charArr= new ArrayList<>();
        int idx = 0;
        int lastIdx = str.length()%5-1;
        for (int i = 0; i < 5; i++) {
            List<Character> ls = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                ls.add(str.charAt(idx));
                idx++;
                if(i ==4 && j == lastIdx) break;
            }
            System.out.println(ls);
            charArr.add(ls);
        }
        boolean isPresent = toSearch.chars().allMatch(ch -> str.contains(String.valueOf((char)ch)));
        if (!isPresent) return /*false*/;
        int s = str.indexOf(toSearch.charAt(0))%5 -1 ;
        for (int i = s; i < charArr.size(); i++) {
            for (int j = 0; j < charArr.get(i).size(); j++) {
                searchFromCell(charArr, toSearch, i, j);
//                if (searchFromCell(charArr, toSearch, i, j)) {
//                    return true; // Word found
//                }
            }
        }
//        return res;
    }

    private static void searchFromCell(List<List<Character>> matrix, String word, int row, int col) {
        int rows = matrix.size();
        int len = word.length();

        // Check if the word can be found in the top-bottom direction
        if (row + len <= rows) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(matrix.get(row + i).get(col));
            }
            if (sb.toString().equals(word)) {
                System.out.println("tb start : "+row+" "+col);
                System.out.println("tb end : "+(row+sb.length()-1)+" "+col);
//                return true;
            }
        }

        // Check if the word can be found in the left-right direction
        if (col + len <= matrix.get(col).size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(matrix.get(row).get(col + i));
            }
            if (sb.toString().equals(word)) {
                System.out.println("lr start : "+row+" "+col);
                System.out.println("lr end : "+row+" "+(col+sb.length()-1));
//                return true;
            }
        }

//        return false; // Word not found starting from this cell
    }
}
