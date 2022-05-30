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

import org.edwardzjl.loklient.query.operators.ComparisonOperator;
import org.edwardzjl.loklient.query.structure.BinaryPredicate;

/**
 * @author Junlin Zhou
 */
// TODO: 2022/6/2 zjl implement some value object
public class DurationLabelPredicate extends LabelFilterPredicate
        implements BinaryPredicate<String, ComparisonOperator, String> {

    private String labelIdentifier;

    private ComparisonOperator op;

    private String value;

    @Override
    public String getExpression() {
        return "";
    }

    @Override
    public String getKey() {
        return labelIdentifier;
    }

    @Override
    public ComparisonOperator getOperator() {
        return op;
    }

    @Override
    public String getValue() {
        return value;
    }
}
