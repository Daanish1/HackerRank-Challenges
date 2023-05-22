package LeetCode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        int reverseNum = 0;
        int currNum = x;

        if (x < 0) {
            return false;
        }

        while (currNum != 0) {
            int rem = currNum % 10;
            reverseNum = reverseNum*10 + rem;
            currNum = currNum / 10;

        }

        return x == reverseNum;

    }

    public static void main(String[] args) {
        System.out.println(PalindromeNumber.isPalindrome(140451));
    }

}
