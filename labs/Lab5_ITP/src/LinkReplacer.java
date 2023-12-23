import java.util.regex.*;

public class LinkReplacer {
    public static void main(String[] args) {
        String text = "Visit our website at www.example.com. For more info, check out example.org or ftp://file-server.ru.";

        try {
            findLink(text);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void findLink(String text) {
        Pattern pattern = Pattern.compile("\\b(?:https?|ftp)://\\S+\\b|\\bwww\\.\\S+\\b|\\b\\S+\\.\\S+\\b");
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String res = matcher.group();
            if (!matcher.group().startsWith("http://") && !matcher.group().startsWith("https://")
                    && !matcher.group().startsWith("ftp://")) {
                res = "http://" + matcher.group();
            }
            matcher.appendReplacement(result, res);
        }
        matcher.appendTail(result);
        System.out.println(result.toString());
    }
}
