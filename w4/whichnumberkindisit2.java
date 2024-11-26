
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class whichnumberkindisit2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        boolean[] isSquare = new boolean[1000001];

        for (int i = 0; i <= 1000; i++) {
            isSquare[i * i] = true;
        }

        for (long i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            boolean flag = false;

            if (num % 2 == 1){
                flag = true;
                System.out.print('O');
            }

            if (isSquare[num]) {
                flag = true;
                System.out.print('S');
            }
            if (!flag){
                System.out.print("EMPTY");
            }
            System.out.println();
        }   
    }
}
