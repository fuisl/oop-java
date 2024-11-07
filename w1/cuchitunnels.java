
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cuchitunnels {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        int[] nodes = new int[n];

        int deg = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = Integer.parseInt(arr[i]);
            deg += nodes[i];
        }

        // degree check
        int edges = deg / 2;
        if (edges != n - 1) {
            System.out.println("NO");
            return;
        }

        // traverse tree to check for increasing order
        boolean[] visited = new boolean[n];
        boolean isValid = dfs(0, -1, nodes, visited);

        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean dfs(int current, int parent, int[] nodes, boolean[] visited) {
        visited[current] = true;
        for (int i = 0; i < nodes.length; i++) {
            if (i != parent && nodes[current] > 0 && !visited[i]) {
                if (i < current || !dfs(i, current, nodes, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}
