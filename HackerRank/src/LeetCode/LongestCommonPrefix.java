package LeetCode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 1)
            return strs[0];

        int outIndex = 0;

        boolean keepChecking = true;

        while (keepChecking) {
            for (int i = 0; i < strs.length-1; i++) {
                String currentStr = strs[i];
                String nextStr = strs[i+1];

                if ((currentStr.length() > outIndex) && (nextStr.length() > outIndex) &&
                        (currentStr.charAt(outIndex) == nextStr.charAt(outIndex))) {
                    continue;
                } else {
                    keepChecking = false;
                    break;
                }
            }

            if (keepChecking)
                outIndex++;

        }



        return strs[0].substring(0, outIndex);



    }

    public static void main(String[] args) {
        String[] in = {"flower", "flight", "flake", ""};
        String res = longestCommonPrefix(in);
        System.out.println(res);
    }

}
