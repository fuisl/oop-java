
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class olderbrother {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n <= 1) {
            System.out.print("no");
            return;
        }

        if (isPrime(n)) {
            System.out.print("yes");
            return;
        }

        boolean[] isPrime = sieve((int) Math.sqrt(n) + 1);

        for (int k = 2; k <= Math.log(n) / Math.log(2); k++) {
            int p = (int) Math.round(Math.pow(n, 1.0 / k));

            if (p > 1 && isPrime[p] && Math.pow(p, k) == n) {
                System.out.print("yes");
                return;
            }
        }

        System.out.print("no");
    }

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
