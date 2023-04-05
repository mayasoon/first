package com.company;

import java.util.HashMap;
import java.util.Map;

//abdcadw  字符串最长不重复子序列
public class StringMaxUnRepetition {
    String s = "abbcda";

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);//记录a，a的下标
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
