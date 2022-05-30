package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.metric.RangeVector;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Junlin Zhou
 */
public class UtilTests {

    @Test
    void durationTest() {
        Duration of = Duration.of(12L, ChronoUnit.HOURS)
                .plusMinutes(20)
                .plusSeconds(13)
                .plusMillis(31)
                .plusNanos(10150);
        assertEquals("12h20m13s31ms10us150ns", TimeUtil.logQLFormat(of));
    }

    @Test
    void rangeVectorTest() {
        final String result = RangeVector.ofDays(1).plusDays(365).toString();
        assertEquals("[1y1d]", result);
    }


}
