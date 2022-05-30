package org.edwardzjl.loklient.query.pipeline.filter.label;

import org.edwardzjl.loklient.query.structure.PredicateBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Junlin Zhou
 */
public class CompoundPredicate extends LabelFilterPredicate {

    private final BooleanOperator operator;
    private final List<LabelFilterPredicate> predicates;

    public enum BooleanOperator {
        AND("and"), OR("or");
        private final String op;

        BooleanOperator(String op) {
            this.op = op;
        }

        public String asDeliminator() {
            return " " + op + " ";
        }
    }

    private CompoundPredicate(BooleanOperator operator, List<LabelFilterPredicate> predicates) {
        this.operator = operator;
        this.predicates = predicates;
    }

    private CompoundPredicate(BooleanOperator operator, LabelFilterPredicate... predicates) {
        this(operator, Arrays.asList(predicates));
    }

    public static CompoundPredicateBuilder builder() {
        return new CompoundPredicateBuilder();
    }

    @Override
    public String getExpression() {
        String content = predicates.stream().map(LabelFilterPredicate::getExpression)
                .collect(Collectors.joining(operator.asDeliminator()));
        return "(" + content + ")";
    }

    public static class CompoundPredicateBuilder implements PredicateBuilder<CompoundPredicate> {
        private BooleanOperator operator;
        private List<LabelFilterPredicate> predicates;

        private CompoundPredicateBuilder() {
        }

        public CompoundPredicateBuilder operator(BooleanOperator operator) {
            this.operator = operator;
            return this;
        }

        public CompoundPredicateBuilder predicates(List<LabelFilterPredicate> predicates) {
            this.predicates = predicates;
            return this;
        }

        public CompoundPredicateBuilder predicate(LabelFilterPredicate predicate) {
            if (this.predicates == null) {
                this.predicates = new ArrayList<>();
            }
            this.predicates.add(predicate);
            return this;
        }

        @Override
        public CompoundPredicate build() {
            return new CompoundPredicate(operator, predicates);
        }

    }

}
