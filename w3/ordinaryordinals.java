
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ordinaryordinals {

    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        if (numbers[0].equals("0")) {
            System.out.println(2 % Integer.parseInt(numbers[1]));  // base
            return;
        }
        if (numbers[0].equals("1")) {
            System.out.println(4 % Integer.parseInt(numbers[1]));  // base
            return;
        }

        BigInteger N = new BigInteger(numbers[0]);
        BigInteger M = new BigInteger(numbers[1]);

        BigInteger brackets = TWO.modPow(N.add(ONE), M);  // 2^(N+1) mod M
        BigInteger commas = TWO.modPow(N.subtract(ONE), M).subtract(ONE);  // 2^(N-1) - 1 mod M
        BigInteger result = brackets.add(commas).mod(M);  // (2^(N+1) + (N-1) + 2^(N-1)) mod M

        System.out.println(result);
    }
}
