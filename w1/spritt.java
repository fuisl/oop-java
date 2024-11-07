
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spritt {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(reader.readLine());
            if (sum > x) {
                System.out.println("Neibb");
                return;
            }
        }

        System.out.println("Jebb");
    }
}
