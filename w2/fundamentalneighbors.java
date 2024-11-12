
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fundamentalneighbors {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            System.out.printf("%s %d\n", currentLine, solve(Integer.parseInt(currentLine)));
        }
    }

    public static long solve(int n) {
        long res = 1;

        for (int i = 3; i * i <= n; i += 2) {
            int k = 0;
            while (n % i == 0) {
                n /= i;
                ++k;
            }
            if (k > 0) {
                res *= Math.pow(k, i);
            }
        }

        return res;
    }
}
