package xyz.anomatver;

import xyz.anomatver.functions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.000");

    public static void writeResultsToCSV(String filename, double start, double end, double step) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write("X|Ln(X)|Log2(X)|Log5(X)|Log10(X)|Sin(X)|Cos(X)|Tan(X)|Sec(X)|CustomFunction(X)\n");

            for (double x = start; x <= end; x += step) {
                Double lnX = x > 0 ? Ln.of(x) : Double.NaN;
                Double log2X = x > 0 ? Log2.of(x) : Double.NaN;
                Double log5X = x > 0 ? Log5.of(x) : Double.NaN;
                Double log10X = x > 0 ? Log10.of(x) : Double.NaN;
                Double sinX = Sin.of(x);
                Double cosX = Cos.of(x);
                Double tanX = Tan.of(x);
                Double secX = Sec.of(x);
                Double customFunctionX = Function.of(x);

                fileWriter.write(String.join("|",
                        DECIMAL_FORMAT.format(x),
                        formatValue(lnX),
                        formatValue(log2X),
                        formatValue(log5X),
                        formatValue(log10X),
                        formatValue(sinX),
                        formatValue(cosX),
                        formatValue(tanX),
                        formatValue(secX),
                        formatValue(customFunctionX)) + "\n");
            }
        }
    }

    private static String formatValue(Double value) {
        if (value.isNaN() || value.isInfinite()) {
            return "NaN";
        } else {
            return DECIMAL_FORMAT.format(value);
        }
    }
    public static void main(String[] args) {
        double start = -9;
        double end = 9;
        double step = 0.1;
        String filename = "out.csv";

        try {
            writeResultsToCSV(filename, start, end, step);
            System.out.println("Results written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
