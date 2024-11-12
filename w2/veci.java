
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class veci {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int num = Integer.parseInt(s);
        int ans = 0;
        for (int i = num + 1; i <= 999999; i++) {
            char[] temp = Integer.toString(i).toCharArray();
            Arrays.sort(temp);
            if (Arrays.equals(arr, temp)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
