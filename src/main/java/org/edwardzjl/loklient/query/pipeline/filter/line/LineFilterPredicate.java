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
package org.edwardzjl.loklient.query.pipeline.filter.line;

import org.edwardzjl.loklient.query.operators.FilterOperator;
import org.edwardzjl.loklient.query.structure.PredicateBuilder;
import org.edwardzjl.loklient.query.structure.UnitaryPredicate;

import java.util.Objects;

/**
 * See <a href="https://grafana.com/docs/loki/latest/logql/log_queries/#line-filter-expression">this</a>
 *
 * @author Junlin Zhou
 */
public final class LineFilterPredicate implements UnitaryPredicate<FilterOperator, String> {

    private final FilterOperator op;

    private final String value;

    private LineFilterPredicate(FilterOperator op, String value) {
        this.op = op;
        this.value = value;
    }

    public static LineFilterPredicateBuilder op(FilterOperator op) {
        LineFilterPredicateBuilder builder = new LineFilterPredicateBuilder();
        return builder.op(op);
    }

    @Override
    public FilterOperator getOperator() {
        return op;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static LineFilterPredicateBuilder builder() {
        return new LineFilterPredicateBuilder();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineFilterPredicate that = (LineFilterPredicate) obj;
        return Objects.equals(this.op, that.op) &&
                Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.op, this.value);
    }

    @Override
    public String toString() {
        return this.op.toString() + ' ' + '`' + this.value + '`';
    }


    public static class LineFilterPredicateBuilder implements PredicateBuilder<LineFilterPredicate> {

        private FilterOperator op;
        private String value;

        private LineFilterPredicateBuilder() {
        }

        public LineFilterPredicateBuilder op(FilterOperator op) {
            this.op = op;
            return this;
        }

        public LineFilterPredicateBuilder value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public LineFilterPredicate build() {
            return new LineFilterPredicate(op, value);
        }

    }

}
