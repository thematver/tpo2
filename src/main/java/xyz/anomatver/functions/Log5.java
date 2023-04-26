package xyz.anomatver.functions;

public class Log5 {
    public static Double of(Double x) {
        double lnX = Ln.of(x);
        double ln5 = Ln.of(5.0);

        return lnX / ln5;
    }
}
