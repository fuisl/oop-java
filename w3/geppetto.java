
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class geppetto {

    private static boolean condition[][];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        condition = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            condition[x][y] = true;
            condition[y][x] = true;
        }

        System.out.println(count(n, new HashSet<>()));
    }

    public static int count(int n, HashSet<Integer> set) {
        if (n == 0) {
            return 1;
        }
        int c;
        c = count(n - 1, set);
        boolean flag = true;

        for (int i : set) {
            if (condition[i][n]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            set.add(n);
            c += count(n - 1, set);
            set.remove(n);
        }

        return c;
    }
}
