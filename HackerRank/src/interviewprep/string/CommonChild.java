package interviewprep.string;

public class CommonChild {


    public static int commonChild(String s1, String s2) {
        // Write your code here

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }



    public static void main(String[] args) {

        String s1 = "HARRY";
        String s2 = "SALLY";



        int res = commonChild(s1, s2);
        System.out.println(res);
    }
}
