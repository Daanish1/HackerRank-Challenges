package LeetCode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {


        String ans = "";

        for (int start = 0; start < s.length(); start++) {
            for (int end = s.length()-1; end >= start; end--) {
                if ((end - start) < ans.length())
                    break;

                boolean isPalindrome = checkPalindrome(start, end, s);
                if ((isPalindrome) && ((end - start + 1) >= ans.length())) {
                    ans = s.substring(start, end+1);
                }

            }
        }

        return ans;
    }

    public static boolean checkPalindrome(int start, int end, String s) {
        while (end > start) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            end--;
            start++;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));


    }
}
