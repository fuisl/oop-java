import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class imageprocessing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        
        int N = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);
        
        // read the img
        int[][] image = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                image[i][j] = Integer.parseInt(row[j]);
            }
        }

        // read the kernel
        int[][] kernel = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                kernel[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] result = new int[H - N + 1][W - M + 1];
        // convolution
        for (int i = 0; i < H - N + 1; i++) {
            for (int j = 0; j < W - M + 1; j++) {
                // flip the kernel
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < M; l++) {
                        result[i][j] += image[i + k][j + l] * kernel[N - k - 1][M - l - 1];
                    }
                }
            }
        }

        // print the result
        for (int i = 0; i < H - N + 1; i++) {
            for (int j = 0; j < W - M + 1; j++) {
                System.out.print(result[i][j]);
                if (j != W - M) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
