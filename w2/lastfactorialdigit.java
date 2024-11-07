
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lastfactorialdigit {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        int[] last = {1, 1, 2, 6, 4, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(last[n]);
        }
    }
}
