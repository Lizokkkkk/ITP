import java.util.regex.*;

public class IPChecker {
    public static void main(String[] args) {
        String IP = "255.123.000.8";

        try {
            isIP(IP);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void isIP(String IP) throws Exception {
        Pattern pattern1 = Pattern.compile("\\b\\d+\\.\\d+\\.\\d+\\.\\d+\\b");
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher1 = pattern1.matcher(IP);
        Matcher matcher2 = pattern2.matcher(IP);
        if (!matcher1.find()) {
            throw new Exception("IP-адрес не удовлетворяет условиям");
        }

        while (matcher2.find()){
            if (Integer.parseInt(matcher2.group()) < 0 || Integer.parseInt(matcher2.group()) > 255) {
                throw new Exception(" числа IP-адреса должны быть в диапазоне от 0 до 255");
            }
        }
        System.out.println(IP + " - IP-адрес корректный");
    }
}
