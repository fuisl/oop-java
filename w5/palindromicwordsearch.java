
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class palindromicwordsearch {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read number of rows (n) and columns (m)
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);  // number of rows
        int m = Integer.parseInt(input[1]);  // number of columns

        char[][] grid = new char[n][m];

        // Read the grid
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            grid[i] = line.toCharArray();
        }

        // Initialize row_max and col_max with 1s
        int[][] row_max = new int[n][m];
        int[][] col_max = new int[n][m];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(row_max[i], 1);
            java.util.Arrays.fill(col_max[i], 1);
        }

        // Process each row to find the longest palindromic substring
        for (int r = 0; r < n; r++) {
            int[] result = longest_palindrome(grid[r]);
            int s = result[0];
            int l = result[1];
            for (int i = s; i < s + l; i++) {
                row_max[r][i] = l;
            }
        }

        // Process each column to find the longest palindromic substring
        for (int c = 0; c < m; c++) {
            char[] column = new char[n];
            for (int r = 0; r < n; r++) {
                column[r] = grid[r][c];
            }
            int[] result = longest_palindrome(column);
            int s = result[0];
            int l = result[1];
            for (int i = s; i < s + l; i++) {
                col_max[i][c] = l;
            }
        }

        // // Print row_max
        // System.out.println("row_max:");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(row_max[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // // Print col_max
        // System.out.println("col_max:");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(col_max[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // Calculate the maximum product of palindromic lengths
        int maxProduct = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                maxProduct = Math.max(row_max[y][x] * col_max[y][x], maxProduct);
            }
        }

        // Output the result
        System.out.println(maxProduct);
    }

    // Function to find the longest palindromic substring in a character array using Manacher's algorithm
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
}
