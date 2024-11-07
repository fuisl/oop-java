import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class offworldrecords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        int count = 0;

        for (int i = 0; i < n; i++) {
            int newRecord = Integer.parseInt(reader.readLine());
            if (newRecord > (c + p)) {
                count++;
                p = c;
                c = newRecord;
            }
        }

        System.out.println(count);
    }
}
