
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class palindromicwordsearch2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] horizontal_input = new String[n];

        // read
        for (int i = 0; i < n; i++) {
            horizontal_input[i] = reader.readLine();
        }

        // convert to vertical
        String[] vertical_inputs = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(horizontal_input[j].toCharArray()[i]);
            }

            vertical_inputs[i] = builder.toString();
        }

        // for (int i = 0; i < m; i++) {
        //     System.out.println(vertical_inputs[i]);
        // }
        // int[] res = longest_palindrome(vertical_inputs[0].toCharArray());
        // System.out.printf("%d %d", res[0], res[1]);
        // init row max and col max to calculate
        int[][] row_max = new int[n][m];
        int[][] col_max = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(row_max[i], 1);
            Arrays.fill(col_max[i], 1);
        }

        for (int c = 0; c < n; c++) {
            int[] temp = longest_palindrome_dp(horizontal_input[c].toCharArray());
            int s = temp[0];
            int l = temp[1];
            for (int j = s; j < s + l; j++) {
                row_max[c][j] = l;
            }
        }

        for (int r = 0; r < m; r++) {
            int[] temp = longest_palindrome_dp(vertical_inputs[r].toCharArray());
            int s = temp[0];
            int l = temp[1];
            for (int j = s; j < s + l; j++) {
                col_max[j][r] = l;
            }
        }

        // print computed matrix
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.printf("%d ", row_max[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.printf("%d ", col_max[i][j]);
        //     }
        //     System.out.println();
        // }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, row_max[i][j] * col_max[i][j]);
            }
        }

        System.out.println(max);
    }

    public static int[] longest_palindrome(char[] s) {
        int n = s.length;
        if (n == 0) {
            return new int[]{0, 0};
        }

        // Transform the original string to avoid even/odd length issues
        char[] t = new char[2 * n + 1];
        for (int i = 0; i < n; i++) {
            t[2 * i] = '#';
            t[2 * i + 1] = s[i];
        }
        t[2 * n] = '#';

        int[] p = new int[t.length];
        int center = 0, right = 0;
        int maxLength = 0, start = 0;

        for (int i = 0; i < t.length; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around the center
            int a = i + (1 + p[i]);
            int b = i - (1 + p[i]);
            while (a < t.length && b >= 0 && t[a] == t[b]) {
                p[i]++;
                a++;
                b--;
            }

            // Update the center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Update the maximum length and start position
            if (p[i] > maxLength) {
                maxLength = p[i];
                start = (i - p[i]) / 2;
            }
        }

        return new int[]{start, maxLength};
    }

    public static int[] longest_palindrome_dp(char[] s) {
        int n = s.length;
        if (n == 0) {
            return new int[]{0, 0};
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return new int[]{start, maxLength};
    }
}
