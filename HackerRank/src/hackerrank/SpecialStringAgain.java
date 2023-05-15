package hackerrank;

import java.util.ArrayList;

public class SpecialStringAgain {

    //Online Solution - I dont like this solution :(
    //https://www.youtube.com/watch?v=SJ_C9mclZJo&t=246s&ab_channel=AnandPandey
    public static long onlineSubstrCount(int n, String s) {
        long ans = s.length();
        for (int i = 0; i < s.length(); i++) {
            int repeat = 0;
            while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                repeat++;
                i++;
            }
            ans += repeat*(repeat+1)/2;
            int pointer = 1;
            while ( i  - pointer >= 0 && i+pointer < s.length() && s.charAt(i+pointer) == s.charAt(i-1)
            && s.charAt(i-pointer) == s.charAt(i-1)) {
                ans++;
                pointer++;
            }

        }

        return ans;
    }

    //Inefficient Solution (BAD):
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


    //Efficient Solution (GOOD)
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

//        long otherResult = onlineSubstrCount(s.length(), s);

        System.out.println(result);
//        System.out.println(otherResult);
    }
}
