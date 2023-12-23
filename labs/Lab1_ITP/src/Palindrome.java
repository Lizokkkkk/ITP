public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println("Строка " + s + " является палиндромом");
            } else {
                System.out.println("Строка " + s + " не является палиндромом");
            }
        }
    }
    public static String reverseString(String s) {
        String reverseS = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseS += s.charAt(i);
        }
        return reverseS;
    }
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
