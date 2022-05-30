package org.edwardzjl.loklient.query.pipeline.filter.label;

import org.edwardzjl.loklient.query.structure.Predicate;

/**
 * Only {@link LabelFilterPredicate} can be composed to {@link CompoundPredicate}
 * using {@link CompoundPredicate.BooleanOperator}.
 *
 * @author Junlin Zhou
 */
public abstract class LabelFilterPredicate implements Predicate {

    /**
     * A "| " indicates the following content is a label <strong>PREDICATE</strong>.
     */
    public String getHeader() {
        return "| ";
    }

    public abstract String getExpression();

    @Override
    public String toString() {
        return getHeader() + getExpression();
    }

}
