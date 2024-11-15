import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class perfectpowers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while (!(currentLine = reader.readLine()).equals("0")) {
            int n = Integer.parseInt(currentLine);
            System.out.println(findHighestPerfectPower(n));
        }
    }

    public static int findHighestPerfectPower(int x) {
        int p = 1;
        int best = 1;

        do {
            double root = Math.pow(x, 1.0 / p);
            if (Math.abs(root - Math.round(root)) < 1e-20) {
                best = p;
            }
            p++;
        } while (Math.pow(x, 1.0 / p) >= 2);
        return best;
    }
}
