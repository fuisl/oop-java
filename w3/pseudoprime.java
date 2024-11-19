
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pseudoprime {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while (!(currentLine = reader.readLine()).equals("0 0")) {
            String[] input = currentLine.split(" ");
            int p = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);

            if (p == 0 && a == 0) {
                break;
            }

            if (isPrime(p)) {
                System.out.println("no");
            } else {
                if (modPow(a, p, p) == a) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int modPow(int base, int exp, int mod) {
        if (mod == 1) {
            return 0;
        }

        long res = 1;
        long b = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * b) % mod;
            }
            exp = exp >> 1;
            b = (b * b) % mod;
        }

        return (int) res;
    }
}
