
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class primereduction {

    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == 4) {
                break;
            }

            int steps = 1;
            cache.put(2, -1);  // 2 is prime
            while (true) {
                if (cache.containsKey(n)) {
                    if (cache.get(n) == -1) { // -1 -> n is already prime
                        break;
                    }
                    n = cache.get(n);
                    steps++;
                    continue;
                }

                // sum of prime factors of n
                int original = n;
                int sum = 0;
                while (n % 2 == 0) {
                    sum += 2;
                    n /= 2;
                }
                for (int i = 3; i * i <= n; i += 2) {
                    while (n % i == 0) {
                        sum += i;
                        n /= i;
                    }
                }
                if (n > 1) {
                    sum += n;
                }

                // cache and update n
                if (sum == original) {
                    cache.put(original, -1); // mark as prime
                    break;
                }
                cache.put(original, sum);
                n = sum;
                steps++;
            }
            System.out.printf("%d %d\n", n, steps);
        }
    }
}
