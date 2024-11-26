
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class airfaregrants {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(reader.readLine());
            max = Math.max(max, input);
            min = Math.min(min, input);
        }

        System.out.println(Math.max(0, min - max / 2));
    }
}
