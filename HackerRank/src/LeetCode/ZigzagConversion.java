package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        List<List<Character>> output = new ArrayList<List<Character>>();

        if (numRows == 1)
            return s;


        for (int i = 0; i < numRows; i++) {
            output.add(new ArrayList<>());
        }

        boolean goingDown = true;

        int outputIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            output.get(outputIndex).add(currentChar);

            if (goingDown) {
                outputIndex++;
            } else {
                outputIndex--;
            }

            if (outputIndex >= numRows) {
                goingDown = false;
                outputIndex -= 2;


            }

            if (outputIndex < 0) {
                goingDown = true;
                outputIndex += 2;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (List<Character> current : output) {
            for (int i = 0; i < current.size(); i++) {
                builder.append(current.get(i));
            }
        }

        return builder.toString();


    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
