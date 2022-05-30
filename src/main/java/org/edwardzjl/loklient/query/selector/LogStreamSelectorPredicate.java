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
package org.edwardzjl.loklient.query.selector;

import lombok.Getter;
import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.edwardzjl.loklient.query.structure.Predicate;
import org.edwardzjl.loklient.query.structure.PredicateBuilder;

import java.util.Objects;

/**
 * See <a href="https://grafana.com/docs/loki/latest/logql/log_queries/#log-stream-selector">loki doc</a>
 * and <a href="https://prometheus.io/docs/prometheus/latest/querying/basics/#instant-vector-selectors">prometheus doc</a>
 *
 * @author Junlin Zhou
 */
public final class LogStreamSelectorPredicate implements Predicate {

    @Getter
    private final String key;
    @Getter
    private final LabelMatchingOperator op;
    @Getter
    private final String value;

    private LogStreamSelectorPredicate(String key, LabelMatchingOperator op, String value) {
        this.key = key;
        this.op = op;
        this.value = value;
    }

    public static LogStreamSelectorPredicateBuilder builder() {
        return new LogStreamSelectorPredicateBuilder();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LogStreamSelectorPredicate that = (LogStreamSelectorPredicate) obj;
        return Objects.equals(this.key, that.key) &&
                Objects.equals(this.op, that.op) &&
                Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.op, this.value);
    }

    @Override
    public String toString() {
        return this.key + this.op + '`' + this.value + '`';
    }


    public static class LogStreamSelectorPredicateBuilder implements PredicateBuilder<LogStreamSelectorPredicate> {
        private String key;
        private LabelMatchingOperator op;
        private String value;

        private LogStreamSelectorPredicateBuilder() {
        }


        public LogStreamSelectorPredicateBuilder key(String key) {
            this.key = key;
            return this;
        }

        public LogStreamSelectorPredicateBuilder op(LabelMatchingOperator op) {
            this.op = op;
            return this;
        }

        public LogStreamSelectorPredicateBuilder value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public LogStreamSelectorPredicate build() {
            return new LogStreamSelectorPredicate(key, op, value);
        }

    }

}
