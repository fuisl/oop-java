
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class meowfactor2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String meow = "meow";
        if (s.length() < 4) {
            System.out.println(levenshteinDistanceWithSwap(s, meow));
            return;
        }

        int min = 4;
        for (int i = 0; i < s.length() - 3; i++) {
            int dist = levenshteinDistanceWithSwap(s.substring(i, i + 4), meow);
            if (dist < min) {
                min = dist;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            String newString = s.substring(0, i) + meow + s.substring(i);
            int dist = levenshteinDistanceWithSwap(s, newString);
            if (dist < min) {
                min = dist;
            }
        }

        System.out.println(min);

    }

    public static int levenshteinDistanceWithSwap(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    if (i > 1 && j > 1 && s1.charAt(i - 1) == s2.charAt(j - 2) && s1.charAt(i - 2) == s2.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 2] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
