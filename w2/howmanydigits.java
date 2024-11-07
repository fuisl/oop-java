
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class howmanydigits {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        double[] log10 = new double[1000001];
        log10[0] = 0;
        for (int i = 1; i <= 1000000; i++) {
            log10[i] = log10[i - 1] + Math.log10(i);
        }

        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == 0) {
                System.out.println(1);
                continue;
            }
            if (n == 1) {
                System.out.println(1);
                continue;
            }

            System.out.println((int)Math.ceil(log10[n]));  // cast to int
        }
    }
}
