package LeetCode;

public class StringToInteger {
    public static int myAtoi(String s) {
        int len = s.length();
        double num = 0;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        if (i == s.length())
            return 0;

        boolean positive = s.charAt(i) == '+';
        boolean negative = s.charAt(i) == '-';

        if (positive || negative) {
            i++;
        }

        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num *10 + (s.charAt(i)-'0');
            i++;
        }

        num = negative ? -num : num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;

        return (int)num;
    }

    public static void main(String[] args) {
        System.out.println(StringToInteger.myAtoi("      -42"));


    }


}
