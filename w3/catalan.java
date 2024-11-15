
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class catalan {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        BigInteger[] catalan = new BigInteger[5001];
        computeCatalan(catalan, 5000);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            System.out.println(catalan[num].toString());
        }
    }

    public static void computeCatalan(BigInteger[] catalan, int n) {
        catalan[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            catalan[i] = catalan[i - 1].multiply(BigInteger.valueOf(2 * (2 * i - 1))).divide(BigInteger.valueOf(i + 1));
        }
    }
}
