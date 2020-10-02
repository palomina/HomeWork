public class Main {
    public static void main(String[] args) {
        byte b1 = 1;
        short s1 = 100;
        int i1 = 1111;
        long l1 = 88L;
        float f1 = 222.22f;
        double d1 = 3333.333;
        boolean bool1 = true;
        char ch1 = 'a';
        String str1 = "qqqqq";

        try {
            double resEvaluateExpression = evaluateExpression(1, 2, 3, 5);
            System.out.println("resEvaluateExpression=" + resEvaluateExpression);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        boolean resInRange = inRange(15, 7);
        System.out.println("resInRange=" + resInRange);

        printPositiveOrNegative(1);

        boolean resIsNegative = isNegative(-1);
        System.out.println("resIsNegative=" + resIsNegative);

        printName("Митер Х");

        checkLeapYear(2020);
    }

    public static double evaluateExpression(double a, double b, double c, double d) throws Exception {
        if (d == 0) {
            throw new Exception("Division by zero");
        }
        return a * (b + (c / d));
    }

    public static boolean inRange(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " - положительное");
        } else {
            System.out.println("Число " + a + " - отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        return (a < 0);
    }

    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Год " + year + " високосный");
        } else {
            System.out.println("Год " + year + " не високосный");
        }
    }
}
