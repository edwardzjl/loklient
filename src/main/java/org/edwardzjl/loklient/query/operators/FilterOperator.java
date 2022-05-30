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
 * @author Junlin Zhou
 */
public enum FilterOperator implements BinaryOperator {
    
    /**
     * Log line contains string
     */
    CONTAINS("|="),
    /**
     * Log line does not contain string
     */
    NOT_CONTAIN("!="),
    /**
     * Log line contains a match to the regular expression
     */
    MATCH("|~"),
    /**
     * Log line does not contain a match to the regular expression
     */
    NOT_MATCH("!~");


    FilterOperator(String symbol) {
        this.symbol = symbol;
    }

    @Getter
    private final String symbol;

    @Override
    public String toString() {
        return symbol;
    }

}
