// Method: https://en.wikipedia.org/wiki/Approximate_string_matching#Problem_formulation_and_algorithms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class meowfactor2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String meow = "meow";
        System.out.println(levenshteinDistanceWithSwap(meow, s));
    }

    public static int levenshteinDistanceWithSwap(String s1, String s2) {  // damerau-levenshtein distance
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = 0;  // first row
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], Math.min( // replace
                                    dp[i - 1][j], // insert
                                    dp[i][j - 1]));      // delete
                    if (i > 1 && j > 1 && s1.charAt(i - 1) == s2.charAt(j - 2) && s1.charAt(i - 2) == s2.charAt(j - 1)) {  // swap
                        dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 2] + 1);
                    }
                }
            }
        }

        int minDistance = 4;
        for (int j = 0; j <= n; j++) {
            minDistance = Math.min(minDistance, dp[m][j]);  // last row
        }

        return minDistance;
    }
}
