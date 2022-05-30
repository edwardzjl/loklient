/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.edwardzjl.loklient;

import java.time.Duration;

/**
 * @author Junlin Zhou
 */
public final class TimeUtil {

    private TimeUtil() {
    }

    /**
     * Duration is a sequence of decimal numbers, each with optional fraction and a unit suffix,
     * such as “300ms”, “1.5h” or “2h45m”. Valid time units are “ns”, “us” (or “µs”), “ms”, “s”, “m”, “h”.
     * <p>
     * See <a href="https://grafana.com/docs/loki/latest/logql/log_queries/#label-filter-expression">this</a>
     *
     * @param duration java duration
     * @return logQL formatted duration string
     */
    public static String logQLFormat(Duration duration) {
        StringBuilder sb = new StringBuilder();
        long hours = duration.toHours();
        if (hours > 0) {
            sb.append(hours).append('h');
        }
        int minutes = duration.toMinutesPart();
        if (minutes > 0) {
            sb.append(minutes).append('m');
        }
        int seconds = duration.toSecondsPart();
        if (seconds > 0) {
            sb.append(seconds).append('s');
        }
        int millis = duration.toMillisPart();
        if (millis > 0) {
            sb.append(millis).append("ms");
        }
        // see Duration#toNanosPart
        int nanos = duration.toNanosPart();
        int micros = nanos / 1000 % 1000;
        if (micros > 0) {
            sb.append(micros).append("us");
        }
        int realNanos = nanos % 1000;
        if (realNanos > 0) {
            sb.append(realNanos).append("ns");
        }
        return sb.toString();
    }

}
