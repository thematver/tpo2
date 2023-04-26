package xyz.anomatver.functions;

public class Cos {
    private static final int MAX_ITERATIONS = 1000;
    private static final double EPSILON = 1e-9;

    public static Double of(Double x) {
        double cos = 0;
        double term;
        double xRadians = x % (2 * Math.PI);

        for (int n = 0; n < MAX_ITERATIONS; n++) {
            term = (Math.pow(-1, n) * Math.pow(xRadians, 2 * n)) / factorial(2 * n);
            cos += term;

            if (Math.abs(term) < EPSILON) {
                break;
            }
        }

        return cos;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}