package xyz.anomatver.functions;

public class Log10 {
    public static Double of(Double x) {
        double lnX = Ln.of(x);
        double ln10 = Ln.of(10.0);

        return lnX / ln10;
    }
}
