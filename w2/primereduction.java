
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class primereduction {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while ((currentLine = reader.readLine()).equals("4") == false) {
            int n = Integer.parseInt(currentLine);
            int count = 1;
            primeReduction(n, count);
        }
    }

    public static void primeReduction(int n, int count) {
        boolean isPrime = true;
        int currentPrime = 2;
        int sum = 0;
        while (n != 1) {
            if (n == currentPrime && isPrime) {
                System.out.printf("%d %d\n", n, count);
                return;
            } else if (n % currentPrime == 0) {
                sum += currentPrime;
                n /= currentPrime;
                isPrime = false;
            } else {
                currentPrime++;
            }
        }

        primeReduction(sum, count + 1);

    }

    // public static boolean[] sieve(int n) {
    //     boolean[] isPrime = new boolean[n + 1];
    //     for (int i = 2; i <= n; i++) {
    //         isPrime[i] = true;
    //     }
    //     for (int i = 2; i * i <= n; i++) {
    //         if (isPrime[i]) {
    //             for (int j = i * i; j <= n; j += i) {
    //                 isPrime[j] = false;
    //             }
    //         }
    //     }
    //     return isPrime;
    // }
}
