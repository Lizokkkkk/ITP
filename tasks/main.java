public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
        }

    public static float convert(int x) {
        return x * 3.785f;
    }

    public static int fitCalc(int x, int y) {
        return x * y;
    }

    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if ((x + y) < z | (x + z) < y | (y + z) < x) {
            return "not a triangle";
        } else if (x == y & x == z) {
            return "isosceles";
        } else if (x == y | y == z | x == z) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        int x = a >= b ? a : b;
        return x;
    }


    public static int howManyItems(int n, float w, float h) {
        return (int) (n / (w * h * 2));
    }

    public static int factorial(int x) {
        int a  = 1;
        for (int i = 1; i <= x; i++) {
            a = a * i;
        }
        return a;
    }


    public static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public static float ticketSaler(int x, int y) {
        return x * y * 0.72f;
    }


    public static int tables(int x, int y) {
        if (x <= 2 * y) {
            return 0;
        } else if ((x - 2 * y) % 2 == 0) {
            return (x - 2 * y) / 2;
        } else {
            return (x - 2 * y + 1) / 2;
        }
    }
}
