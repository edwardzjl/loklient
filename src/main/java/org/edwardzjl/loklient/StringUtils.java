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

/**
 * @author Junlin Zhou
 */
public final class StringUtils {
    private StringUtils() {
    }

    /**
     * To avoid escaping special characters you can use the `(backtick) instead of " when quoting strings.
     * For example `\w+` is the same as "\\w+".
     * <p>
     * This is specially useful when writing a regular expression which contains multiple backslashes that require
     * escaping.
     * <p>
     * See <a href="https://grafana.com/docs/loki/latest/logql/log_queries/#log-queries">this</a>
     */
    public static String stringValueWrapper(String source) {
        return '`' + source + '`';
    }

}
