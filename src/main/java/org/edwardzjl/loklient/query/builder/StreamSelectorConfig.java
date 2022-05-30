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

import org.edwardzjl.loklient.query.selector.LogStreamSelector;
import org.edwardzjl.loklient.query.selector.LogStreamSelectorPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Junlin Zhou
 */
public class StreamSelectorConfig {

    private final List<LogStreamSelectorPredicate.LogStreamSelectorPredicateBuilder> selectorPredicateBuilders
            = new ArrayList<>();


    public StreamSelectorConfig selector(Consumer<LogStreamSelectorPredicate.LogStreamSelectorPredicateBuilder> customizer) {
        LogStreamSelectorPredicate.LogStreamSelectorPredicateBuilder predicateBuilder
                = LogStreamSelectorPredicate.builder();
        customizer.accept(predicateBuilder);
        selectorPredicateBuilders.add(predicateBuilder);
        return this;
    }

    public LogStreamSelector build() {
        LogStreamSelector logStreamSelector = new LogStreamSelector();
        if (!selectorPredicateBuilders.isEmpty()) {
            selectorPredicateBuilders.stream()
                    .map(LogStreamSelectorPredicate.LogStreamSelectorPredicateBuilder::build)
                    .forEach(logStreamSelector::addSelector);
        }
        return logStreamSelector;
    }

}
