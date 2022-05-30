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
package org.edwardzjl.loklient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nullable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @author Junlin Zhou
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryResult {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private QueryRangeResultData data;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class QueryRangeResultData {

        @JsonProperty("resultType")
        private String resultType;

        @JsonProperty("result")
        private List<QueryRangeResultDataResult> result;

    }

    /**
     * May contain only one of {@link QueryRangeResultDataResult#value} and {@link QueryRangeResultDataResult#values}
     */
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class QueryRangeResultDataResult {

        @JsonProperty("metric")
        private Map<String, String> metric;

        @Nullable
        @JsonProperty("value")
        private QueryRangeResultDataResultValue value;

        @Nullable
        @JsonProperty("values")
        private List<QueryRangeResultDataResultValue> values;

    }

    @Data
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static class QueryRangeResultDataResultValue {

        private Instant timestamp;

        private String value;

    }

}

