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
package org.edwardzjl.loklient.query.pipeline.filter.label;

import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.edwardzjl.loklient.query.structure.BinaryPredicate;
import org.edwardzjl.loklient.query.structure.PredicateBuilder;

import java.util.Objects;

/**
 * @author Junlin Zhou
 */
public class StringLabelPredicate extends LabelFilterPredicate
        implements BinaryPredicate<String, LabelMatchingOperator, String> {

    private final String labelIdentifier;
    private final LabelMatchingOperator op;
    private final String value;

    protected StringLabelPredicate(String labelIdentifier, LabelMatchingOperator op, String value) {
        this.labelIdentifier = labelIdentifier;
        this.op = op;
        this.value = value;
    }

    public static StringLabelPredicateBuilder<? extends StringLabelPredicate> builder() {
        return new StringLabelPredicateBuilder<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringLabelPredicate that = (StringLabelPredicate) obj;
        return Objects.equals(this.labelIdentifier, that.labelIdentifier) &&
                Objects.equals(this.op, that.op) &&
                Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.labelIdentifier, this.op, this.value);
    }

    @Override
    public String getExpression() {
        return this.labelIdentifier + ' ' + this.op + ' ' + '`' + this.value + '`';
    }

    @Override
    public String getKey() {
        return labelIdentifier;
    }

    @Override
    public LabelMatchingOperator getOperator() {
        return op;
    }

    @Override
    public String getValue() {
        return value;
    }


    public static class StringLabelPredicateBuilder<P extends StringLabelPredicate> implements PredicateBuilder<P> {
        private String key;
        protected LabelMatchingOperator op;
        protected String value;

        protected StringLabelPredicateBuilder() {
        }


        public StringLabelPredicateBuilder<P> key(String key) {
            this.key = key;
            return this;
        }

        public StringLabelPredicateBuilder<P> op(LabelMatchingOperator op) {
            this.op = op;
            return this;
        }

        public StringLabelPredicateBuilder<P> value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public P build() {
            //noinspection unchecked
            return (P) new StringLabelPredicate(key, op, value);
        }
    }

}
