
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nair {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while (!(currentLine = reader.readLine()).equals("0 0")) {
            String[] inputs = currentLine.split(" ");
            int n = Integer.parseInt(inputs[0]);
            double t = Double.parseDouble(inputs[1]);

            System.out.printf("%.3f%n", solve(n, t));
        }
    }

    public static double solve(int n, double t) {
        double dp[] = new double[n + 1];

        dp[n] = Math.pow(2, n);  // win all

        for (int i = n - 1; i >= 0; i--) {
            double cut = Math.pow(2, i) / dp[i + 1];  // cut probability
            double p = (cut + 1) / 2;
            if (t < cut) {
                dp[i] = (cut - t) / (1 - t) * Math.pow(2, i)
                        + (1 - cut) / (1 - t) * p * dp[i + 1];
            } else {
                dp[i] = (1 + t) / 2 * dp[i + 1];
            }
        }

        return dp[0];
    }
}
