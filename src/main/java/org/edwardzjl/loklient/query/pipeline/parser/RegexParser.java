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
public class RegexParser implements Parser {

    private static final String NAME = "regexp";

    @Nonnull
    private final String pattern;

    private RegexParser(@Nonnull String pattern) {
        this.pattern = pattern;
    }

    public static RegexParserBuilder builder() {
        return new RegexParserBuilder();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "| " + getName() + '`' + pattern + '`';
    }

    public static class RegexParserBuilder implements ExpressionBuilder<RegexParser> {

        private String pattern;

        private RegexParserBuilder() {
        }

        public RegexParserBuilder pattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        @Override
        public RegexParser build() {
            return new RegexParser(pattern);
        }
    }

}
