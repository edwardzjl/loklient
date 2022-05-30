package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.pipeline.filter.label.StringLabelPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.line.LineFilterPredicate;
import org.edwardzjl.loklient.query.operators.FilterOperator;
import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.edwardzjl.loklient.query.structure.Predicate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Junlin Zhou
 */
public class LogPipelineTests {

    @Test
    void lineFilterBuilderTest() {
        Predicate filter = LineFilterPredicate.op(FilterOperator.CONTAINS).value("foo").build();
        assertEquals("|= foo", filter.toString());
    }

    @Test
    void StringLabelPredicateBuilderTest() {
        final Predicate predicate = StringLabelPredicate.builder().key("foo")
                .op(LabelMatchingOperator.EQUAL)
                .value("bar")
                .build();
        assertEquals("foo = bar", predicate.toString());
    }

}
