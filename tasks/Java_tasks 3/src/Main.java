import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        int[] a = {1, -3, 2};
        System.out.println(countRoots(a));
        int[] b = {2, 5, 2};
        System.out.println(countRoots(b));
        int[] c = {1, -6, 9};
        System.out.println(countRoots(c));

        String[][] list1 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(salesData(list1));
        String[][] list2 = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(salesData(list2));

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        int[] num1 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(num1));
        int[] num2 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(num2));
        int[] num3 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(num3));

        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));

        int[][] data1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        System.out.println(Arrays.deepToString(dataScience(data1)));
        int[][] data2 = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println(Arrays.deepToString(dataScience(data2)));
    }

    public static String replaceVovels(String a) {
        String[] vowels = {"a", "e", "i", "o", "u", "y"};
        for (int i = 0; i < vowels.length; i++) {
            a = a.replace(vowels[i], "*");
            a = a.replace(vowels[i].toUpperCase(), "*");
        }
        return a;
    }

    public static String stringTransform(String a) {
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                a = a.replace(a.substring(i, i + 2), "Double" + a.substring(i, i + 1).toUpperCase());
            }
        }
        return a;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        if (a <= w && b <= h || a <= h && b <= w) {
            return true;
        } else if (b <= w && c <= h || b <= h && c<= w) {
            return true;
        } else if (a <= w && c <= h || a <= h && c <= w) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numCheck(int x) {
        int num = x;
        int sum = 0;
        while (x != 0) {
            sum += (int) Math.pow(x % 10, 2);
            x = x / 10;
        }
        if (sum % 2 == num % 2) {
            return true;
        } else {
            return false;
        }
    }

    public static int countRoots(int[] x) {
        if ((Math.pow(x[1], 2) - 4 * x[0] * x[2]) > 0) {
            return 2;
        } else if ((Math.pow(x[1], 2) - 4 * x[0] * x[2]) == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String salesData(String[][] product) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < product.length; i++) {
            if (product[i].length == 5 && product[i][1].equals("Shop1") && product[i][2].equals("Shop2")
                    && product[i][3].equals("Shop3") && product[i][4].equals("Shop4")) {
                list.add(product[i][0]);
            }
        }
        String[] shops = list.toArray(new String[0]);
        return Arrays.toString(shops);
    }

    public static boolean validSplit(String a) {
        String[] str = a.split(" ");
        if (str.length < 2) {
            return false;
        }
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].charAt(str[i].length() - 1) != str[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] x) {
        for (int i = 0; i < x.length - 2; i++) {
            if (!(x[i] - x[i + 1] < 0 && x[i + 1] - x[i + 2] > 0 || x[i] - x[i + 1] > 0 && x[i + 1] - x[i + 2] < 0)) {
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String x) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int[] count = new int[vowels.length];
        x = x.toLowerCase();
        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (x.charAt(i) == vowels[j]) {
                    count[j] += 1;
                }
            }
        }
        int maxCount = count[0];
        int maxIndex = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxIndex = i;
            }
        }
        return vowels[maxIndex];
    }

    public static int[][] dataScience(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            int k = 0;
            for (int j = 0; j < x.length; j++) {
                if (i != j) {
                    k += x[j][i];
                }
            }
            int average = Math.round(k / (x.length - 1f));
            x[i][i] = average;
        }
        return x;
    }
}