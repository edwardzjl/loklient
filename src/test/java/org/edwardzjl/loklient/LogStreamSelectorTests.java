package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.edwardzjl.loklient.query.structure.Predicate;
import org.edwardzjl.loklient.query.selector.LogStreamSelectorPredicate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Junlin Zhou
 */
public class LogStreamSelectorTests {

    @Test
    void predicateBuilderTest() {
        final Predicate predicate = LogStreamSelectorPredicate.builder()
                .key("foo")
                .op(LabelMatchingOperator.EQUAL)
                .value("bar")
                .build();
        assertEquals("foo = bar", predicate.toString());
    }

}