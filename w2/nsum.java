
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nsum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(input[i]);
        }
        System.out.println(sum);
    }
}
