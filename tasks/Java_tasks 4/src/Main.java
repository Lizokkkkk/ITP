import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(5));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println(caracters("aaabbcdd"));
        System.out.println(caracters("vvvvaajaaaaa"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        int[][] x = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] y = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(x));
        System.out.println(shortestWay(y));

        System.out.println(numericOrder("t3o the2m 1One all5 r4ule ring6"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String a) {
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) == -1) {
                b += a.charAt(i);
            } else {
                continue;
            }
        }
        return b;
    }

    public static ArrayList<String> generateBrackets(int k) {
        ArrayList<String> combinations = new ArrayList<String>();
        int open = 0;
        int close = 0;
        recursionBrackets(k, open, close, new String(), combinations);
        return combinations;
    }

    private static void recursionBrackets(int k, int open, int close, String str, ArrayList<String> combinations) {
        if (str.length() == 2 * k)
            combinations.add(str);
        else {
            if(open == close)
                recursionBrackets(k, open + 1, close, str + "(", combinations);
            else if(close < open) {
                if(open < k)
                    recursionBrackets(k, open + 1, close, str + "(", combinations);
                recursionBrackets(k, open, close + 1, str + ")", combinations);
            }
        }
    }


    public static ArrayList<String> binarySystem(int k) {
        ArrayList<String> combinations = new ArrayList<String>();
        recursionBinary(k, new String(), combinations, 0);
        return combinations;
    }

    private static void recursionBinary(int k, String str, ArrayList<String> combinations, int numberOfZero) {
        if(str.length() == k)
            combinations.add(str);
        else {
            if (numberOfZero == 0) {
                recursionBinary(k, str + "0", combinations, 1);
            }

            recursionBinary(k, str + "1", combinations, 0);
        }
    }


    public static String alphabeticRow(String a) {
        String incrRow = Character.toString(a.charAt(0));
        String longIncrRow = incrRow;
        String decrRow = Character.toString(a.charAt(0));
        String longDecrRow = decrRow;

        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i - 1) + 1 == a.charAt(i)) {
                incrRow += a.charAt(i);
                if (incrRow.length() > longIncrRow.length()) {
                    longIncrRow = incrRow;
                }
            } else {
                incrRow = Character.toString(a.charAt(i));
            }

            if (a.charAt(i - 1) - 1 == a.charAt(i)) {
                decrRow += a.charAt(i);
                if (decrRow.length() > longDecrRow.length()) {
                    longDecrRow = decrRow;
                }
            } else {
                decrRow = Character.toString(a.charAt(i));
            }
        }

        return longIncrRow.length() > longDecrRow.length() ? longIncrRow : longDecrRow;
    }

    public static String caracters(String a) {
        ArrayList<String> chars = new ArrayList<String>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int k = 1;
        String x = Character.toString(a.charAt(0));
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i - 1) == a.charAt(i)) {
                k += 1;
            } else {
                chars.add(x);
                nums.add(k);
                x = Character.toString(a.charAt(i));
                k = 1;
            }
        }

        chars.add(x);
        nums.add(k);

        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            indexs.add(i);
        }
        indexs.sort(Comparator.comparing(nums::get));

        String res = "";
        for (int index : indexs) {
            res += chars.get(index);
            res += nums.get(index);
        }

        return res;
    }

    public static int convertToNum(String a) {
        String[] num = a.split(" ");
        int resNum = 0;
        for (int i = 0; i < num.length; i++) {
            switch (num[i]) {
                case "one": resNum += 1;
                    break;
                case "two": resNum += 2;
                    break;
                case "three": resNum += 3;
                    break;
                case "four": resNum += 4;
                    break;
                case "five": resNum += 5;
                    break;
                case "six": resNum += 6;
                    break;
                case "seven": resNum += 7;
                    break;
                case "eight": resNum += 8;
                    break;
                case "nine": resNum += 9;
                    break;
                case "ten": resNum += 10;
                    break;
                case "eleven": resNum += 11;
                    break;
                case "twelve": resNum += 12;
                    break;
                case "thirteen": resNum += 13;
                    break;
                case "fourteen": resNum += 14;
                    break;
                case "fifteen": resNum += 15;
                    break;
                case "sixteen": resNum += 16;
                    break;
                case "seventeen": resNum += 17;
                    break;
                case "eighteen": resNum += 18;
                    break;
                case "nineteen": resNum += 19;
                    break;
                case "twenty": resNum += 20;
                    break;
                case "thirty": resNum += 30;
                    break;
                case "forty": resNum += 40;
                    break;
                case "fifty": resNum += 50;
                    break;
                case "sixty": resNum += 60;
                    break;
                case "seventy": resNum += 70;
                    break;
                case "eighty": resNum += 80;
                    break;
                case "ninety": resNum += 90;
                    break;
                case "hundred": resNum *= 100;
                    break;
                case "thousand": resNum *= 1000;
                    break;
            }
        }
        return resNum;
    }

    public static String uniqueSubstring(String a) {
        String str = "";
        String maxStr = "";
        for (int i = 0; i < a.length(); i++) {
            if (str.indexOf(a.charAt(i)) == -1) {
                str += a.charAt(i);
                if (str.length() > maxStr.length()) {
                    maxStr = str;
                }
            } else {
                str = Character.toString(a.charAt(i));
            }
        }
        return maxStr;
    }

    public static int shortestWay(int[][] x) {
        int n = x.length;
        int[][] res = new int[n][n];
        res[0][0] = x[0][0];

        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + x[0][i];
            res[i][0] = res[i - 1][0] + x[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + x[i][j];
            }
        }

        return res[n - 1][n - 1];
    }

    public static String numericOrder(String a) {
        String[] str = a.split(" ");
        String[] finalStr = new String[str.length];

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (Character.isDigit(str[i].charAt(j))) {
                    int index = Character.getNumericValue(str[i].charAt(j));
                    finalStr[index - 1] = str[i].substring(0, j) + str[i].substring(j + 1);
                }
            }

        }

        return String.join(" ", finalStr);
    }

    public static int switchNums(int x, int y) {
        String first = Integer.toString(x);
        String second = Integer.toString(y);
        int[] num1 = new int[first.length()];
        int[] num2 = new int[second.length()];

        for (int i = first.length() - 1; i >= 0; i--) {
            num1[i] = x % 10;
            x = (x - x % 10) / 10;
        }

        for (int i = second.length() - 1; i >= 0; i--) {
            num2[i] = y % 10;
            y = (y - y % 10) / 10;
        }

        Arrays.sort(num1);

        for (int i = 0; i < num2.length; i++) {
            for (int j = num1.length - 1; j >= 0; j--) {
                if (num1[j] > num2[i]) {
                    num2[i] = num1[j];
                    num1[j] = 0;
                }
            }
        }

        int k = 1;
        int num = 0;
        for (int i = num2.length - 1; i >= 0; i--) {
            num += num2[i] * k;
            k *= 10;
        }

        return num;
    }
}