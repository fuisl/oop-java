
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class goldbach2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] isPrime = sieve(32000);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            solve(num, isPrime);
        }
    }

    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static void solve(int num, boolean[] isPrime) {
        int a = 2;
        int b = num - a;
        int count = 0;
        ArrayList<String> representation = new ArrayList<>();
        while (a <= b) {
            if (isPrime[a] && isPrime[b]) {
                representation.add(a + "+" + b);
                count++;
            }
            a++;
            b = num - a;
        }

        System.out.println(num + " has " + count + " representation(s)");
        for (String s : representation) {
            System.out.println(s);
        }
        System.out.println();
    }
}
