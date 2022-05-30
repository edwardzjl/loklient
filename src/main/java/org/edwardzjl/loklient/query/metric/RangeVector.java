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
package org.edwardzjl.loklient.query.metric;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

/**
 * Basically a wrapper of {@link Duration}, as {@link Duration} is final.
 * <p>
 * See <a href="https://grafana.com/docs/loki/latest/logql/metric_queries/#range-vector-aggregation">this</a> and
 * <a href="https://prometheus.io/docs/prometheus/latest/querying/basics/#range-vector-selectors">this</a>
 *
 * @author Junlin Zhou
 */

@AllArgsConstructor
public class RangeVector {

    private static final String START = "[";
    private static final String END = "]";

    private Duration duration;

    // region static creators

    public static RangeVector ofDays(long days) {
        Duration duration = Duration.ofDays(days);
        return new RangeVector(duration);
    }

    public static RangeVector ofHours(long hours) {
        Duration duration = Duration.ofHours(hours);
        return new RangeVector(duration);
    }

    public static RangeVector ofMinutes(long minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        return new RangeVector(duration);
    }

    public static RangeVector ofSeconds(long seconds) {
        Duration duration = Duration.ofSeconds(seconds);
        return new RangeVector(duration);
    }

    public static RangeVector ofSeconds(long seconds, long nanoAdjustment) {
        Duration duration = Duration.ofSeconds(seconds, nanoAdjustment);
        return new RangeVector(duration);
    }

    public static RangeVector ofMillis(long millis) {
        Duration duration = Duration.ofMillis(millis);
        return new RangeVector(duration);
    }

    public static RangeVector ofNanos(long nanos) {
        Duration duration = Duration.ofNanos(nanos);
        return new RangeVector(duration);
    }

    public static RangeVector of(long amount, TemporalUnit unit) {
        Duration duration = Duration.of(amount, unit);
        return new RangeVector(duration);
    }

    public static RangeVector from(TemporalAmount amount) {
        Duration duration = Duration.from(amount);
        return new RangeVector(duration);
    }

    public static RangeVector parse(CharSequence text) {
        Duration duration = Duration.parse(text);
        return new RangeVector(duration);
    }

    public static RangeVector between(Temporal startInclusive, Temporal endExclusive) {
        Duration duration = Duration.between(startInclusive, endExclusive);
        return new RangeVector(duration);
    }

    // endregion

    // region delegate operations with "Accessors"
    public RangeVector plus(Duration duration) {
        this.duration = this.duration.plus(duration);
        return this;
    }

    public RangeVector plus(long amountToAdd, TemporalUnit unit) {
        this.duration = this.duration.plus(amountToAdd, unit);
        return this;
    }

    public RangeVector plusDays(long daysToAdd) {
        this.duration = this.duration.plusDays(daysToAdd);
        return this;
    }

    public RangeVector plusHours(long hoursToAdd) {
        this.duration = this.duration.plusHours(hoursToAdd);
        return this;
    }

    public RangeVector plusMinutes(long minutesToAdd) {
        this.duration = this.duration.plusMinutes(minutesToAdd);
        return this;
    }

    public RangeVector plusSeconds(long secondsToAdd) {
        this.duration = this.duration.plusSeconds(secondsToAdd);
        return this;
    }

    public RangeVector plusMillis(long millisToAdd) {
        this.duration = this.duration.plusMillis(millisToAdd);
        return this;
    }

    public RangeVector plusNanos(long nanosToAdd) {
        this.duration = this.duration.plusNanos(nanosToAdd);
        return this;
    }

    public RangeVector minus(Duration duration) {
        this.duration = this.duration.minus(duration);
        return this;
    }

    public RangeVector minus(long amountToSubtract, TemporalUnit unit) {
        this.duration = this.duration.minus(amountToSubtract, unit);
        return this;
    }

    public RangeVector minusDays(long daysToSubtract) {
        this.duration = this.duration.minusDays(daysToSubtract);
        return this;
    }

    public RangeVector minusHours(long hoursToSubtract) {
        this.duration = this.duration.minusHours(hoursToSubtract);
        return this;
    }

    public RangeVector minusMinutes(long minutesToSubtract) {
        this.duration = this.duration.minusMinutes(minutesToSubtract);
        return this;
    }

    public RangeVector minusSeconds(long secondsToSubtract) {
        this.duration = this.duration.minusSeconds(secondsToSubtract);
        return this;
    }

    public RangeVector minusMillis(long millisToSubtract) {
        this.duration = this.duration.minusMillis(millisToSubtract);
        return this;
    }

    public RangeVector minusNanos(long nanosToSubtract) {
        this.duration = this.duration.minusNanos(nanosToSubtract);
        return this;
    }

    public RangeVector multipliedBy(long multiplicand) {
        this.duration = this.duration.multipliedBy(multiplicand);
        return this;
    }

    public RangeVector dividedBy(long divisor) {
        this.duration = this.duration.dividedBy(divisor);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangeVector that = (RangeVector) o;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(START);
        final long totalDays = duration.toDays();
        final long years = totalDays / 365;
        if (years > 0) {
            sb.append(years).append('y');
        }
        final long weeks = (totalDays % 365) / 7;
        if (weeks > 0) {
            sb.append(weeks).append('w');
        }
        final long days = totalDays % 365 % 7;
        if (days > 0) {
            sb.append(days).append('d');
        }
        final int hours = duration.toHoursPart();
        if (hours > 0) {
            sb.append(hours).append('h');
        }
        final int minutes = duration.toMinutesPart();
        if (minutes > 0) {
            sb.append(minutes).append('m');
        }
        final int seconds = duration.toSecondsPart();
        if (seconds > 0) {
            sb.append(seconds).append('s');
        }
        final int millis = duration.toMillisPart();
        if (millis > 0) {
            sb.append(millis).append("ms");
        }
        sb.append(END);
        return sb.toString();
    }

}
