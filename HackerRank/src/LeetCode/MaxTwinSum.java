package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxTwinSum {
    public int pairSum(ListNode head) {

        int listLength = 1;
        ListNode curr = head;

        while (curr.next != null) {
            listLength++;
            curr = curr.next;
        }
        Map<Integer, Integer> map = new HashMap<>();
        curr = head;
        int maxSum = -1;
        int count = 0;

        while (curr != null) {
            System.out.println(curr.val);
            if (map.containsKey(listLength - 1 - count)) {
                int tempSum = curr.val + (map.get(listLength - 1 - count));
                if (tempSum >= maxSum) {
                    maxSum = tempSum;
                }

            } else {
                map.put(count, curr.val);
            }

            count++;
            curr = curr.next;

        }

        return maxSum;
    }

    //Faster Solution
    public int pairSumAlt(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            ListNode nextNode = slowPtr.next;
            slowPtr.next = prevPtr;
            prevPtr = slowPtr;
            slowPtr = nextNode;

        }

        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        int maxSum = Integer.MIN_VALUE;
        while (slowPtr != null) {
            maxSum = Math.max(maxSum, slowPtr.val + prevPtr.val);
            slowPtr = slowPtr.next;
            prevPtr = prevPtr.next;
        }

        return maxSum;
    }
}
