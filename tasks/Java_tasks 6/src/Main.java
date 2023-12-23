import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] str1 = {"My world evolves in a beautiful space called Tesh.", "sworn love lived"};
        System.out.println(hiddenAnagram(str1));
        String[] str2 = {"An old west action hero actor", "Clint Eastwood"};
        System.out.println(hiddenAnagram(str2));
        String[] str3 = {"Mr. Mojo Rising could be a song title", "Jim Morrison"};
        System.out.println(hiddenAnagram(str3));
        String[] str4 = {"Banana? margaritas", "ANAGRAM"};
        System.out.println(hiddenAnagram(str4));
        String[] str5 = {"D  e b90it->?$ (c)a r...d,,#~", "bad credit"};
        System.out.println(hiddenAnagram(str5));
        String[] str6 = {"Bright is the moon", "Bongo mirth"};
        System.out.println(hiddenAnagram(str6));

        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        int[] arr1 = {1, 2, 3, 9, 4, 5, 15};
        System.out.println(twoProduct(arr1, 45));
        int[] arr2 = {1, 2, 3, 9, 4, 15, 3, 5};
        System.out.println(twoProduct(arr2, 45));
        int[] arr3 = {1, 2, -1, 4, 5, 6, 10, 7};
        System.out.println(twoProduct(arr3, 20));
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(twoProduct(arr4, 10));
        int[] arr5 = {100, 12, 4, 1, 2};
        System.out.println(twoProduct(arr5, 15));

        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSEGFFVVVGBH"));

        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    public static String hiddenAnagram(String[] str) {
        str[0] = str[0].toLowerCase().replaceAll("[^a-zа-я]", "");
        str[1] = str[1].toLowerCase().replaceAll("[^a-zа-я]", "");
        String x = str[0];
        String y = str[1];

        String res = "";

        for (int i = 0; i < x.length(); i++) {
            for (int j = i; j < x.length(); j++) {
                if (res.length() == str[1].length()) {
                    return res;
                }
                if (y.indexOf(x.charAt(j)) != -1) {
                    res += x.charAt(j);
                    y = y.substring(0, y.indexOf(x.charAt(j))) + y.substring(y.indexOf(x.charAt(j)) + 1);
                } else {
                    res = "";
                    y = str[1].toLowerCase();
                    break;
                }
            }
        }
        if (res.length() < str[1].length()) {
            res = "notfound";
        }
        return res;
    }

    public static ArrayList<String> collect(String str, int n) {
        ArrayList<String> words = new ArrayList<String>();
        recursionCollect(str, n, words);
        return words;
    }

    private static void recursionCollect(String str, int n, ArrayList<String> words) {
        if (str.length() >= n) {
            words.add(str.substring(0, n));
            Collections.sort(words);
            recursionCollect(str.substring(n), n, words);
        }
    }

    public static String nicoCipher(String message, String key) {
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        String res = "";

        int[] num = new int[key.length()];
        for (int i = 0; i < chars.length; i++) {
            num[i] = key.indexOf(chars[i]);
            key = key.substring(0, key.indexOf(chars[i])) + " " + key.substring(key.indexOf(chars[i]) + 1);
        }

        int k = (int) Math.ceil((double) message.length() / key.length()); // Получаем количество строк в таблице

        char[][] table = new char[k][key.length()];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.length() * i + j < message.length()) {
                    table[i][j] = message.charAt(key.length() * i + j);
                } else {
                    table[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < num.length; j++) {
                if (table[i][num[j]] == 0) {
                    res += " ";
                } else {
                    res += table[i][num[j]];
                }

            }
        }
        return res;
    }

    public static ArrayList<Integer> twoProduct(int[] nums, int x) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] * nums[j] == x) {
                    res.add(nums[j]);
                    res.add(nums[i]);
                    return res;
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> isExact(int x) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = 1;
        int max = 0;
        recursionExact(x, n, max, res);
        return res;
    }

    private static void recursionExact(int x, int n, int max, ArrayList<Integer> res) {
        if (n <= x) {
            max++;
            if (n == x) {
                res.add(x);
                res.add(max);
            } else {
                n = n * (max + 1);
                recursionExact(x, n, max, res);
            }
        }
    }

    public static String fractions(String num) {
        int whole = Integer.parseInt(num.split("\\.")[0]);
        String fractional = num.split("\\.")[1];

        int bracket = fractional.indexOf("(");

        fractional = fractional.replaceAll("[()]", "");

        int denominator = (int) (Math.pow(10, fractional.length()) - Math.pow(10, bracket));
        int numertor = Integer.parseInt(fractional) + whole * denominator;
        if (bracket > 0) {
            numertor -= Integer.parseInt(fractional.substring(0, bracket));
        }

        for (int i = Math.min(numertor, denominator); i >= 2; i--) {
            if (numertor % i == 0 && denominator % i == 0) {
                numertor = numertor / i;
                denominator = denominator / i;
            }
        }

        String res = numertor + "/" + denominator;

        return res;
    }

    public static String pilish_string(String str) {
        String res = "";
        String pi = "314159265358979";

        for (int i = 0; i < pi.length(); i++) {
            if (str.length() >= Character.getNumericValue(pi.charAt(i))) {
                res += str.substring(0, Character.getNumericValue(pi.charAt(i))) + " ";
                str = str.substring(Character.getNumericValue(pi.charAt(i)));
            } else if (str.length() < Character.getNumericValue(pi.charAt(i)) && str.length() > 0) {
                res += str;
                for (int j = str.length(); j < Character.getNumericValue(pi.charAt(i)); j++) {
                    res += str.charAt(str.length() - 1);
                }
                str = "";
            }
        }
        if (res.length() == 0) {
            res =  "\"\"";
        }
        if (res.charAt(res.length() - 1) == ' ') {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    public static String generateNonconsecutive(String expression) {
        String res;
        try {
            res = Integer.toString(Integer.parseInt(calculation(expression)));
        } catch (Exception e) {
            res = "Error: " + e;
        }
        return res;
    }

    private static String calculation(String str1) {

        Pattern pattern1 = Pattern.compile("-?\\d+\\s\\*\\s-?\\d+");
        Matcher matcher1 = pattern1.matcher(str1);

        Pattern pattern2 = Pattern.compile("-?\\d+\\s/\\s-?\\d+");
        Matcher matcher2 = pattern2.matcher(str1);

        Pattern pattern3 = Pattern.compile("-?\\d+\\s-\\s-?\\d+");
        Matcher matcher3 = pattern3.matcher(str1);

        Pattern pattern4 = Pattern.compile("-?\\d+\\s\\+\\s-?\\d+");
        Matcher matcher4 = pattern4.matcher(str1);

        Pattern patternD = Pattern.compile("-?\\d+");

        Pattern patternBracket = Pattern.compile("\\([0-9*/+\\-\\s]+\\)");
        Matcher matcherBracket = patternBracket.matcher(str1);

        if (matcherBracket.find()) {
            String bracket = matcherBracket.group().replaceAll("[()]", "");
            str1 = str1.replaceFirst(String.valueOf(patternBracket), calculation(bracket));
            calculation(str1);
        } else if (matcher1.find()) {
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher1.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()) {
                x *= Integer.parseInt(matcherD.group());
            }
            str1 = str1.replaceFirst(String.valueOf(pattern1), Integer.toString(x));
            calculation(str1);
        } else if (matcher2.find()) {
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher2.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()){
                try {
                    x /= Integer.parseInt(matcherD.group());
                } catch (Exception e) {
                    str1 = "Error: " + e;
                }
            }
            str1 = str1.replaceFirst(String.valueOf(pattern2), Integer.toString(x));
            calculation(str1);
        } else if (matcher3.find()) {
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher3.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()){
                x -= Integer.parseInt(matcherD.group());
            }
            str1 = str1.replaceFirst(String.valueOf(pattern3), Integer.toString(x));
            calculation(str1);
        } else if (matcher4.find()) {
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher4.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()){
                x += Integer.parseInt(matcherD.group());
            }
            str1 = str1.replaceFirst(String.valueOf(pattern4), Integer.toString(x));
            calculation(str1);
        } else {
            return str1;
        }
        return calculation(str1);
    }

    public static String isValid(String a) {
        ArrayList<Integer> num = new ArrayList<Integer>();

        recursionIsValid(a, num);

        Collections.sort(num);

        int k = 1;
        int maxK = 0;
        int x = 0;

        for (int i = 0; i < num.size() - 1; i++) {
            if (num.get(i) == num.get(i + 1)) {
                k += 1;
                if (k > maxK) {
                    maxK = k;
                    x = num.get(i);
                }
            } else {
                k = 1;
            }
        }

        int n1 = 0;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i) != x && num.get(i) != 1 && num.get(i) != x + 1) {
                return "NO";
            } else if (num.get(i) != x && num.get(i) == 1) {
                n1 += 1;
            } else if (num.get(i) == x + 1) {
                n1 += 1;
            }
        }

        if (n1 > 1) {
            return "NO";
        }
        return "YES";
    }

    private static void recursionIsValid(String a, ArrayList<Integer> num) {
        if (a.length() != 0) {
            int k = 1;
            for (int i = 1; i < a.length(); i++) {
                if (a.charAt(i) == a.charAt(0)) {
                    k++;
                }
            }
            num.add(k);
            a = a.replaceAll(String.valueOf(a.charAt(0)), "");
            recursionIsValid(a, num);
        }
    }


    public static String findLCS(String str1, String str2) {
        String res = "";

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    String str = "";
                    String[] maxStr = new String[1];
                    str += str1.charAt(i);
                    recursionFindLCS(i + 1, j + 1, str1, str2, str, maxStr);
                    if (maxStr[0].length() > res.length()) {
                        res = maxStr[0];
                    }
                }
            }
        }
        return res;
    }

    private static void recursionFindLCS(int x, int y, String str1, String str2, String str, String[] maxStr) {
        if (x < str1.length() && y < str2.length()) {
            for (int i = x; i < str1.length(); i++) {
                for (int j = y; j < str2.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        str = str + str1.charAt(i);
                        recursionFindLCS(i + 1, j + 1, str1, str2, str, maxStr);
                        break;
                    }
                }
            }
        } else {
            maxStr[0] = str;
        }
    }
}