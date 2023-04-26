package xyz.anomatver.functions;

public class Function {
    public static Double of(Double x) {
        if (x <= 0) {
            double sinX = Sin.of(x);
            double tanX = Tan.of(x);
            double secX = Sec.of(x);
            double sinSquaredX = Math.pow(sinX, 2);

            return Math.pow(((sinX + tanX) / secX) / sinSquaredX, 3) / secX;
        } else {
            double lnX = Ln.of(x);
            double log2X = Log2.of(x);
            double log5X = Log5.of(x);
            double log10X = Log10.of(x);

            return (((Math.pow(Math.pow(log2X / lnX, 3), 2) - log10X)) * (log5X * log2X));
        }
    }
}
