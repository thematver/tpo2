import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import xyz.anomatver.functions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test {
    MockedStatic<Cos> cos = Mockito.mockStatic(Cos.class);
    MockedStatic<Sin> sin = Mockito.mockStatic(Sin.class);
    MockedStatic<Tan> tg = Mockito.mockStatic(Tan.class);
    MockedStatic<Ln> ln = Mockito.mockStatic(Ln.class);
    MockedStatic<Log2> log2 = Mockito.mockStatic(Log2.class);
    MockedStatic<Log5> log5 = Mockito.mockStatic(Log5.class);
    MockedStatic<Log10> log10 = Mockito.mockStatic(Log10.class);
    MockedStatic<Sec> sec = Mockito.mockStatic(Sec.class);

    final Map<Double, Double> cosTable = new HashMap<>() {{
        put(-0.9, 0.6216099682706644);
        put(-0.8, 0.6967067093471654);
        put(-0.7, 0.7648421872844885);
        put(-0.6, 0.8253356149096783);
        put(-0.5, 0.8775825618903728);
        put(-0.4, 0.9210609940028851);
        put(-0.3, 0.955336489125606);
        put(-0.2, 0.9800665778412416);
        put(-0.1, 0.9950041652780258);
        put(0.0, 1.0);
        put(0.1, 0.9950041652780258);
        put(0.2, 0.9800665778412416);
        put(0.3, 0.955336489125606);
        put(0.4, 0.9210609940028851);
        put(0.5, 0.8775825618903728);
        put(0.6, 0.8253356149096783);
        put(0.7, 0.7648421872844885);
        put(0.8, 0.6967067093471654);
        put(0.9, 0.6216099682706644);
    }};
    final Map<Double, Double> sinTable = new HashMap<>() {{
        put(-0.9, -0.7833269096274834);
        put(-0.8, -0.7173560908995228);
        put(-0.7, -0.644217687237691);
        put(-0.6, -0.5646424733950354);
        put(-0.5, -0.479425538604203);
        put(-0.4, -0.3894183423086505);
        put(-0.3, -0.29552020666133955);
        put(-0.2, -0.19866933079506122);
        put(-0.1, -0.09983341664682815);
        put(0.0, 0.0);
        put(0.1, 0.09983341664682815);
        put(0.2, 0.19866933079506122);
        put(0.3, 0.29552020666133955);
        put(0.4, 0.3894183423086505);
        put(0.5, 0.479425538604203);
        put(0.6, 0.5646424733950354);
        put(0.7, 0.644217687237691);
        put(0.8, 0.7173560908995228);
        put(0.9, 0.7833269096274834);
    }};
    final Map<Double, Double> tanTable = new HashMap<>() {{
        put(-0.9, -1.260158217550339);
        put(-0.8, -1.0296385570503641);
        put(-0.7, -0.8422883804630793);
        put(-0.6, -0.6841368083416923);
        put(-0.5, -0.5463024898437905);
        put(-0.4, -0.4227932187381618);
        put(-0.3, -0.3093362496096232);
        put(-0.2, -0.20271003550867248);
        put(-0.1, -0.10033467208545054);
        put(0.0, 0.0);
        put(0.1, 0.10033467208545054);
        put(0.2, 0.20271003550867248);
        put(0.3, 0.3093362496096232);
        put(0.4, 0.4227932187381618);
        put(0.5, 0.5463024898437905);
        put(0.6, 0.6841368083416923);
        put(0.7, 0.8422883804630793);
        put(0.8, 1.0296385570503641);
        put(0.9, 1.260158217550339);
    }};
    final Map<Double, Double> secTable = new HashMap<>() {{
        put(-0.9, 1.6087258104660498);
        put(-0.8, 1.43532419967224);
        put(-0.7, 1.3074592597335937);
        put(-0.6, 1.2116283145123166);
        put(-0.5, 1.139493927324549);
        put(-0.4, 1.0857044283832387);
        put(-0.3, 1.0467516015380856);
        put(-0.2, 1.0203388449411928);
        put(-0.1, 1.0050209184004553);
        put(0.0, 1.0);
        put(0.1, 1.0050209184004553);
        put(0.2, 1.0203388449411928);
        put(0.3, 1.0467516015380856);
        put(0.4, 1.0857044283832387);
        put(0.5, 1.139493927324549);
        put(0.6, 1.2116283145123166);
        put(0.7, 1.3074592597335937);
        put(0.8, 1.43532419967224);
        put(0.9, 1.6087258104660498);
    }};
    final Map<Double, Double> lnTable = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -2.3025850929940455);
        put(0.2, -1.6094379124341003);
        put(0.3, -1.2039728043259361);
        put(0.4, -0.916290731874155);
        put(0.5, -0.6931471805599453);
        put(0.6, -0.5108256237659907);
        put(0.7, -0.35667494393873245);
        put(0.8, -0.2231435513142097);
        put(0.9, -0.10536051565782628);
    }};
    final Map<Double, Double> log2Table = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -3.321928094887362);
        put(0.2, -2.321928094887362);
        put(0.3, -1.7369655941662063);
        put(0.4, -1.3219280948873622);
        put(0.5, -1.0);
        put(0.6, -0.7369655941662062);
        put(0.7, -0.5145731728297583);
        put(0.8, -0.3219280948873623);
        put(0.9, -0.15200309344504995);
    }};
    final Map<Double, Double> log5Table = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -1.430676558073393);
        put(0.2, -1.0);
        put(0.3, -0.7480703635874079);
        put(0.4, -0.5693234419266069);
        put(0.5, -0.43067655807339306);
        put(0.6, -0.31739380551401475);
        put(0.7, -0.22161460295122554);
        put(0.8, -0.1386468838532139);
        put(0.9, -0.06546416910142246);
    }};
    final Map<Double, Double> log10Table = new HashMap<>() {{
        put(-0.9, Double.NaN);
        put(-0.8, Double.NaN);
        put(-0.7, Double.NaN);
        put(-0.6, Double.NaN);
        put(-0.5, Double.NaN);
        put(-0.4, Double.NaN);
        put(-0.3, Double.NaN);
        put(-0.2, Double.NaN);
        put(-0.1, Double.NaN);
        put(0.0, Double.NaN);
        put(0.1, -1.0);
        put(0.2, -0.6989700043360187);
        put(0.3, -0.5228787452803376);
        put(0.4, -0.3979400086720376);
        put(0.5, -0.3010299956639812);
        put(0.6, -0.2218487496163564);
        put(0.7, -0.1549019599857432);
        put(0.8, -0.09691001300805639);
        put(0.9, -0.045757490560675115);
    }};

    @BeforeEach
    void setUp() {
        cos.reset();
        sin.reset();
        tg.reset();
        sec.reset();
        ln.reset();
        log2.reset();
        log5.reset();
        log10.reset();
        doMock();
    }


    @BeforeAll
    void doMock() {
        cos.when((() -> Cos.of(any(Double.class)))).thenAnswer((x) -> cosTable.get(x.getArgument(0, Double.class)));
        sin.when((() -> Sin.of(any(Double.class)))).thenAnswer((x) -> sinTable.get(x.getArgument(0, Double.class)));
        tg.when((() -> Tan.of(any(Double.class)))).thenAnswer((x) -> tanTable.get(x.getArgument(0, Double.class)));
        sec.when((() -> Sec.of(any(Double.class)))).thenAnswer((x) -> secTable.get(x.getArgument(0, Double.class)));
        ln.when((() -> Ln.of(any(Double.class)))).thenAnswer((x) -> lnTable.get(x.getArgument(0, Double.class)));
        log2.when((() -> Log2.of(any(Double.class)))).thenAnswer((x) -> log2Table.get(x.getArgument(0, Double.class)));
        log5.when((() -> Log5.of(any(Double.class)))).thenAnswer((x) -> log5Table.get(x.getArgument(0, Double.class)));
        log10.when((() -> Log10.of(any(Double.class)))).thenAnswer((x) -> log10Table.get(x.getArgument(0, Double.class)));
    }


    @ParameterizedTest
    @MethodSource("valuesProvider")
    void testFunction(double x, double expectedResult) {
        double result = Function.of(x);
        assertEquals(expectedResult, result, 1e-9, "Expected and actual results differ.");
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.of(-0.9, -5.514778173123264),
                Arguments.of(-0.8, -9.218620862796495),
                Arguments.of(-0.7, -15.725031781833874),
                Arguments.of(-0.6, -27.882912679877695),
                Arguments.of(-0.5, -52.713471702460346),
                Arguments.of(-0.4, -110.57644963791097),
                Arguments.of(-0.3, -276.73197021879696),
                Arguments.of(-0.2, -970.292048185808),
                Arguments.of(-0.1, -7940.146505771744),
                Arguments.of(0.0, Double.NaN),
                Arguments.of(0.1, 47.605376888960556),
                Arguments.of(0.2, 22.559068510884828),
                Arguments.of(0.3, 12.39545569932681),
                Arguments.of(0.4, 7.085495837030726),
                Arguments.of(0.5, 4.012924427528283),
                Arguments.of(0.6, 2.1609714890781544),
                Arguments.of(0.7, 1.0459004099524263),
                Arguments.of(0.8, 0.40677949294178456),
                Arguments.of(0.9, 0.09017822532919892)
        );
    }

}
