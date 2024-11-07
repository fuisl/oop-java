import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class divvyingup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            sum += num;
        }

        if (sum % 3 == 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
