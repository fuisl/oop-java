
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        String you = reader.readLine();
        String friend = reader.readLine();

        int diff = 0;

        for (int i = 0; i < you.length(); i++) {
            if (you.charAt(i) != friend.charAt(i)) {
                diff++;
            }
        }

        int maxScore = Math.min(you.length() - diff, k) + Math.min(diff, you.length() - k);  // 1st part: same, 2nd part: diff

        System.out.println(maxScore);
    }
}
