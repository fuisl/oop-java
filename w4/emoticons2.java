
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
// import java.util.ArrayList;

public class emoticons2 {

    // final ArrayList<String> emoticons = new ArrayList<String>();
    static String[] emoticons = ":) :-) :-( ;-) xD ^_^ -_- ^o^ ^^; (..)".split(" ");
    static char[] all_symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String msg = reader.readLine();

        int max_count = 0;
        int min_count = 101;

        HashSet<Character> msg_set = new HashSet<>();

        for (char symbol : msg.toCharArray()) {
            msg_set.add(symbol);
        }

        for (char symbol : all_symbols) {
            for (char c : msg_set) {
                String temp = msg.replace(c, symbol);
                max_count = Math.max(max_count, check_emoticons(temp));
                min_count = Math.min(min_count, check_emoticons(temp));
            }
        }

        System.out.println(min_count + " " + max_count);
    }

    public static int check_emoticons(String msg) {
        int count = 0;
        int i = 0;

        while (i < msg.length()) {
            for (String emoticon : emoticons) {
                int end = Math.min(i + emoticon.length(), msg.length());
                if (msg.substring(i, end).equals(emoticon)) {
                    i += emoticon.length() - 1;
                    break;
                }
            }
            count++;
            i++;
        }

        return count;
    }
}
