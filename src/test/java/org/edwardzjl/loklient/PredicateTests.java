package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.operators.LabelMatchingOperator;
import org.edwardzjl.loklient.query.pipeline.filter.label.CompoundPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.label.ErrorLabelPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.label.LabelFilterPredicate;
import org.edwardzjl.loklient.query.pipeline.filter.label.StringLabelPredicate;
import org.junit.jupiter.api.Test;

/**
 * @author Junlin Zhou
 */
public class PredicateTests {

    @Test
    void testCompoundPredicates() {
        LabelFilterPredicate p1 = StringLabelPredicate.builder().key("foo").op(LabelMatchingOperator.EQUAL).value("bar").build();
        LabelFilterPredicate p2 = ErrorLabelPredicate.builder().op(LabelMatchingOperator.EQUAL).value("").build();
        LabelFilterPredicate cp1 = CompoundPredicate.builder().operator(CompoundPredicate.BooleanOperator.AND).predicate(p1).predicate(p2).build();
        System.out.println(cp1);
        LabelFilterPredicate p3 = StringLabelPredicate.builder().key("foo2").op(LabelMatchingOperator.NOT_EQUAL).value("bar2").build();
        LabelFilterPredicate cp2 = CompoundPredicate.builder().operator(CompoundPredicate.BooleanOperator.OR).predicate(cp1).predicate(p3).build();
        System.out.println(cp2);
    }
}
