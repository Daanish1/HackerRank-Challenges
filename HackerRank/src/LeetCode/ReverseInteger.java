package LeetCode;

import java.util.ArrayList;

public class ReverseInteger {

    public static int reverse(int x) {
        ArrayList<Integer> digits = new ArrayList<>();
        int currentNum = Math.abs(x);

        while (currentNum > 0) {
            int remainder = currentNum % 10;
            currentNum = currentNum / 10;
            digits.add(remainder);

        }

        long newNum = 0;
        long multiplier = 1;

        for (int i = digits.size()-1; i >= 0; i--) {
            newNum += digits.get(i) * multiplier;
            multiplier *= 10;
        }



        if (x < 0) {
            newNum *= -1;
        }

        //check bounds
        if ((newNum >= -Math.pow(2, 31)) && (newNum <= (Math.pow(2, 31) - 1)))
            return (int)newNum;
        else
            return 0;


    }


    public static int conciseReverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        long rev = 0;
        while (x > 0) {
            rev = (rev*10) + (x % 10);
            x = x / 10;
        }

        if (rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) (isNeg ? -rev : rev);
    }


    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(conciseReverse(5316));
    }
}
