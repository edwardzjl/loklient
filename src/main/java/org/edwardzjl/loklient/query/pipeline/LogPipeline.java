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
package org.edwardzjl.loklient.query.pipeline;

import org.edwardzjl.loklient.query.structure.Expression;
import org.edwardzjl.loklient.query.structure.QuerySection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Junlin Zhou
 */
public class LogPipeline implements QuerySection {

    private static final String DELIMITER = " ";

    /**
     * Use {@link List} because the order of filter matters.
     */
    private final List<Expression> components = new ArrayList<>();

    public LogPipeline add(Expression expression) {
        this.components.add(expression);
        return this;
    }

    @Override
    public String toString() {
        return components.stream()
                .map(Expression::toString)
                .collect(Collectors.joining(DELIMITER));
    }

}
