
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class almostperfect {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            long n = Long.parseLong(currentLine);
            long sum = 1;
            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    sum += i;
                    if (i != n / i) {
                        sum += n / i;
                    }
                }
            }
            if (sum == n) {
                System.out.println(n + " perfect");
            } else if (Math.abs(sum - n) <= 2) {
                System.out.println(n + " almost perfect");
            } else {
                System.out.println(n + " not perfect");
            }
        }
    }
}
