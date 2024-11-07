import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yoda {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        String num2 = reader.readLine();

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();

        int len1 = num1.length();
        int len2 = num2.length();

        int i = 0;
        int j = 0;

        // 6_7_3 -> 673
        // _9_5_ -> 95

        while (i < len1 && j < len2) {
            if (num1.charAt(i) == num2.charAt(j)) {
                res1.append(num1.charAt(i));
                res2.append(num2.charAt(j));
            } else if (num1.charAt(i) > num2.charAt(j)) {
                res1.append(num1.charAt(i));
            } else {
                res2.append(num2.charAt(j));
            }
            i++;
            j++;
        }

        while (i < len1) {
            res1.append(num1.charAt(i));
            i++;
        }

        while (j < len2) {
            res2.append(num2.charAt(j));
            j++;
        }

        if (res1.length() == 0) {
            System.out.println("YODA");
        } else {
            System.out.println(Integer.parseInt(res1.reverse().toString()));
        }

        if (res2.length() == 0) {
            System.out.println("YODA");
        } else {
            System.out.println(Integer.parseInt(res2.reverse().toString()));
        }
    }
}
