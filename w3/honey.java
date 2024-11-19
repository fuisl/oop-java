
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class honey {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] walks = new long[15];
        Arrays.fill(walks, -1);
        walks[0] = 1;
        walks[1] = 0;
        walks[2] = 6;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            System.out.println(walk(num, walks));
        }
    }

    private static long walk(int n, long[] walks) {
        if (n < 0) {
            return 0;
        }
        if (n < walks.length && walks[n] >= 0) {
            return walks[n];
        }
        long walkN3 = walk(n - 3, walks);
        long walkN2 = walk(n - 2, walks);
        long walkN1 = walk(n - 1, walks);

        long result = (walkN1 * n + 24 * walkN2 * n + 36 * walkN3 * n - 24 * walkN2 - 72 * walkN3) * (n - 1) / (n * n);

        if (n < walks.length) {
            walks[n] = result;
        }

        return result;
    }
}
