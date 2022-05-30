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
package org.edwardzjl.loklient.query;

import org.edwardzjl.loklient.query.pipeline.LogPipeline;
import org.edwardzjl.loklient.query.selector.LogStreamSelector;

/**
 * @author Junlin Zhou
 */
public class LogQuery {

    private final LogStreamSelector streamSelector;
    private final LogPipeline pipelineExpression;

    LogQuery(LogStreamSelector streamSelector, LogPipeline pipelineExpression) {
        this.streamSelector = streamSelector;
        this.pipelineExpression = pipelineExpression;
    }

    public static LogQuery of(LogStreamSelector streamSelector, LogPipeline pipelineExpression) {
        return new LogQuery(streamSelector, pipelineExpression);
    }

    @Override
    public String toString() {
        return (streamSelector.toString() + " " + pipelineExpression.toString()).trim();
    }
}
