
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class welcomesign {

    static String multiplyStr(int n) {
        String ret = "";
        for (int i = 0; i < n; i++) {
            ret += ".";
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int r = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);

        StringBuilder str = new StringBuilder();
        int side = 0;

        for (int i = 0; i < r; i++) {
            String s = reader.readLine();
            if (s.length() == c) {
                str.append(s).append("\n");
                continue;
            }
            int dif = c - s.length();
            String ret = "";
            String dot = multiplyStr(dif / 2);
            ret = ret + dot + s + dot;
            if (dif % 2 == 0) {
                str.append(ret).append("\n");
                continue;
            }
            if (side % 2 == 1) {
                ret = "." + ret;
                side = 0;
            } else {
                ret = ret + ".";
                side = 1;
            }
            str.append(ret).append("\n");
        }
        System.out.println(str.toString());
    }
}
