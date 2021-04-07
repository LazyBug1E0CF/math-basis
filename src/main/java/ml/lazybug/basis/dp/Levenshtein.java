package ml.lazybug.basis.dp;

/**
 * 动态规划计算给定两个字符串的最短编辑距离
 */
public class Levenshtein {
    public static int editDistance(String s1, String s2) {
        s1 = emptyIfNull(s1);
        s2 = emptyIfNull(s2);
        int s1Len = s1.length(), s2Len = s2.length();
        int[][] dp = new int[s1Len + 1][s2Len + 1];
        for (int i = 0; i < s1Len + 1; i++) {
            for (int j = 0; j < s2Len + 1; j++) {
                if (i > 0 && j > 0) {
                    int a = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + a);
                } else if (i == 0 && j > 0) {
                    dp[0][j] = dp[0][j - 1] + 1;
                } else if (i > 0 && j == 0) {
                    dp[i][0] = dp[i - 1][j] + 1;
                }
            }
        }
        return dp[s1Len][s2Len];
    }

    private static String emptyIfNull(String s) {
        return s == null ? "" : s;
    }
}
