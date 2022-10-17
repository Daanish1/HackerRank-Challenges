package interviewprep.string;

import java.util.ArrayList;

public class SpecialStringAgain {

    public static long substrCount(int n, String s) {
        long numSubCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                String currentSub = s.substring(i, j);
                //Perform checks:
                ArrayList<Character> charsInSub = new ArrayList<>();
                char first = currentSub.charAt(0);
                charsInSub.add(first);

                for (int k = 1; k < currentSub.length(); k++) {
                    if (currentSub.charAt(k) != first) {
                        charsInSub.add(currentSub.charAt(k));
                    }
                }
                if (charsInSub.size() == 1) {
                    numSubCount++;
                } else if (charsInSub.size() == 2) {
                    boolean hasMiddle = currentSub.length() % 2 != 0;

                    boolean inMiddle = charsInSub.get(charsInSub.size() / 2) == charsInSub.get(1);

                    if ((hasMiddle) && (inMiddle)) {
                        numSubCount++;
                    }

                }

            }
        }

        return numSubCount;
    }



    public static long efficientSubstrCount(int n, String s) {
        long numSubCount = n;

        for (int i = 0; i < n-1; i++) {
            long charOneCount = 1;
            long charTwoCount = 0;

            char firstChar = s.charAt(i);
            for (int j = i+1; j < n; j++) {
                char newChar = s.charAt(j);
                if (newChar == firstChar) {
                    charOneCount++;
                } else {
                    charTwoCount++;
                }

                if (charTwoCount > 1) {
                    break;
                }

                if (charTwoCount == 0) {
                    numSubCount++;
                } else if ((charTwoCount == 1) && (charOneCount % 2 == 0) && (s.charAt(i + ((j - i) / 2))  != firstChar)) {
                    numSubCount++;
                }


            }
        }

        return numSubCount;

    }

    public static void main(String[] args) {
        String s = "asasd";

//        long result = substrCount(s.length(), s);
        long result = efficientSubstrCount(s.length(), s);

        System.out.println(result);
    }
}
