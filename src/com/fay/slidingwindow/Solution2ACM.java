package com.fay.slidingwindow;

import java.util.*;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p =  sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) return res;
        int[] cntP = new int[26];
        int[] cntS = new int[26];
        for (int i = 0; i < pLen; i++) {
            cntP[p.charAt(i) - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < sLen; r++) {
            cntS[s.charAt(r) - 'a']++;
            if (r - l + 1 < pLen) {
                continue;
            }
            if (Arrays.equals(cntP, cntS)) {
                res.add(l);
            }
            cntS[s.charAt(l) - 'a']--;
            l++;
        }
        return res;
    }
}
