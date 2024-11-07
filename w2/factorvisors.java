
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorvisors {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] input = currentLine.split(" ");
            solve(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    public static void solve(int n, int m) {
        if (n == 1) {
            System.out.printf("%d divides %d\n", n, m);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (m % i == 0) {
                System.out.printf("%d divides %d\n", m, n);
                return;
            }
        }
        System.out.printf("%d does not divide %d\n", m, n);
    }
}
