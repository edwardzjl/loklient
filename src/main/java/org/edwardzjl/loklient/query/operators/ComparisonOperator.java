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
package org.edwardzjl.loklient.query.operators;

import lombok.Getter;

/**
 * See <a href=
 * "https://grafana.com/docs/loki/latest/logql/#comparison-operators">this</a>
 * 
 * @author Junlin Zhou
 */
public enum ComparisonOperator implements BinaryOperator {

    /**
     * equality
     */
    EQUAL("=="),
    /**
     * inequality
     */
    UNEQUAL("!="),
    /**
     * greater than
     */
    GREATER_THAN(">"),
    /**
     * greater than or equal to
     */
    GREATER_THAN_OR_EQUAL_TO(">="),
    /**
     * less than
     */
    LESS_THAN("<"),
    /**
     * less than or equal to
     */
    LESS_THAN_OR_EQUAL_TO("<=");

    @Getter
    private final String symbol;

    ComparisonOperator(String symbol) {
        this.symbol = symbol;
    }

}
