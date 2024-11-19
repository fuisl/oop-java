
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class knitpicking {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> types = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            types.add(input[0]);
            map.put((input[0] + " " + input[1]), Integer.valueOf(input[2]) + map.getOrDefault((input[0] + " " + input[1]), 0));
        }

        int count = 0;
        boolean possible = false;

        for (String type : types) {
            int l = map.getOrDefault((type + " left"), 0);
            int r = map.getOrDefault((type + " right"), 0);
            int any = map.getOrDefault((type + " any"), 0);

            if (!((l == 0 | r == 0) & (any <= 1))) {
                possible = true;
            }
            count += Math.max(l, r);

            if ((l == 0 & r == 0) & (any > 1)) {
                count += 1;
            }
        }

        if (!possible) {
            System.out.println("impossible");
            return;
        }
        System.out.println(++count);
    }
}
