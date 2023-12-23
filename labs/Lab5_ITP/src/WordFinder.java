import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Asperiores cupiditate recusandae quia rem " +
                "sed voluptatum porro. Quia occaecati ut in sequi quidem ea. " +
                "Amet nesciunt enim quia et repellat amet a dolore totam. Ipsa corrupti nesciunt " +
                "eum magni tempora. Numquam commodi laborum itaque velit.";
        char a = 'q';

        try {
            checkPass(text, a);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void checkPass(String text, char a) throws Exception {
        String regex = "\\b" + a + "([a-z]+)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toLowerCase());
        int k = 0;

        while (matcher.find()) {
            System.out.println(matcher.group());
            k++;
        }

        if (k == 0) {
            throw new Exception("В строке нет слов, которые начинаются с данной буквы");
        }
    }
}
