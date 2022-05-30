package org.edwardzjl.loklient.query.pipeline.formatter;

import org.edwardzjl.loklient.query.structure.Expression;

/**
 * A {@link LabelFormatter} can format a label from 2 sources:
 * <ul>
 *   <li>When both side are label identifiers, for example dst=src, the operation will rename the src label into dst.
 *   This falls into {@link RawLabelFormatter}</li>
 *   <li>The right side can alternatively be a template string (double quoted or backtick),
 *   for example dst="{{.status}} {{.query}}", in which case the dst label value is replaced by the result of the
 *   text/template evaluation. This falls into {@link StringLabelFormatter}</li>
 * </ul>
 * <p>
 * See <a href="https://grafana.com/docs/loki/latest/logql/log_queries/#labels-format-expression">this</a>
 *
 * @author Junlin Zhou
 */
public abstract class LabelFormatter implements Expression {

    protected static final String NAME = "label_format";

    protected static final String OP = "=";

    protected final String value;

    protected LabelFormatter(String value) {
        this.value = value;
    }

}
