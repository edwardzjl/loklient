package org.edwardzjl.loklient.query.pipeline.formatter;

import org.edwardzjl.loklient.query.structure.Expression;
import org.edwardzjl.loklient.query.structure.ExpressionBuilder;

/**
 * @author Junlin Zhou
 */
public class LineFormatter implements Expression {

    private static final String NAME = "line_format";

    private final String template;

    private LineFormatter(String template) {
        this.template = template;
    }

    public static LineFormatterBuilder builder() {
        return new LineFormatterBuilder();
    }

    @Override
    public String toString() {
        return "| " + NAME + " " + '`' + template + '`';
    }

    public static class LineFormatterBuilder implements ExpressionBuilder<LineFormatter> {

        private String template;

        private LineFormatterBuilder() {
        }

        public LineFormatterBuilder template(String template) {
            this.template = template;
            return this;
        }

        @Override
        public LineFormatter build() {
            return new LineFormatter(template);
        }
    }

}
