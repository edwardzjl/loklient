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

import org.edwardzjl.loklient.query.LogQuery;

import java.util.function.Consumer;

/**
 * @author Junlin Zhou
 */
public class DefaultQueryBuilder {

    private final StreamSelectorConfig streamSelectorConfig = new StreamSelectorConfig();
    private final LogPipelineConfig logPipelineConfig = new LogPipelineConfig();

    private DefaultQueryBuilder() {
    }

    public static DefaultQueryBuilder of() {
        return new DefaultQueryBuilder();
    }

    public DefaultQueryBuilder selector(Consumer<StreamSelectorConfig> customizer) {
        customizer.accept(streamSelectorConfig);
        return this;
    }

    public DefaultQueryBuilder pipeline(Consumer<LogPipelineConfig> customizer) {
        customizer.accept(logPipelineConfig);
        return this;
    }

    public LogQuery build() {
        return LogQuery.of(streamSelectorConfig.build(), logPipelineConfig.build());
    }

}
