package xyz.anomatver.functions;

public class Log2 {
    public static Double of(Double x) {
        double lnX = Ln.of(x);
        double ln2 = Ln.of(2.0);

        return lnX / ln2;
    }
}
