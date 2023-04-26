package xyz.anomatver.functions;

public class Tan {

    public static Double of(Double x) {
        return Sin.of(x) / Cos.of(x);
    }
}
