
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class batmanacci {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        BigInteger k = new BigInteger(input[1]);

        // hashmap to store Fibonacci numbers
        HashMap<Integer, BigInteger> fibMap = new HashMap<>();
        fibMap.put(0, BigInteger.ONE);
        fibMap.put(1, BigInteger.ONE);

        // find the character at position k
        char result = findChar(n - 1, k, fibMap);
        System.out.println(result);
    }

    private static char findChar(int n, BigInteger k, HashMap<Integer, BigInteger> fibMap) {
        if (n == 0) {
            return 'N';
        }
        if (n == 1) {
            return 'A';
        }

        BigInteger lenN2 = getFib(n - 2, fibMap);

        if (k.compareTo(lenN2) <= 0) {
            return findChar(n - 2, k, fibMap);
        } else {
            return findChar(n - 1, k.subtract(lenN2), fibMap);
        }
    }

    private static BigInteger getFib(int n, HashMap<Integer, BigInteger> fibMap) {
        if (fibMap.containsKey(n)) {
            return fibMap.get(n);
        } else {
            BigInteger fibN = getFib(n - 1, fibMap).add(getFib(n - 2, fibMap));
            fibMap.put(n, fibN);
            return fibN;
        }
    }
}
