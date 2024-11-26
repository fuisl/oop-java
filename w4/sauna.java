
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sauna {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long big, small;
        String[] inputs = reader.readLine().split(" ");
        small = Long.parseLong(inputs[0]);
        big = Long.parseLong(inputs[1]);

        for (int i = 1; i < n; i++) {
            inputs = reader.readLine().split(" ");
            small = Math.max(Long.parseLong(inputs[0]), small);
            big = Math.min(Long.parseLong(inputs[1]), big);
            if (small > big){
                System.out.println("bad news");
                return;
            }
        }
        System.out.printf("%d %d", big-small+1, small);
    }
}
