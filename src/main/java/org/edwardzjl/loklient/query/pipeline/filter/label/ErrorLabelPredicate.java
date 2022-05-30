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

/**
 * @author Junlin Zhou
 */
public class ErrorLabelPredicate extends StringLabelPredicate {

    private ErrorLabelPredicate(LabelMatchingOperator op, String value) {
        super("__error__", op, value);
    }

    public static ErrorLabelPredicateBuilder builder() {
        return new ErrorLabelPredicateBuilder();
    }

    public static class ErrorLabelPredicateBuilder extends StringLabelPredicateBuilder<ErrorLabelPredicate> {
        private ErrorLabelPredicateBuilder() {
            super();
            super.key("__error__");
        }

        @Override
        public ErrorLabelPredicateBuilder key(String key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ErrorLabelPredicate build() {
            return new ErrorLabelPredicate(op, value);
        }

    }

}
