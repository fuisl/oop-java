import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int DIM = 315;
        int LIMIT = DIM * DIM;
        boolean[] prime = generatePrimes(LIMIT);

        int[][] spiralGrid = new int[DIM][DIM];
        int[] rowLocations = new int[LIMIT + 1];
        int[] colLocations = new int[LIMIT + 1];
        buildSpiral(spiralGrid, rowLocations, colLocations, DIM);

        String line;
        int caseNumber = 1;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] tokens = line.split("\\s+");
            if (tokens.length != 2) continue;

            int begin = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);

            if (begin < 1 || begin > LIMIT || end < 1 || end > LIMIT) {
                System.out.println("Case " + caseNumber + ": impossible");
                caseNumber++;
                continue;
            }

            int startRow = rowLocations[begin];
            int startCol = colLocations[begin];
            int endRow = rowLocations[end];
            int endCol = colLocations[end];

            int result = bfs(startRow, startCol, endRow, endCol, spiralGrid, prime, DIM);

            if (result != -1) {
                System.out.println("Case " + caseNumber + ": " + result);
            } else {
                System.out.println("Case " + caseNumber + ": impossible");
            }
            caseNumber++;
        }
    }

    public static boolean[] generatePrimes(int limit) {
        boolean[] prime = new boolean[limit + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static void buildSpiral(int[][] spiralGrid, int[] rowLocations, int[] colLocations, int DIM) {
        int r = DIM / 2;
        int c = DIM / 2;
        int number = 1;
        int step = 1;
        int dir = 0;
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // right, up, left, down

        spiralGrid[r][c] = number;
        rowLocations[number] = r;
        colLocations[number] = c;
        number++;

        while (number <= DIM * DIM) {
            for (int i = 0; i < 2; i++) {
                for (int s = 0; s < step; s++) {
                    r += directions[dir][0];
                    c += directions[dir][1];

                    if (r >= 0 && r < DIM && c >= 0 && c < DIM && number <= DIM * DIM) {
                        spiralGrid[r][c] = number;
                        rowLocations[number] = r;
                        colLocations[number] = c;
                        number++;
                    } else {
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
    }

    public static int bfs(int startRow, int startCol, int endRow, int endCol, int[][] spiralGrid, boolean[] prime, int DIM) {
        boolean[][] visited = new boolean[DIM][DIM];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            int cost = current[2];

            if (currRow == endRow && currCol == endCol) {
                return cost;
            }

            for (int[] move : moves) {
                int newRow = currRow + move[0];
                int newCol = currCol + move[1];

                if (newRow >= 0 && newRow < DIM && newCol >= 0 && newCol < DIM
                        && !visited[newRow][newCol] && !prime[spiralGrid[newRow][newCol]]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, cost + 1});
                }
            }
        }

        return -1;
    }
}
