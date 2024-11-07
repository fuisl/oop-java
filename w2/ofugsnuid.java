
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ofugsnuid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = reader.readLine();
        }

        for (int i = n - 1; i > -1; i--){
            System.out.println(arr[i]);
        }
    }    
}
