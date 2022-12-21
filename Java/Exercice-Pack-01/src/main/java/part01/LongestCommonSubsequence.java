package part01;

/*
TODO Leetcode exercise: 1143. Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        String text3 = "abc", text4 = "abc";
        String text5 = "abc", text6 = "def";

        int result1 = longestCommonSubsequence(text1, text2);
        System.out.println(result1);

        int result2 = longestCommonSubsequence(text3, text4);
        System.out.println(result2);

        int result3 = longestCommonSubsequence(text5, text6);
        System.out.println(result3);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
    /*
        This solution uses dynamic programming to solve the problem.
        The idea is to create a 2D array dp where dp[i][j] represents
        the length of the longest common subsequence between the first
        i characters of text1 and the first j characters of text2.

        We fill this array in a bottom-up manner, starting from the base
        cases where i or j is equal to 0. Then, for each pair of indices
        i and j, we have two possibilities:

        If the i-th character of text1 and the j-th character of text2 are equal,
        then we can add this character to the longest common subsequence, and the
        length of the longest common subsequence between the first i characters of
        text1 and the first j characters of text2 is equal to dp[i - 1][j - 1] + 1.

        If the i-th character of text1 and the j-th character of text2 are not equal,
        then we can't add this character to the longest common subsequence. In this case,
        the length of the longest common subsequence between the first i characters of
        text1 and the first j characters of text2 is equal to the maximum of
        dp[i - 1][j] and dp[i][j - 1].

        After filling the entire dp array, the length of the longest common subsequence
        is stored in dp[n][m], where n and m are the lengths of text1 and text2, respectively.

        I hope this helps! Let me know if you have any questions.
    */
}
