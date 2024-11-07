import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class midi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noteCount = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < noteCount; i++) {
            sb.append(reader.readLine());
        }

        System.out.println(sb.reverse().toString());
    }
}