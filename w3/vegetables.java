
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vegetables {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        float requiredRatio = Float.parseFloat(input[0]);
        int n = Integer.parseInt(input[1]);

        if (n == 1) {
            System.out.println(0);
            return;
        }

        input = reader.readLine().split(" ");
        float[] weights = new float[n];
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Float.parseFloat(input[i]);
            cuts[i] = 1;
        }

        int totalCuts = 0;

        while (true) {
            float maxPiece = 0;
            float minPiece = Float.MAX_VALUE;
            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                float pieceWeight = weights[i] / cuts[i];
                if (pieceWeight > maxPiece) {
                    maxPiece = pieceWeight;
                    maxIndex = i;
                }
                if (pieceWeight < minPiece) {
                    minPiece = pieceWeight;
                }
            }

            if (minPiece / maxPiece >= requiredRatio) {
                break;
            }

            cuts[maxIndex]++;
            totalCuts++;
        }

        System.out.println(totalCuts);
    }
}
