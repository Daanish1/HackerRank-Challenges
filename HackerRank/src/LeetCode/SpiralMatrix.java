package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    //NOT MY CODE (Couldnt Solve Myself)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] n = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> res =  spiralOrder(n);
        System.out.println(res);
    }

}



/*
for (int j = rStart; j < rEnd; j++) {
                result.add(matrix[currentR][j]);
            }
            currentC = rEnd;
            rStart--;

            for (int i = cStart; i < cEnd; i++) {
                result.add(matrix[i][currentC]);
            }
            currentR = cEnd;
            cEnd--;

            for (int j = rEnd; j >= rStart; j--) {
                result.add(matrix[currentR][j]);
            }
 */
