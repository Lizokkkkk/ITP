import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of 2 the3 product is $19.99";

        try {
            notNumber(text);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void notNumber(String text) throws Exception {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        int k = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            k++;
        }
        if (k == 0) {
            throw new Exception("В строке нет цифр");
        }
    }
}

