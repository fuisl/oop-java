import java.util.*;

public class EmoticonChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String msgStr = scanner.nextLine();
        Set<Character> msgSet = new HashSet<>();
        for (char c : msgStr.toCharArray()) {
            msgSet.add(c);
        }

        String[] emoticons = {":)", ":-)", ":-(", ";-)", "xD", "^_^", "-_-", "^o^", "^^;", "(..)"};
        Set<Character> emoSet = new HashSet<>();
        for (String emoticon : emoticons) {
            for (char c : emoticon.toCharArray()) {
                emoSet.add(c);
            }
        }

        int maxCount = 0;
        int minCount = 101;

        for (char emo : emoSet) {
            for (char charInMsg : msgSet) {
                String temp = msgStr.replace(charInMsg, emo);
                int count = checkEmoticons(temp, emoticons);
                minCount = Math.min(minCount, count);
                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(minCount + " " + maxCount);
    }

    public static int checkEmoticons(String msg, String[] emoticons) {
        String temp = msg;
        for (String emoticon : emoticons) {
            temp = temp.replace(emoticon, "@"); // Replace emoticons with @
        }
        return temp.length();
    }
}
