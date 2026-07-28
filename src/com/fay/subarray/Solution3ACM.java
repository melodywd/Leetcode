package com.fay.subarray;

import java.util.Scanner;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        String t =  sc.nextLine();
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        int left = 0;
        int n = s.length();
        int resLeft = -1;
        int resRight = n;
        for (int right = 0; right < n; right++) {
            cntS[s.charAt(right)]++;
            while (isCovered(cntS,cntT)) {
                if  (right - left  < resRight -  resLeft) {
                    resLeft = left;
                    resRight = right;
                }
                cntS[s.charAt(left)]--;
                left++;
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resRight + 1);
    }

    private static boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i < 'Z'; i++) {
            if (cntS[i] <  cntT[i]) return false;
        }
        for (int i = 'a'; i < 'z'; i++) {
            if (cntS[i] <  cntT[i]) return false;
        }
        return true;
    }
}
