
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ooohisee {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int w = Integer.parseInt(inputs[0]);
        int h = Integer.parseInt(inputs[1]);

        char[][] arr = new char[w][h];

        for (int i = 0; i < w; i++) {
            String s = reader.readLine();
            for (int j = 0; j < h; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        int x_pos = 0;
        int y_pos = 0;
        for (int i = 1; i < w - 1; i++) {
            for (int j = 1; j < h - 1; j++) {
                if (arr[i][j] == '0') {
                    boolean flag = true;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (k == 1 && l == 1) continue;
                            if (arr[i + k - 1][j + l - 1] != 'O') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                    if (flag) {
                        x_pos = i+1;
                        y_pos = j+1;
                        count++;
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("Oh no!");
        } else if (count == 1){
            System.out.println(x_pos + " " + y_pos);
        } else {
            System.out.printf("Oh no! %d locations\n", count);
        }
    }
}
