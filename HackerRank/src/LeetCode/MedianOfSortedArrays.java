package LeetCode;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = new int[nums1.length + nums2.length];
        int num1Index = 0;
        int num2Index = 0;

        int mergedArrIndex = 0;

        while ((num1Index < nums1.length) && (num2Index < nums2.length)) {
            if (nums1[num1Index] <= nums2[num2Index]) {
                mergedArr[mergedArrIndex] = nums1[num1Index];
                num1Index++;
            } else {
                mergedArr[mergedArrIndex] = nums2[num2Index];
                num2Index++;
            }

            mergedArrIndex++;

        }
        if (num1Index >= nums1.length) {
            for (int i = num2Index; i < nums2.length; i++) {
                mergedArr[mergedArrIndex] = nums2[i];
                mergedArrIndex++;
            }
        } else {
            for (int i = num1Index; i < nums1.length; i++) {
                mergedArr[mergedArrIndex] = nums1[i];
                mergedArrIndex++;
            }
        }

        double median;
        if (mergedArr.length % 2 == 0) {
            median = (mergedArr[mergedArr.length/2] + mergedArr[(mergedArr.length/2)-1])/2.0;
        } else {
            median = mergedArr[mergedArr.length/2];
        }

        return median;

    }


    public static void main(String[] args) {
    }
}
