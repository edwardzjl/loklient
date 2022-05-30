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
package org.edwardzjl.loklient.query.pipeline.parser;

import org.edwardzjl.loklient.query.structure.ExpressionBuilder;

import javax.annotation.Nonnull;

/**
 * @author Junlin Zhou
 */
public class PatternParser implements Parser {

    private static final String NAME = "pattern";

    @Nonnull
    private final String pattern;

    private PatternParser(@Nonnull String pattern) {
        this.pattern = pattern;
    }

    public static PatternParserBuilder builder() {
        return new PatternParserBuilder();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "| " + getName() + '`' + pattern + '`';
    }

    public static class PatternParserBuilder implements ExpressionBuilder<PatternParser> {

        private String pattern;

        private PatternParserBuilder() {
        }

        public PatternParserBuilder pattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        @Override
        public PatternParser build() {
            return new PatternParser(pattern);
        }
    }

}
