package com.zoho;

/**
 * @author shubhamk
 *
 * Print the word with odd letters as
 * P     M
 *  R   A
 *   O R
 *    G
 *   O R
 *  R   A
 * P     M
 */

public class S1Q1OddLetterPattern {
    public static void main(String[] args) {
        String str = "PROGRAM";
        int n = str.length();
        int sIdx=0, eIdx = n-1;
        int midIdx = n/2;
        while (sIdx!= n){
            for (int i = 0; i < (Math.min(eIdx, sIdx)); i++) {
                System.out.print(" ");
            }
            System.out.print(str.charAt(Math.min(eIdx, sIdx)));
            for (int i = 0; i < Math.abs(sIdx-eIdx); i++)
                System.out.print(" ");
            System.out.print((midIdx == eIdx ) ? "" : str.charAt(Math.max(eIdx, sIdx)));
            sIdx++; eIdx--;
            System.out.println();
        }
    }
}
