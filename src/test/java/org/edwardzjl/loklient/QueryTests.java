package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.LogQuery;
import org.edwardzjl.loklient.query.builder.DefaultQueryBuilder;
import org.edwardzjl.loklient.query.builder.LogPipelineConfig;
import org.edwardzjl.loklient.query.operators.FilterOperator;
import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.junit.jupiter.api.Test;

/**
 * @author Junlin Zhou
 */
public class QueryTests {

    @Test
    void selectorOnlyQueryBuilderTest() {
        DefaultQueryBuilder queryBuilder = DefaultQueryBuilder.of();
        LogQuery query = queryBuilder
                .selector(selectorConfig -> selectorConfig
                        .selector(s -> s
                                .key("namespace").op(LabelMatchingOperator.EQUAL).value("aix")
                        )
                        .selector(s -> s
                                .key("app").op(LabelMatchingOperator.EQUAL).value("aix-backend")
                        )
                ).build();
        // the order may change, so it's difficult to compare the generated string using assertEquals
        System.out.println(query.toString());
    }

    @Test
    void queryBuilderTest() {
        DefaultQueryBuilder queryBuilder = DefaultQueryBuilder.of();
        LogQuery query = queryBuilder
                .selector(selectorConfig -> selectorConfig
                        .selector(s -> s
                                .key("namespace").op(LabelMatchingOperator.EQUAL).value("aix")
                        )
                        .selector(s -> s
                                .key("app").op(LabelMatchingOperator.EQUAL).value("aix-backend")
                        )
                )
                .pipeline(pipelineConfig -> pipelineConfig
                        // chain example
                        .filter()
                        // consumer example
                        .lineFilter(lineFilterConfig -> lineFilterConfig
                                .filter(filter -> filter
                                        .op(FilterOperator.CONTAINS).value("audit_info")
                                )
                                .filter(filter -> filter
                                        .op(FilterOperator.CONTAINS).value("00000000-0000-0000-0000-100000000000")
                                )
                        )
                        .and()
                        .parser(LogPipelineConfig.ParserConfig::jsonParser)
                        .filter(filterConfig -> filterConfig
                                .labelFilter(labelFilterConfig -> labelFilterConfig
                                        .errorFilter(filter -> filter.op(LabelMatchingOperator.EQUAL).value(""))
                                        .conjunction()
                                )
                        )
                ).build();
        System.out.println(query.toString());
    }


    void qTest() {
        String expected = "sum(count_over_time({namespace=`aix`, container=`aix-backend`} |= `audit_info`" +
                " |= `00000000-0000-0000-0000-100000000000` | json | __error__=``" +
                " | (contextMap_path =~ `/aitable/openapi/v1/datasets/create/?` and (contextMap_method = `POST`))" +
                " or (contextMap_path =~ `/aitable/openapi/v1/trains/pipelines/?` and contextMap_method = `POST`)" +
                " or (contextMap_path =~ `/aitable/openapi/v1/models/prediction/?` and contextMap_method = `POST`)" +
                " or (contextMap_path =~ `/aitable/openapi/v1/trains/detail/?` and contextMap_method = `GET`)" +
                " or (contextMap_path =~ `/aitable/openapi/v1/models/detail/?` and contextMap_method = `GET`)" +
                " or (contextMap_path =~ `/aitable/openapi/v1/trains/cancel/?` and contextMap_method = `POST`)" +
                " | contextMap_userId = `00000000-0000-0000-0000-100000000000` [1d]" +
                ")) by (contextMap_method, contextMap_path)";
    }

}
