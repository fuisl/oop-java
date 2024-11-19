
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class heirsdilemma {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int count = 0;

        for (int i = L; i <= H; i++) {
            if (isValid(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isValid(int i) {
        int[] freq = new int[10];
        int num = i;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || freq[digit] > 0 || i % digit != 0) {
                return false;
            }
            freq[digit]++;
            num /= 10;
        }
        return true;
    }
}
