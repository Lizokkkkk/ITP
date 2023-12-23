import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        int[] a = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(a));
        int[] b = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(b));

        int[] c = {1, 2, 3, 4, 5};
        System.out.println(equalToAvg(c));
        int[] d = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(d));

        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(indexMult(arr)));
        int[] num = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(num)));

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox"));

        System.out.println(tribonacci(7));
        System.out.println(tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        String[] str = {"listen", "silent"};
        System.out.println(isAnagram(str));
        str = new String[]{"eleven plus two", "twelve plus one"};
        System.out.println(isAnagram(str));
        str = new String[]{"hello", "world"};
        System.out.println(isAnagram(str));
        }

    public static boolean duplicateChars(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < (str.length() - 1); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String str) {
        String[] strings = str.split(" ");
        return strings[0].charAt(0) + "" + strings[1].charAt(0);
    }

    public static int differenceEvenOdd(int[] num) {
        int even = 0;
        int odd = 0;
        for (int i : num) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        return Math.abs(even - odd);
    }

    public static boolean equalToAvg(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        double avg = (double) sum / num.length;
        for (int i : num) {
            if (i == avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] num){
        for (int i = 0; i < num.length; i++) {
            num[i] = num[i] * i;
        }
        return num;
    }

    public static String reverse(String str) {
        String reverseStr = "";
        for (int i = (str.length() - 1); i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    public static int tribonacci(int num) {
        int[] arr = new int[num];
        arr[2] = 1;
        for (int i = 3; i < num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[num - 1];
    }

    public static String pseudoHash(int num) {
        String hash = "";
        Random random = new Random();
        String a = "abcdef0123456789";
        for (int i = 0; i < num; i++) {
            int randomNum = random.nextInt(a.length());
            hash += a.charAt(randomNum);
        }
        return hash;
    }

    public static String botHelper(String str) {
        str = str.toLowerCase();
        if (!str.contains("help ")) {
            return "Keep waiting";
        } else {
            return "Calling for a staff member";
        }
    }

    public static boolean isAnagram(String[] words) {
        String word1 = words[0].replaceAll("\\s", "");
        String word2 = words[1].replaceAll("\\s", "");

        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (word2.indexOf(word1.charAt(i)) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}