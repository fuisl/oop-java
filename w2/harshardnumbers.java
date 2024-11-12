
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class harshadnumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n > 0) {
            int sum = sumOfDigits(n);
            if (n % sum == 0) {
                System.out.println(n);
                break;
            }
            n++;
        }

    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
