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

        int edges = deg / 2;
        if (edges != n - 1) {
            System.out.println("NO");
            return;
        }

        boolean[] visited = new boolean[n];
        if (dfs(0, nodes, visited) && allVisited(visited)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean dfs(int node, int[] nodes, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] > 0 && !visited[i]) {
                nodes[i]--;
                if (!dfs(i, nodes, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}