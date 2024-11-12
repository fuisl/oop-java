
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class primereduction {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        // Generate small primes up to sqrt(1,000,000,000) for use in segmentation
        int limit = (int) Math.sqrt(1000000000);
        boolean[] smallPrimes = sieve(limit);
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (smallPrimes[i]) {
                primes.add(i);
            }
        }

        while (!(currentLine = reader.readLine()).equals("4")) {
            int n = Integer.parseInt(currentLine);
            int count = 1;
            primeReduction(n, primes, count);
        }
    }

    public static void primeReduction(int n, List<Integer> primes, int count) {
        if (isPrime(n, primes)) {  // Check if n is prime within segment
            System.out.printf("%d %d\n", n, count);
            return;
        }

        int currentPrime = 2;
        int sum = 0;
        while (n > 1) {
            if (isPrime(currentPrime, primes) && n % currentPrime == 0) {
                sum += currentPrime;
                n /= currentPrime;
            } else {
                currentPrime++;
            }
        }
        primeReduction(sum, primes, count + 1);
    }

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static boolean isPrime(int n, List<Integer> smallPrimes) {
        if (n < 2) {
            return false;
        }
        for (int prime : smallPrimes) {
            if (prime * prime > n) {
                break;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
