import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "05062004Liza";

        try {
            checkPass(password);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void checkPass(String pass) throws Exception {
        Pattern pattern = Pattern.compile("\\b(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,16}\\b");
        Matcher matcher = pattern.matcher(pass);
        if (!matcher.find()) {
            throw new Exception("Пароль не удовлетворяет условиям");
        }
        System.out.println(pass + " - пароль корректый");
    }
}

