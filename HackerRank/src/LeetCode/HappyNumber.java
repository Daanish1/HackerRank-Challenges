package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> history = new HashSet<Integer>();
        history.add(n);
        int current = n;

        while (current != 1) {
            int tempNumber = current;
            int sum = 0;

            while (tempNumber != 0) {
                sum += Math.pow(tempNumber % 10, 2);
                tempNumber = tempNumber / 10;
            }
            if (history.contains(sum)) {
                return false;
            } else {
                history.add(sum);
            }
            current = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = isHappy(7);
        System.out.println(res);
    }

}
