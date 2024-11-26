import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class marchingorder {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String my_str = reader.readLine();

        ArrayList<Integer> rem = new ArrayList<>();
        ArrayList<Character> alphabet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            alphabet.add((char) ('A' + i));
        }

        for (char c : my_str.toCharArray()) {
            int index = alphabet.indexOf(c);
            rem.add(index);
            alphabet.remove(index);
        }

        // Reverse rem
        for (int i = 0, j = rem.size() - 1; i < j; i++, j--) {
            int temp = rem.get(i);
            rem.set(i, rem.get(j));
            rem.set(j, temp);
        }

        ArrayList<Integer> n_list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            n_list.add(i);
        }

        long[] result = crt(rem, n_list);

        if (result[0] == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(result[0]);
        }
    }

    public static long[] crt(ArrayList<Integer> a_list, ArrayList<Integer> n_list) {
        if (a_list.size() != n_list.size()) {
            throw new IllegalArgumentException("length not equal");
        }

        long m = a_list.get(0);
        long N = n_list.get(0);

        for (int i = 1; i < a_list.size(); i++) {
            long a_i = a_list.get(i);
            long n_i = n_list.get(i);

            if (N == 0 || n_i == 0) {
                throw new IllegalArgumentException("moduli must be greater than 0.");
            }

            long d = gcd(N, n_i);
            long c = a_i - m;
            if (c % d != 0) {
                return new long[]{-1, -1};
            }

            long k = c / d;
            long n1 = N / d;
            long n2 = n_i / d;

            long[] egcdResult = extended_gcd(n1, n2);
            long s = egcdResult[1];

            m = (m + N * s * k) % (N * n2);
            N = N * n2;

            if (m < 0) {
                m += N;
            }
        }

        return new long[]{m % N, N};
    }

    public static long[] extended_gcd(long a, long b) {
        if (a == 0) {
            return new long[]{b, 0, 1};
        } else {
            long[] result = extended_gcd(b % a, a);
            long g = result[0];
            long s = result[2] - (b / a) * result[1];
            long t = result[1];
            return new long[]{g, s, t};
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
