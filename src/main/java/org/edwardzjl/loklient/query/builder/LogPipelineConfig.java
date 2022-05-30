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
package org.edwardzjl.loklient.query.builder;

import org.edwardzjl.loklient.query.pipeline.LogPipeline;
import org.edwardzjl.loklient.query.pipeline.filter.label.ErrorLabelPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.label.StringLabelPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.line.LineFilterPredicate;
import org.edwardzjl.loklient.query.pipeline.parser.JsonParser;
import org.edwardzjl.loklient.query.pipeline.parser.LogFmtParser;
import org.edwardzjl.loklient.query.pipeline.parser.PatternParser;
import org.edwardzjl.loklient.query.pipeline.parser.RegexParser;
import org.edwardzjl.loklient.query.structure.Expression;
import org.edwardzjl.loklient.query.structure.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Junlin Zhou
 */
public class LogPipelineConfig {

    private final List<ExpressionBuilder<? extends Expression>> builders = new ArrayList<>();

    private final FilterConfig filterConfig = new FilterConfig();
    private final ParserConfig parserConfig = new ParserConfig();

    public LogPipelineConfig filter(Consumer<FilterConfig> customizer) {
        customizer.accept(filterConfig);
        return this;
    }

    public FilterConfig filter() {
        return filterConfig;
    }

    public LogPipelineConfig parser(Consumer<ParserConfig> customizer) {
        customizer.accept(parserConfig);
        return this;
    }

    public ParserConfig parser() {
        return parserConfig;
    }


    public final class FilterConfig {
        private final LineFilterConfig lineFilterConfig = new LineFilterConfig();
        private final LabelFilterConfig labelFilterConfig = new LabelFilterConfig();

        public FilterConfig lineFilter(Consumer<LineFilterConfig> customizer) {
            customizer.accept(lineFilterConfig);
            return this;
        }

        public LineFilterConfig lineFilter() {
            return lineFilterConfig;
        }

        public FilterConfig labelFilter(Consumer<LabelFilterConfig> customizer) {
            customizer.accept(labelFilterConfig);
            return this;
        }

        public LabelFilterConfig labelFilter() {
            return labelFilterConfig;
        }

        public LogPipelineConfig and() {
            return LogPipelineConfig.this;
        }

        public final class LineFilterConfig {

            public LineFilterConfig filter(Consumer<LineFilterPredicate.LineFilterPredicateBuilder> customizer) {
                LineFilterPredicate.LineFilterPredicateBuilder builder = LineFilterPredicate.builder();
                customizer.accept(builder);
                builders.add(builder);
                return this;
            }

            public FilterConfig and() {
                return FilterConfig.this;
            }

        }

        public final class LabelFilterConfig {

            public LabelFilterConfig stringFilter(Consumer<StringLabelPredicate.StringLabelPredicateBuilder<? extends StringLabelPredicate>> customizer) {
                StringLabelPredicate.StringLabelPredicateBuilder<? extends StringLabelPredicate> builder = StringLabelPredicate.builder();
                customizer.accept(builder);
                builders.add(builder);
                return this;
            }

            public LabelFilterConfig errorFilter(Consumer<ErrorLabelPredicate.ErrorLabelPredicateBuilder> customizer) {
                ErrorLabelPredicate.ErrorLabelPredicateBuilder builder = ErrorLabelPredicate.builder();
                customizer.accept(builder);
                builders.add(builder);
                return this;
            }

            public LogPipelineConfig and() {
                return LogPipelineConfig.this;
            }


            /**
             * AND
             */
            public void conjunction() {

            }

            /**
             * OR
             */
            public void disjunction() {

            }

        }

    }

    public final class ParserConfig {

        public ParserConfig jsonParser(Consumer<JsonParser.JsonParserBuilder> customizer) {
            JsonParser.JsonParserBuilder builder = JsonParser.builder();
            customizer.accept(builder);
            builders.add(builder);
            return this;
        }

        public ParserConfig jsonParser() {
            JsonParser.JsonParserBuilder builder = JsonParser.builder();
            builders.add(builder);
            return this;
        }

        public ParserConfig logFmtParser(Consumer<LogFmtParser.LogFmtParserBuilder> customizer) {
            LogFmtParser.LogFmtParserBuilder builder = LogFmtParser.builder();
            customizer.accept(builder);
            builders.add(builder);
            return this;
        }

        public ParserConfig logFmtParser() {
            LogFmtParser.LogFmtParserBuilder builder = LogFmtParser.builder();
            builders.add(builder);
            return this;
        }

        public ParserConfig patternParser(Consumer<PatternParser.PatternParserBuilder> customizer) {
            PatternParser.PatternParserBuilder builder = PatternParser.builder();
            customizer.accept(builder);
            builders.add(builder);
            return this;
        }

        public ParserConfig regexParser(Consumer<RegexParser.RegexParserBuilder> customizer) {
            RegexParser.RegexParserBuilder builder = RegexParser.builder();
            customizer.accept(builder);
            builders.add(builder);
            return this;
        }

        public LogPipelineConfig and() {
            return LogPipelineConfig.this;
        }

    }

    public final class FormatterCustomizer {

    }

    public LogPipeline build() {
        LogPipeline logPipeline = new LogPipeline();
        if (!builders.isEmpty()) {
            builders.stream()
                    .map(ExpressionBuilder::build)
                    .forEach(logPipeline::add);
        }
        return logPipeline;
    }

}
