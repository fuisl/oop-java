
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class astackofgold {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        long w = Long.parseLong(inputs[0]);
        long s = Long.parseLong(inputs[1]);

        long c = (s * (s+1)) / 2;
        long dif = w - c * 29260;
        System.out.println(dif / 110); 
    }
}
