package org.edwardzjl.loklient.query.pipeline.formatter;

/**
 * @author Junlin Zhou
 */
public class StringLabelFormatter extends LabelFormatter {

    public StringLabelFormatter(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return NAME + OP + '`' + value + '`';
    }

}
