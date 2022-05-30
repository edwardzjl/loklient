package org.edwardzjl.loklient.query.pipeline.formatter;

/**
 * @author Junlin Zhou
 */
public class RawLabelFormatter extends LabelFormatter {

    public RawLabelFormatter(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return NAME + OP + value;
    }

}
