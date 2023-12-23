import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(spiderVsFly("H3", "A1"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        String[] words1 = {"cat", "create", "sat"};
        System.out.println(totalPoints(words1, "caster"));
        String[] words2 = {"trance", "recant"};
        System.out.println(totalPoints(words2, "recant"));
        String[] words3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(words3, "tossed"));

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(sumsUp(arr1));
        int[] arr2 = {1, 2, 3, 7, 9};
        System.out.println(sumsUp(arr2));
        int[] arr3 = {10, 9, 7, 2, 8};
        System.out.println(sumsUp(arr3));
        int[] arr4 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(sumsUp(arr4));

        String[] percent1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        System.out.println(takeDownAverage(percent1));
        String[] percent2 = {"10%"};
        System.out.println(takeDownAverage(percent2));
        String[] percent3 = {"53%", "79%"};
        System.out.println(takeDownAverage(percent3));

        System.out.println(caesarCipher("encode", "hello worldzxy", 3));
        System.out.println(caesarCipher("decode", "abcepqswx pewx xewo!", 4));

        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        String[] data1 = {"Los Angeles", "April 1, 2011 23:23", "Canberra"};
        System.out.println(timeDifference(data1));
        String[] data2 = {"London", "July 31, 1983 23:01", "Rome"};
        System.out.println(timeDifference(data2));
        String[] data3 = {"New York", "December 31, 1970 13:40", "Beijing"};
        System.out.println(timeDifference(data3));

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern (String str1, String str2) {
        for (int i = 0; i < str1.length() - 1; i++) {
            if (!((str1.charAt(i) - str1.charAt(i + 1)) == (str2.charAt(i) - str2.charAt(i + 1)))) {
                return false;
            }
        }
        return true;
    }

    public static String spiderVsFly(String spider, String fly) {
        String way = "";
        char sL = spider.charAt(0);
        int sN = Character.getNumericValue(spider.charAt(1));
        char fL = fly.charAt(0);
        int fN = Character.getNumericValue(fly.charAt(1));

        // Проверяем находится ли паук с мухой на одном радиале
        if (sL == fL) {
            if (sN < fN) {
                while (sN < fN) {
                    way += sL + Integer.toString(sN) + "-";
                    sN += 1;
                }
                way += fly;
                return way;
            } else if (sN > fN) {
                while (sN > fN) {
                    way += sL + Integer.toString(sN) + "-";
                    sN -= 1;
                }
                way += fly;
                return way;
            } else {
                way += spider;
            }
        }

        // Проверяем находятся ли паук с мухой на противоположных радиалах
        if (Math.abs(sL - fL) == 4) {
            return centerWay(sL, sN, fL, fN, fly);
        } else if (sN > fN) { // Если муха ниже паука
                int k;
                if (Math.abs(sL - fL) < 4) {
                    k = Math.abs(sL - fL);
                } else {
                    k = 8 - Math.abs(sL - fL);
                }
                double centerWay = sN + fN;
                double ringWay = sN - fN + k * Math.sqrt(Math.pow(fN, 2) * (2 - Math.sqrt(2)));

                if (centerWay < ringWay) {
                    return centerWay(sL, sN, fL, fN, fly);
                } else {
                    while (sN > fN) {
                        way += sL + Integer.toString(sN) + "-";
                        sN -= 1;
                    }
                    way += sL + Integer.toString(sN) + "-";
                    if (Math.abs(sL - fL) < 4) { // Проверяем, что путь не проходит через границу A-H
                        if ((sL - fL) < 0) { // Идем по часовой стрелке
                            while (k - 1 > 0) {
                                sL += 1;
                                way += sL + Integer.toString(sN) + "-";
                                k -= 1;
                            }
                            way += fly;
                            return way;
                        } else {
                            while (k - 1 > 0) {
                                sL -= 1;
                                way += sL + Integer.toString(sN) + "-";
                                k -= 1;
                            }
                            way += fly;
                            return way;
                        }
                    } else if (Math.abs(sL - fL) > 4) { // Проверяем, что путь проходит через границу A-H
                        if ((sL - fL) > 0) { // Идем по часовой стрелке
                            while (k - 1 > 0) {
                                if (sL == 'H') {
                                    sL = 'A' - 1;
                                }
                                sL += 1;
                                way += sL + Integer.toString(sN) + "-";
                            }
                            way += fly;
                            return way;
                        } else {
                            while (k - 1 > 0) {
                                if (sL == 'A') {
                                    sL = 'H' + 1;
                                }
                                sL -= 1;
                                way += sL + Integer.toString(sN) + "-";
                            }
                            way += fly;
                            return way;
                        }
                    }
                }
        } else { // Если паук ниже мухи или на том же уровне
            int k;
            if (Math.abs(sL - fL) < 4) {
                k = Math.abs(sL - fL);
            } else {
                k = 8 - Math.abs(sL - fL);
            }
            double centerWay = sN + fN;
            double ringWay = k * Math.sqrt(Math.pow(sN, 2) * (2 - Math.sqrt(2))) + fN - sN;

            if (centerWay < ringWay) {
                return centerWay(sL, sN, fL, fN, fly);
            } else {
                while (sN < fN) {
                    way += sL + Integer.toString(sN) + "-";
                    sN += 1;
                }
                way += sL + Integer.toString(sN) + "-";
                if (Math.abs(sL - fL) < 4) { // Проверяем, что путь не проходит через границу A-H
                    if ((sL - fL) < 0) { // Идем по часовой стрелке
                        while (k - 1 > 0) {
                            sL += 1;
                            way += sL + Integer.toString(sN) + "-";
                            k -= 1;
                        }
                        way += fly;
                        return way;
                    } else {
                        while (k - 1 > 0) {
                            sL -= 1;
                            way += sL + Integer.toString(sN) + "-";
                            k -= 1;
                        }
                        way += fly;
                        return way;
                    }
                } else if (Math.abs(sL - fL) > 4) { // Проверяем, что путь проходит через границу A-H
                    if ((sL - fL) > 0) { // Идем по часовой стрелке
                        while (k - 1 > 0) {
                            if (sL == 'H') {
                                sL = 'A' - 1;
                            }
                            sL += 1;
                            way += sL + Integer.toString(sN) + "-";
                        }
                        way += fly;
                        return way;
                    } else {
                        while (k - 1 > 0) {
                            if (sL == 'A') {
                                sL = 'H' + 1;
                            }
                            sL -= 1;
                            way += sL + Integer.toString(sN) + "-";
                        }
                        way += fly;
                        return way;
                    }
                }
            }
        }
        return way;
    }
    public static String centerWay(char sL, int sN, char fL, int fN, String fly) {
        String way = "";
        while (sN > 0) {
            way += sL + Integer.toString(sN) + "-";
            sN -= 1;
        }
        way += "A0-";
        while (sN < fN - 1) {
            sN += 1;
            way += fL + Integer.toString(sN) + "-";
        }
        way += fly;
        return way;
    }

    public static int digitsCount(long x) {
        if (x < 0) {
            x *= (-1);
        }
        if (x < 10) {
            return 1;
        }

        return 1 + digitsCount(x / 10);
    }

    public static int totalPoints(String[] words, String word) {
        int points = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (letterNumber(words[i], words[i].charAt(j)) > letterNumber(word, words[i].charAt(j))) {
                    i++;
                }
            }
            switch (words[i].length()) {
                case 3:
                    points += 1;
                    break;
                case 4:
                    points += 2;
                    break;
                case 5:
                    points += 3;
                    break;
                case 6:
                    points += 54;
                    break;
            }
        }
        return points;
    }
    public static int letterNumber(String str, char x) {
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == x) {
                k++;
            }
        }
        return k;
    }

    public static String sumsUp(int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[i] + arr[j] == 8) {
                    int[] pair = {arr[i], arr[j]};
                    Arrays.sort(pair);
                    res.add(Arrays.toString(pair));
                }
            }
        }
        return res.toString();
    }

    public static String takeDownAverage(String[] percent) {
        int sum = 0;
        for (int i = 0; i < percent.length; i++) {
            sum += Integer.parseInt(percent[i].substring(0, percent[i].length() - 1));
        }
        int result = (int) Math.round(((double) sum / percent.length - 5) * (percent.length + 1) - sum);
        return result + "%";
    }

    public static String caesarCipher(String command, String message, int x) {
        String result = "";
        if (command.equals("encode")) {
            for (int i = 0; i < message.length(); i++) {
                if (Character.isLetter(message.charAt(i))) {
                    if ((message.charAt(i) + x) > 'z') {
                        result += Character.toUpperCase((char) ('a' + x - ('z' - message.charAt(i)) - 1));
                    } else {
                        result += Character.toUpperCase((char) (message.charAt(i) + x));
                    }
                } else {
                    result += message.charAt(i);
                }
            }
        } else if (command.equals("decode")) {
            for (int i = 0; i < message.length(); i++) {
                if (Character.isLetter(message.charAt(i))) {
                    if ((message.charAt(i) - x) < 'a') {
                        result += Character.toUpperCase((char) ('z' - (x - (message.charAt(i) - 'a') - 1)));
                    } else {
                        result += Character.toUpperCase((char) (message.charAt(i) - x));
                    }
                } else {
                    result += message.charAt(i);
                }
            }
        }
        return result;
    }

    public static int setSetup(int n, int k) {
        return (recursionSetSetup(n) / recursionSetSetup(n - k));
    }
    public static int recursionSetSetup(int a) {
        if (a == 1) {
            return 1;
        }
        return a * recursionSetSetup(a - 1);
    }

    public static String timeDifference(String[] data) {
        String newData = "";
        String city1 = data[0];
        String city2 = data[2];
        int month = getMonth(data[1].split(", ")[0].split(" ")[0]);
        int maxDay = 0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                maxDay = 31;
                break;
            case 4, 6, 9, 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = 28;
        }
        int day = Integer.parseInt(data[1].split(", ")[0].split(" ")[1]);
        int year = Integer.parseInt(data[1].split(", ")[1].split(" ")[0]);
        if (year % 4 == 0 && maxDay == 28) {
            maxDay += 1;
        }
        int hour = Integer.parseInt(data[1].split(", ")[1].split(" ")[1].split(":")[0]);
        int minute = Integer.parseInt(data[1].split(", ")[1].split(" ")[1].split(":")[1]);

        int newMin = minute - getTime(city1)[1] + getTime(city2)[1]; // Считаем минуты
        if (newMin >= 60) {
            hour += 1;
            newMin -= 60;
        }

        int newHour = hour - getTime(city1)[0] + getTime(city2)[0]; // Считаем часы
        if (newHour >= 24) {
            day += 1;
            newHour -= 24;
        }

        if (day > maxDay) { // Определяем день
            day -= maxDay;
            month += 1;
        }

        if (month > 12) { // Определяем месяц
            year += 1;
            month -= 12;
        }

        newData = year + "-" + month + "-" + day + " ";
        if (newHour < 10) {
            newData += "0";
        }
        newData += newHour + ":";
        if (newMin < 10) {
            newData += "0";
        }
        newData += newMin;

        return newData;
    }
    public static int[] getTime(String city) {
        int[] time = new int[2];
        switch (city) {
            case "Los Angeles":
                time[0] = -8;
                break;
            case "New York":
                time[0] = -5;
                break;
            case "Caracas":
                time[0] = -4;
                time[1] = -30;
                break;
            case "Buenos Aires":
                time[0] = -3;
                break;
            case "Rome":
                time[0] = 1;
                break;
            case "Moscow":
                time[0] = 3;
                break;
            case "Tehran":
                time[0] = 3;
                time[1] = 30;
                break;
            case "New Delhi":
                time[0] = 5;
                time[1] = 30;
                break;
            case "Beijing":
                time[0] = 8;
                break;
            case "Canberra":
                time[0] = 10;
                break;
        }
        return time;
    }
    public static int getMonth(String month) {
        int numMonth = 0;
        switch (month) {
            case "January":
                numMonth = 1;
                break;
            case "February":
                numMonth = 2;
                break;
            case "March":
                numMonth = 3;
                break;
            case "April":
                numMonth = 4;
                break;
            case "May":
                numMonth = 5;
                break;
            case "June":
                numMonth = 6;
                break;
            case "July":
                numMonth = 7;
                break;
            case "August":
                numMonth = 8;
                break;
            case "September":
                numMonth = 9;
                break;
            case "October":
                numMonth = 10;
                break;
            case "November":
                numMonth = 11;
                break;
            case "December":
                numMonth = 12;
                break;
        }
        return numMonth;
    }

    public static boolean isNew(int number) {
        String num = Integer.toString(number);
        if (num.length() == 1) {
            return true;
        } else {
            for (int i = 1; i < num.length(); i++) {
                if (Character.getNumericValue(num.charAt(i)) < Character.getNumericValue(num.charAt(0)) && Character.getNumericValue(num.charAt(i)) != 0) {
                    return false;
                }
            }
            return true;
        }

    }
}