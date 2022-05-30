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

import javax.annotation.Nullable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Junlin Zhou
 */
public class JsonParser implements Parser {

    private static final String NAME = "json";

    @Nullable
    private final Map<String, String> params;

    private JsonParser(@Nullable Map<String, String> params) {
        this.params = params;
    }

    public static JsonParserBuilder builder() {
        return new JsonParserBuilder();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        String base = "| " + getName();
        if (params == null || params.isEmpty()) {
            return base;
        }
        String collect = params.entrySet().stream()
                .map(entry -> entry.getKey() + '=' + '`' + entry.getValue() + '`')
                .collect(Collectors.joining(" "));
        return base + ' ' + collect;
    }

    public static class JsonParserBuilder implements ExpressionBuilder<JsonParser> {

        private Map<String, String> params;

        private JsonParserBuilder() {
        }

        public JsonParserBuilder params(Map<String, String> params) {
            this.params = params;
            return this;
        }

        @Override
        public JsonParser build() {
            return new JsonParser(params);
        }
    }

}
