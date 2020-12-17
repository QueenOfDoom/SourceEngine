package net.qod.engine.math;

import java.math.MathContext;
import java.math.RoundingMode;

public class MathUtil {
    public static final MathContext DECIMAL16 =
            new MathContext(2,RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL256 =
            new MathContext(70,RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL512 =
            new MathContext(142,RoundingMode.HALF_EVEN);

    /**
     * Java is shit at rounding numbers, so I
     * created a utility, which rounds the value,
     * if it is +- 0.1 next to a long, to a long.
     * @param value - value
     * @return rounded value
     */
    public static double longRound(double value) {
        long res = Math.round(value);
        return Math.abs(res-value) < 0.1 ? res : value;
    }
}
