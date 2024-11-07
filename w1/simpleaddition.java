import java.math.BigInteger;
import java.util.Scanner;

public class simpleaddition {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();

            System.out.println(a.add(b));
        }
    }
}