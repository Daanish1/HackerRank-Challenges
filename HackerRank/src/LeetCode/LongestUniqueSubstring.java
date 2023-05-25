package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxSubstr = 0;

        Map<Character, Integer> vals = new HashMap<>();

        for (int end = 0, start = 0; end < s.length(); end++) {
            if (vals.containsKey(s.charAt(end))) {
                start = Math.max(vals.get(s.charAt(end)), start);
            }
            maxSubstr = Math.max(maxSubstr, end - start + 1);
            vals.put(s.charAt(end), end+1);


        }

        return maxSubstr;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
