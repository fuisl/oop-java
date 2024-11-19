import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class natjecanje {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int R = Integer.parseInt(inputs[2]);

        int[] damaged = new int[N];
        int[] reserve = new int[N];

        inputs = reader.readLine().split(" ");
        for (int i = 0; i < S; i++) {
            damaged[Integer.parseInt(inputs[i]) - 1] = 1;
        }

        inputs = reader.readLine().split(" ");
        for (int i = 0; i < R; i++) {
            reserve[Integer.parseInt(inputs[i]) - 1] = 1;
        }

        for (int i = 0; i < N; i++) {  // damaged -> reserve
            if (damaged[i] == 1) {
                if (reserve[i] == 1) {
                    damaged[i] = 0;
                    reserve[i] = 0;
                } else if (i > 0 && reserve[i - 1] == 1) {
                    damaged[i] = 0;
                    reserve[i - 1] = 0;
                } else if (i < N - 1 && reserve[i + 1] == 1) {
                    damaged[i] = 0;
                    reserve[i + 1] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (damaged[i] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
