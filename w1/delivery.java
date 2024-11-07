
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class delivery {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]), capacity = Integer.parseInt(input[1]);

        int remains = 0;
        int count = 0;
        int[] address = new int[n];
        int[] letters = new int[n];

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            address[i] = Integer.parseInt(input[0]);
            letters[i] = Integer.parseInt(input[1]);
        }

        int i = 0;
        while (i < n && address[i] < 0) {
            count += 2 * Math.ceilDiv((letters[i] - remains), capacity) * Math.abs(address[i]);
            remains = ((letters[i] - remains) % capacity) != 0 ? capacity - (letters[i] - remains) % capacity : 0;
            i++;
        }

        remains = 0;
        while (i < n && address[n - 1] > 0) {
            count += 2 * Math.ceilDiv((letters[n - 1] - remains), capacity) * address[n - 1];
            remains = ((letters[n - 1] - remains) % capacity) != 0 ? capacity - (letters[n - 1] - remains) % capacity : 0;
            n--;
        }

        System.out.println(count);
    }
}
