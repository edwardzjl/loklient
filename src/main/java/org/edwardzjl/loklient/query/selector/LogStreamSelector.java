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
package org.edwardzjl.loklient.query.selector;

import org.edwardzjl.loklient.query.structure.QuerySection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Junlin Zhou
 */
public final class LogStreamSelector implements QuerySection {

    private static final String START = "{";

    private static final String END = "}";

    private static final String DELIMITER = ",";

    /**
     * Use {@link Set} because the order does not matter and duplicate selectors should be filtered out.
     */
    private final Set<LogStreamSelectorPredicate> selectors = new HashSet<>();


    public LogStreamSelector addSelector(LogStreamSelectorPredicate selector) {
        selectors.add(selector);
        return this;
    }

    public LogStreamSelector addSelectors(Collection<? extends LogStreamSelectorPredicate> selectors) {
        this.selectors.addAll(selectors);
        return this;
    }

    @Override
    public String toString() {
        String content = selectors.stream()
                .map(LogStreamSelectorPredicate::toString)
                .collect(Collectors.joining(DELIMITER));
        return START + content + END;
    }

}
