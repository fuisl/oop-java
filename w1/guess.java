import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class guess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int low = 1;
        int high = 1000;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            String input = reader.readLine();
            
            switch (input) {
                case "correct":
                    return;
                case "lower":
                    high = mid - 1;
                    break;
                case "higher":
                    low = mid + 1;
                    break;
            }
        }
    }
}
